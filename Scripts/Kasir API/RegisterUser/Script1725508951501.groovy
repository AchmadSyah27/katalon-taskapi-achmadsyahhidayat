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
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import javassist.expr.Instanceof as Instanceof
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject

WS.comment('Melakukan daftar pada aplikasi kasir')

WebUI.callTestCase(findTestCase('Kasir API/AboutAplikasi'), [:], FailureHandling.STOP_ON_FAILURE)

'Melakukan registrasi pada aplikasi dengan inputan melalui sumber data pada file excel'
def response = WS.sendRequest(findTestObject('Auth/Registration'))

'Memastikan respon balikan service 200'
WS.verifyResponseStatusCode(response, 200)

'Mengambil value yang diinput pada email user'
def namatoko = WS.getElementPropertyValue(response, 'data.name')

println namatoko

def namatoko = WS.getElementPropertyValue(response, 'data.name')

