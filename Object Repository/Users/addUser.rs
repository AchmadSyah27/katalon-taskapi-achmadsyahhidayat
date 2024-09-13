<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Menambahkan user baru</description>
   <name>addUser</name>
   <tag></tag>
   <elementGuidId>87708f16-822e-44c2-a332-30fbc16352b3</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <authorizationRequest>
      <authorizationInfo>
         <entry>
            <key>bearerToken</key>
            <value>eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ImIxYWU1OGNhLWExYjUtNGMzNi1iNmUwLWQ1YWM2NzU1MDAzNyIsImNvbXBhbnlJZCI6ImM2NjQzYjNkLTFmYTAtNDcyYS1iMjQ5LTk0NWVjNDU3YzEyMyIsImlhdCI6MTY4NTEwMDUyM30.VlhKeAJPejvTvmJbjKtyrLnHLDDRGrGAZ1BryYYPz_A</value>
         </entry>
      </authorizationInfo>
      <authorizationType>Bearer</authorizationType>
   </authorizationRequest>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>-1</connectionTimeout>
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
      <webElementGuid>243a8923-89bd-4f02-a28e-78c4467b468c</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ImIxYWU1OGNhLWExYjUtNGMzNi1iNmUwLWQ1YWM2NzU1MDAzNyIsImNvbXBhbnlJZCI6ImM2NjQzYjNkLTFmYTAtNDcyYS1iMjQ5LTk0NWVjNDU3YzEyMyIsImlhdCI6MTY4NTEwMDUyM30.VlhKeAJPejvTvmJbjKtyrLnHLDDRGrGAZ1BryYYPz_A</value>
      <webElementGuid>1d38da76-6953-4a9d-a5d8-43fb0d302374</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.6.0</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${baseURL}/users</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.baseURL</defaultValue>
      <description>Melakukan hit status app</description>
      <id>d58374f7-e2eb-4910-aac4-4806835a0e8e</id>
      <masked>false</masked>
      <name>baseURL</name>
   </variables>
   <variables>
      <defaultValue>findTestData('DataTest').getValue(1, 1)</defaultValue>
      <description></description>
      <id>39f80dcd-1955-4d84-af30-b032a905fd5e</id>
      <masked>false</masked>
      <name>name</name>
   </variables>
   <variables>
      <defaultValue>findTestData('DataTest').getValue(2, 2)</defaultValue>
      <description></description>
      <id>7a5cc084-8b93-45d3-9aa9-452a17296213</id>
      <masked>false</masked>
      <name>email</name>
   </variables>
   <variables>
      <defaultValue>findTestData('DataTest').getValue(3, 2)</defaultValue>
      <description></description>
      <id>0b939032-d6b1-461e-b066-8d281332b938</id>
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

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
