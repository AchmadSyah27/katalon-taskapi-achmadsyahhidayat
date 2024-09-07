package apiPackage

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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import net.sf.jasperreports.engine.VariableReturnValue

public class verifyExpectedResponse {

	@Keyword
	def verifyResponSalah(String objectnya) {
		'Menentukan object yang akan digunakan'
		RequestObject iniobjectnya = findTestObject(objectnya)

		'Melakukan request API'
		ResponseObject response = WS.sendRequest(iniobjectnya)

		'Mendapatkan isi dari body response'
		String responseBody = response.getResponseBodyContent()

		'Mengembalikan isi dari body response'
		return responseBody
	}
	
	@Keyword
	def readServiceContent(String testObject) {
		def response = WS.sendRequest(testObject)
		
		statusApp = WS.getElementPropertyValue(response, 'data.status')
		
		return
	}
}
