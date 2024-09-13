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
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import static org.junit.Assert.assertEquals

def slurper = new JsonSlurper()

WebUI.callTestCase(findTestCase('Kasir API/AboutAplikasi'), [:], FailureHandling.STOP_ON_FAILURE)

'Melakukan hit service registration'
def response = WS.sendRequestAndVerify(findTestObject('Auth/Registration'))

'Mendapatkan isi konten dari service'
def getContent = slurper.parseText(response.getResponseBodyContent())

println(getContent)

'Mengambil isi konten nama yang didaftarkan'
String getValueName = getContent.data.name

println(getValueName)

'Mengambil isi konten email yang didaftarkan'
String getValueEmail = getContent.data.email

println(getValueEmail)

'Mengambil data nama dari excel yang diinput ke sistem'
DataInputNama = findTestData('DataTest').getValue(1, 1)

println(DataInputNama)

'Memastikan inputan data nama dari file excel dengan respon balikan nama dari api sesuai'
assertEquals(getValueName, DataInputNama)

'Mengambil data email dari excel yang diinput ke sistem'
DataInputEmail = findTestData('DataTest').getValue(2, 1)

println(DataInputEmail)

'Memastikan inputan data email dari file excel dengan respon balikan email dari api sesuai'
assertEquals(getValueEmail, DataInputEmail)

