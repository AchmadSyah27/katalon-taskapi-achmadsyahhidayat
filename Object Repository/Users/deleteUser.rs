<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>deleteUser</name>
   <tag></tag>
   <elementGuidId>3054c68e-de1f-4b6f-aae3-2b15c3504bb4</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <authorizationRequest>
      <authorizationInfo>
         <entry>
            <key>bearerToken</key>
            <value>eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjZhY2RjNTRiLWJhYjctNGM0MS04YTBjLTM1NDRkM2QzNDBmMyIsImNvbXBhbnlJZCI6ImJmZDU0ZDRkLTI2ODgtNGVjYi05MWU1LThmZGQ3NDY5ZWRmMyIsImlhdCI6MTcyNjM0NTU5OX0.n7i4iUWtQfW5b4cYqucP7jTd3w2xtuVCt0v5NMyuQzI</value>
         </entry>
      </authorizationInfo>
      <authorizationType>Bearer</authorizationType>
   </authorizationRequest>
   <autoUpdateContent>true</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjZhY2RjNTRiLWJhYjctNGM0MS04YTBjLTM1NDRkM2QzNDBmMyIsImNvbXBhbnlJZCI6ImJmZDU0ZDRkLTI2ODgtNGVjYi05MWU1LThmZGQ3NDY5ZWRmMyIsImlhdCI6MTcyNjM0NTU5OX0.n7i4iUWtQfW5b4cYqucP7jTd3w2xtuVCt0v5NMyuQzI</value>
      <webElementGuid>cf7e3cde-cdd6-442c-b921-8cc76c83600d</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.6.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>DELETE</restRequestMethod>
   <restUrl>${baseURL}/users/</restUrl>
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
      <description>URL API Test Automation</description>
      <id>d8f4cd0a-c7ae-4176-9dde-17cbf47cb4a1</id>
      <masked>false</masked>
      <name>baseURL</name>
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
