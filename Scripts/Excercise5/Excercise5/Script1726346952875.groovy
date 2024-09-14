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

'====================Melakukan login===================='

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
accessToken = WS.getElementPropertyValue(response, 'data.accessToken')

'Menempatkan refresh token kedalam variable'
RefreshToken = WS.getElementPropertyValue(response, 'data.refreshToken')

'Memasukkan access token kedalam global variable'
GlobalVariable.aksesToken = accessToken

'Memasukkan refresh token kedalam global variable'
GlobalVariable.refreshToken = RefreshToken

println('accessToken terbaru adalah ' + accessToken)

println('refreshToken terbaru adalah ' + RefreshToken)

'============================================================'

'====================Melakukan refresh token===================='

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

println('status refresh token = ' + getStatusRefreshToken)

println('message message refresh token = ' + getMessageRefreshToken)

println('akses token baru = ' + getRefreshToken)

'============================================================'

//'====================Melakukan get user===================='
//
//'Melakukan hit service addUser'
//def response4 = WS.sendRequestAndVerify(findTestObject('Users/getUser', [('baseURL') : GlobalVariable.baseURL, ('aksesToken') : GlobalVariable.aksesToken]))
//
//'Memastikan response service 200'
//WS.verifyResponseStatusCode(response4, 200)
//
//'Mendapatkan isi konten dari service'
//def getContent4 = slurper.parseText(response4.getResponseBodyContent())
//
//println(getContent4)
//
//'Mengambil email yang digunakan untuk login'
//String statusGetUser = getContent4.status
//
//'Mengambil isi akses token login'
//String getNamaUsers = getContent4.data.users[0].name
//
//'Mengambil isi refresh token login'
//String getEmailUsers = getContent4.data.users[0].email
//
//
//println('status get usernya adalah ' + statusGetUser)
//
//println('nama usernya adalah ' + getNamaUsers)
//
//println('email user-nya adalah ' + getEmailUsers)
//'============================================================'
//
//'====================Melakukan delete user===================='
//'Melakukan hit service addUser'
//def response5 = WS.sendRequestAndVerify(findTestObject('Users/getUser', [('baseURL') : GlobalVariable.baseURL, ('aksesToken') : GlobalVariable.aksesToken]))
//
//'Memastikan response service 200'
//WS.verifyResponseStatusCode(response5, 200)
//'============================================================'
//
//'====================Melakukan add user===================='
//
//'Melakukan hit service addUser'
//def response2 = WS.sendRequestAndVerify(findTestObject('Users/addUser', [('baseURL') : GlobalVariable.baseURL, ('name') : findTestData(
//                'DataTest').getValue(1, 2), ('email') : findTestData('DataTest').getValue(2, 2), ('password') : findTestData(
//                'DataTest').getValue(3, 2), ('aksesToken') : GlobalVariable.aksesToken]))
//
//'Memastikan response service 201'
//WS.verifyResponseStatusCode(response2, 201)
//
//'Mendapatkan isi konten dari service'
//def getContent2 = slurper.parseText(response.getResponseBodyContent())
//
//println(getContent2)
//
//'Mengambil isi akses token login'
//String getStatusAdd = getContent2.status
//
//'Mengambil isi refresh token login'
//String getMessageService = getContent2.message
//
//'Mengambil email yang digunakan untuk login'
//String valueUserID = getContent2.data.userId
//
//'Mengambil email yang digunakan untuk login'
//String valueNamaUser = getConten2t.data.name
//
//println('status tambah usernya adalah ' + getStatusAdd)
//
//println('message tambah usernya adalah ' + getMessageService)
//
//println('user id-nya adalah ' + valueUserID)
//
//println('nama user-nya adalah ' + valueNamaUser)
//
//'============================================================'

//'Menempatkan refresh token kedalam variable'
//NewToken = WS.getElementPropertyValue(response1, 'data.refreshToken')
//'Memasukkan refresh token kedalam global variable'
//GlobalVariable.refreshToken = NewToken
'====================Melakukan logout===================='

'Melakukan hit service untuk logout'
def response3 = WS.sendRequest(findTestObject('Auth/Logout', [('baseURL') : GlobalVariable.baseURL, ('refreshToken') : GlobalVariable.refreshToken]))

'Memastikan response logout berhasil dengan balikan service 200'
WS.verifyResponseStatusCode(response3, 200)

'Mendapatkan isi konten dari service'
def getContent3 = slurper.parseText(response3.getResponseBodyContent())

'Mengambil isi status logout'
String getStatusLogout = getContent3.status

'Mengambil isi pesan logout'
String getMessageLogout = getContent3.message

println('status logout = ' + getStatusLogout)

println('status logout = ' + getMessageLogout)

'============================================================'

