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

'Precondition: Admin sudah login'
WebUI.callTestCase(findTestCase('Kasir API/Login'), [:], FailureHandling.STOP_ON_FAILURE)

'Melakukan hit service addUser'
def response = WS.sendRequestAndVerify(findTestObject('Users/addUser', [('baseURL') : GlobalVariable.baseURL, ('name') : findTestData('DataTest').getValue(
                1, 2), ('email') : findTestData('DataTest').getValue(2, 2), ('password') : findTestData('DataTest').getValue(
                3, 2)]))

'Memastikan response service 201'
WS.verifyResponseStatusCode(response, 201)

'Mendapatkan isi konten dari service'
def getContent = slurper.parseText(response.getResponseBodyContent())

println(getContent)

'Mengambil isi akses token login'
String getStatusAdd = getContent.status

'Mengambil isi refresh token login'
String getMessageService = getContent.message

'Mengambil email yang digunakan untuk login'
String valueUserID = getContent.data.userId

'Mengambil email yang digunakan untuk login'
String valueNamaUser = getContent.data.name

println('status tambah usernya adalah ' + getStatusAdd)

println('message tambah usernya adalah ' + getMessageService)

println('user id-nya adalah ' + valueUserID)

println('nama user-nya adalah ' + valueNamaUser)

//'Menempatkan refresh token kedalam variable'
//RefreshToken = WS.getElementPropertyValue(response, 'data.refreshToken')
//
//'Memasukkan refresh token kedalam global variable'
//GlobalVariable.refreshToken = RefreshToken