package pkgGeneral

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class kwdUtilities {

	/************************************************
	 * LOGIN										*
	 * Login a l sitio								*
	 * Parametros:									*
	 * - Usuario									*
	 * - Password									*
	 ************************************************/
	@Keyword
	def static fLogin(vUser, vPswd){
		WebUI.openBrowser(GlobalVariable.vURL)
		WebUI.maximizeWindow()
		WebUI.setText(findTestObject('Object Repository/01-Login/input_name'), GlobalVariable.vUser)
		WebUI.setText(findTestObject('Object Repository/01-Login/input_email'), GlobalVariable.vEmail)
		WebUI.setText(findTestObject('Object Repository/01-Login/input_password'), GlobalVariable.vPswd)
		WebUI.click(findTestObject('Object Repository/01-Login/bttn_register'))
	}
}
