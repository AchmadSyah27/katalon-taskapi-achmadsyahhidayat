<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Menambahkan Author baru</description>
   <name>Registration</name>
   <tag></tag>
   <elementGuidId>551cc632-2994-48bd-acd6-0501573a0e29</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;name\&quot;: \&quot;${name}\&quot;,\n    \&quot;email\&quot;: \&quot;${email}\&quot;,\n    \&quot;password\&quot;: \&quot;${password}\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>b57c6c3b-1c3c-4135-9ae3-1925fb8666d1</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.6.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${baseURL}/registration?name=${name}&amp;email=${email}&amp;password=${password}&amp;statusDaftar=${statusDaftar}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.baseURL</defaultValue>
      <description>Memulai dengan URL yang terdapat pada global variable</description>
      <id>c8c1dd61-3eb0-40bc-892e-5d1805a6f8b7</id>
      <masked>false</masked>
      <name>baseURL</name>
   </variables>
   <variables>
      <defaultValue>findTestData('DataTest').getValue(2, 1)</defaultValue>
      <description>Melakukan input nama yang bersumber dari file excel</description>
      <id>be02a8ee-1b29-4b49-98cd-bbac8ee06ff1</id>
      <masked>false</masked>
      <name>name</name>
   </variables>
   <variables>
      <defaultValue>findTestData('DataTest').getValue(3, 1)</defaultValue>
      <description>Melakukan input email yang bersumber dari file excel</description>
      <id>397aee35-4ccf-4899-82ec-9dfe00625c7a</id>
      <masked>false</masked>
      <name>email</name>
   </variables>
   <variables>
      <defaultValue>findTestData('DataTest').getValue(4, 1)</defaultValue>
      <description>Melakukan input password yang bersumber dari file excel</description>
      <id>dbbc8f19-19e0-473b-a725-83f0a7b5bf49</id>
      <masked>false</masked>
      <name>password</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

'Memastikan respon balikan service 200'
WS.verifyResponseStatusCode(response, 200)

assertThat(response.getStatusCode()).isEqualTo(200)

'Memastikan status pendaftaran toko sukses'
def statusDaftar = WS.verifyElementPropertyValue(response, 'status', &quot;success&quot;)
WS.verifyElementPropertyValue(response, 'data.name', &quot;Andrian&quot;)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
