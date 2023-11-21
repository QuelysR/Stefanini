package pkgLGN
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class kwdLogin {
	/**
	 * Steps definitions para login happy case
	 */
	
	//given acceso a la pagina
	@Given("Como un usuario")
	def fLoadPage() {
		println ('/n Se accede a la pagina principal')
		WebUI.openBrowser(GlobalVariable.vURL)
		WebUI.maximizeWindow()
	}

	
	//when ingreso de nombre y apellido completo
	@When("Ingreso mi nombre y apellido")
	def fUser() {
		println ('/n Se coloca usuario')
		WebUI.setText(findTestObject('Object Repository/01-Login/input_name'), GlobalVariable.vUser)
	}

	//and ingreso el email correctamente
	@And("Ingreso mi email")
	def fEmail() {
		println ('/n Se coloca email')
		WebUI.setText(findTestObject('Object Repository/01-Login/input_email'), GlobalVariable.vEmail)
	}

	// and ingresa el password correctamente
	@And("Ingreso mi password")
	def fPassword() {
		println ('/n Se coloca password')
		WebUI.setText(findTestObject('Object Repository/01-Login/input_password'), GlobalVariable.vPswd)
	}

	
	//then valido el usuario registrado
	@Then("Verifico registro de usuario creado")
	def fVerify_Registro() {
		println ('/n Se verifica que el usuario se haya creado Correctamente')
		WebUI.click(findTestObject('Object Repository/01-Login/bttn_register'))
		WebUI.delay(2)
		WebUI.verifyTextPresent(GlobalVariable.vUser, true)
		WebUI.closeBrowser()
	}
	
	
	//when ingreso nombre imcompleto
	@When("Ingreso mi nombre icorrecto")
	def fIngreso_nombre_incompleto() {
		println ('/n Se verifica que el nombre sea incorrecto')
		WebUI.setText(findTestObject('Object Repository/01-Login/input_name'), GlobalVariable.vUserInv)
	}

	//then valido error en el nombre 
	@Then("Verifico error en nombre")
	def fVerify_Error_name() {
		WebUI.click(findTestObject('Object Repository/01-Login/bttn_register'))
		WebUI.delay(2)
		println ('/n Se verifica que el nombre sea incorrecto')
		WebUI.verifyTextPresent(GlobalVariable.textNameInv, true)
		WebUI.closeBrowser()
		
	}
	
	//and ingreso error en el email
	@And("Ingreso mi email incorrecto")
	def fIngreso_Error_en_el_email() {
		println ('/n Se ingresa un email incorrecto')
		WebUI.setText(findTestObject('Object Repository/01-Login/input_email'), GlobalVariable.vEmailInv)
		
	}
	
	//then valido error en el email
	@Then("Verifico error en el email")
	def fVerify_Error_email() {
		WebUI.click(findTestObject('Object Repository/01-Login/bttn_register'))
		WebUI.delay(2)
		println ('/n Se verifica que el email sea incorrecto')
		WebUI.verifyTextPresent(GlobalVariable.textEmailInv, true)
		WebUI.closeBrowser()
		
	}
	
	//and ingreso error en el password
	@And("Ingreso mi password incorrecto")
	def fIngreso_Error_en_el_password() {
		println ('/n Se ingresa un password incorrecto')
		WebUI.setText(findTestObject('Object Repository/01-Login/input_password'), GlobalVariable.vPswdInv)
		
	}
	
	//then valido error en el password
	@Then("Verifico error en el password")
	def fVerify_Error_password() {
		WebUI.click(findTestObject('Object Repository/01-Login/bttn_register'))
		WebUI.delay(2)
		println ('/n Se verifica que el password sea incorrecto')
		WebUI.verifyTextPresent(GlobalVariable.textPswd, true)
		WebUI.closeBrowser()
		
	}
	
}