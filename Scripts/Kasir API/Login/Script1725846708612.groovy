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

def slurper = new JsonSlurper()

'Melakukan hit service untuk mendapatkan status aplikasi'
WebUI.callTestCase(findTestCase('Kasir API/AboutAplikasi'), [:], FailureHandling.STOP_ON_FAILURE)

'Melakukan hit service login dengan data bersumber dari excel'
def response = WS.sendRequestAndVerify(findTestObject('Auth/Login', [('baseURL') : GlobalVariable.baseURL, ('email') : findTestData(
                'DataTest').getValue(2, 1), ('password') : findTestData('DataTest').getValue(3, 1)]))

'Memastikan response service 201'
WS.verifyResponseStatusCode(response, 201)

'Mendapatkan isi konten dari service'
def getContent = slurper.parseText(response.getResponseBodyContent())

println(getContent)

'Mengambil isi akses token login'
String getValueAksesToken = getContent.data.accessToken

'Mengambil isi refresh token login'
String getValueRefreshToken = getContent.data.refreshToken

'Mengambil email yang digunakan untuk login'
String valueEmail = getContent.data.user.email

println('akses tokennya adalah ' + getValueAksesToken)

println('refresh tokennya adalah ' + getValueRefreshToken)

println('email yang digunakan adalah ' + valueEmail)

'Menempatkan refresh token kedalam variable'
RefreshToken = WS.getElementPropertyValue(response, 'data.refreshToken')

'Memasukkan refresh token kedalam global variable'
GlobalVariable.refreshToken = RefreshToken

'Melakukan hit service refresh token untuk mendapatkan token terbaru'
def response1 = WS.sendRequestAndVerify(findTestObject('Auth/refreshToken', [('baseURL') : GlobalVariable.baseURL, ('refreshToken') : GlobalVariable.refreshToken]))

'Memastikan response logout berhasil dengan balikan service 200'
WS.verifyResponseStatusCode(response1, 200)

'Mendapatkan isi konten dari service'
def getContent1 = slurper.parseText(response1.getResponseBodyContent())

'Mengambil isi status refresh token'
String getStatusRefreshToken = getContent1.status

'Mengambil isi pesan refresh token'
String getMessageRefreshToken = getContent1.message

'Mengambil isi refresh token'
String getRefreshToken = getContent1.data.accessToken

println('status logout = ' + getStatusRefreshToken)

println('message logout = ' + getMessageRefreshToken)

println('akses token baru = ' + getRefreshToken)

//'Menempatkan refresh token kedalam variable'
//NewToken = WS.getElementPropertyValue(response1, 'data.refreshToken')

//'Memasukkan refresh token kedalam global variable'
//GlobalVariable.refreshToken = NewToken

'Melakukan hit service untuk logout'
def response2 = WS.sendRequest(findTestObject('Auth/Delete_user', [('baseURL') : GlobalVariable.baseURL, ('refreshToken') : GlobalVariable.refreshToken]))

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

