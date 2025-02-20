import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.Variable as Variable
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.testobject.HttpBodyContent as HttpBodyContent
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import static org.junit.Assert.assertEquals
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent as HttpTextBodyContent

'Melakukan hit service untuk logout'
def response2 = WS.sendRequest(findTestObject('Auth/Logout', [('baseURL') : GlobalVariable.baseURL, ('refreshToken') : GlobalVariable.refreshToken]))

'Memastikan response logout berhasil dengan balikan service 200'
WS.verifyResponseStatusCode(response2, 200)

'Mendapatkan isi konten dari service'
def getContent2 = slurper.parseText(response2.getResponseBodyContent())

'Mengambil isi status logout'
String getStatusLogout = getContent2.status

'Mengambil isi pesan logout'
String getMessageLogout = getContent2.message

println('status logout = ' + getStatusLogout)

println('status logout = ' + getMessageLogout)