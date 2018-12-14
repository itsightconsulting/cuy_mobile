<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://webservices.daytonfreight.com/" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:s1="http://webservices.daytonfreight.com/AbstractTypes" xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" targetNamespace="http://webservices.daytonfreight.com/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://webservices.daytonfreight.com/">
      <s:element name="SendAdditionalPickupEmails">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="pickupNumber" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="sendReceiptTo" type="tns:ArrayOfString" />
            <s:element minOccurs="0" maxOccurs="1" name="sendConfirmationTo" type="tns:ArrayOfString" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfString">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="string" nillable="true" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="SendAdditionalPickupEmailsResponse">
        <s:complexType />
      </s:element>
      <s:element name="Credentials" type="tns:Credentials" />
      <s:complexType name="Credentials">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="UserName" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Password" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="InternalStateObject" type="s:string" />
        </s:sequence>
        <s:anyAttribute />
      </s:complexType>
      <s:element name="GetGuaranteedServiceInformation">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="originZipcode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="destinationZipcode" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="pickupDate" type="s:dateTime" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetGuaranteedServiceInformationResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetGuaranteedServiceInformationResult" type="tns:GuaranteedServiceInformation" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="GuaranteedServiceInformation">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="EstimatedDeliveryDate" type="s:dateTime" />
          <s:element minOccurs="1" maxOccurs="1" name="TransitDays" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="OriginZipcode" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="DestinationZipcode" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ServiceOptions" type="tns:ArrayOfServiceOptionInformation" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ArrayOfServiceOptionInformation">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="ServiceOptionInformation" nillable="true" type="tns:ServiceOptionInformation" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ServiceOptionInformation">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="OptionName" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="OptionAbbr" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="AccessorialCode" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetServiceCenterInformation">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="abbreviation" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetServiceCenterInformationResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetServiceCenterInformationResult" type="tns:ServiceCenter" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ServiceCenter">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="ID" type="tns:ServiceCenterID" />
          <s:element minOccurs="0" maxOccurs="1" name="Abbreviation" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Address" type="tns:Address" />
          <s:element minOccurs="1" maxOccurs="1" name="RemotePhoneNumber" type="tns:PhoneNumber" />
          <s:element minOccurs="1" maxOccurs="1" name="LocalPhoneNumber" type="tns:PhoneNumber" />
          <s:element minOccurs="1" maxOccurs="1" name="FaxNumber" type="tns:PhoneNumber" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ServiceCenterID">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="Abbreviation" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="Number" type="s:short" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="Address">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="AccountCode" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="AddressName" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Address1" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Address2" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="City" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="State" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ZipCode" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ZipCode4" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="PhoneNumber">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="AreaCode" type="s:short" />
          <s:element minOccurs="1" maxOccurs="1" name="Prefix" type="s:short" />
          <s:element minOccurs="1" maxOccurs="1" name="Number" type="s:short" />
          <s:element minOccurs="0" maxOccurs="1" name="Extension" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetAllServiceCenterInformation">
        <s:complexType />
      </s:element>
      <s:element name="GetAllServiceCenterInformationResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetAllServiceCenterInformationResult" type="tns:ArrayOfServiceCenter" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfServiceCenter">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="ServiceCenter" nillable="true" type="tns:ServiceCenter" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetShipmentClasses">
        <s:complexType />
      </s:element>
      <s:element name="GetShipmentClassesResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetShipmentClassesResult" type="tns:ArrayOfString" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetPackaging">
        <s:complexType />
      </s:element>
      <s:element name="GetPackagingResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetPackagingResult" type="tns:ArrayOfNameValuePair" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfNameValuePair">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="NameValuePair" nillable="true" type="tns:NameValuePair" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="NameValuePair">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="Name" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Value" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetTransitTime">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="originZipcode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="destinationZipcode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="TransitTimeResult">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="OriginCity" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="OriginState" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="OriginZipcode" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="OriginPartner" type="tns:PartnerInformation" />
          <s:element minOccurs="0" maxOccurs="1" name="OriginServiceCenter" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="OriginServiceCenterPhoneNumber" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="DestinationCity" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="DestinationState" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="DestinationZipcode" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="DestinationPartner" type="tns:PartnerInformation" />
          <s:element minOccurs="0" maxOccurs="1" name="DestinationServiceCenter" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="DestinationServiceCenterPhoneNumber" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="TotalServiceDays" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="GuaranteedServiceOptions" type="tns:ArrayOfString" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="PartnerInformation">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="ProNumber" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="SCAC" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Name" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetTransitTimeResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetTransitTimeResult" type="tns:TransitTimeResult" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="Rate">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="customerNumber" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="terms" type="tns:Terms" />
            <s:element minOccurs="0" maxOccurs="1" name="originZipcode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="destinationZipcode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="guaranteedServiceOption" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="rateShipmentDetails" type="tns:ArrayOfRateShipmentInformation" />
            <s:element minOccurs="0" maxOccurs="1" name="accessorialCodes" type="tns:ArrayOfString" />
            <s:element minOccurs="1" maxOccurs="1" name="numberOfSkids" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:simpleType name="Terms">
        <s:restriction base="s:string">
          <s:enumeration value="Prepaid" />
          <s:enumeration value="Collect" />
          <s:enumeration value="ThirdParty" />
          <s:enumeration value="ThirdPartyPrepaid" />
          <s:enumeration value="ThirdPartyCollect" />
        </s:restriction>
      </s:simpleType>
      <s:complexType name="ArrayOfRateShipmentInformation">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="RateShipmentInformation" nillable="true" type="tns:RateShipmentInformation" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="RateShipmentInformation">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="Class" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="Weight" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="HandlingUnits" type="s:int" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="RateResult">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="RateNumber" type="s:long" />
          <s:element minOccurs="0" maxOccurs="1" name="CustomerNumber" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="EncryptedRateNumber" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="FuelSurcharge" type="s:double" />
          <s:element minOccurs="1" maxOccurs="1" name="Discount" type="s:double" />
          <s:element minOccurs="1" maxOccurs="1" name="DiscountPercentage" type="s:double" />
          <s:element minOccurs="1" maxOccurs="1" name="ItemGross" type="s:double" />
          <s:element minOccurs="1" maxOccurs="1" name="Gross" type="s:double" />
          <s:element minOccurs="1" maxOccurs="1" name="GrossDeficientTotal" type="s:double" />
          <s:element minOccurs="1" maxOccurs="1" name="DeficientWeightRate" type="s:double" />
          <s:element minOccurs="1" maxOccurs="1" name="DeficientWeight" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="AdditionalChargesTotal" type="s:double" />
          <s:element minOccurs="1" maxOccurs="1" name="Total" type="s:double" />
          <s:element minOccurs="0" maxOccurs="1" name="Origin" type="tns:Address" />
          <s:element minOccurs="0" maxOccurs="1" name="Destination" type="tns:Address" />
          <s:element minOccurs="1" maxOccurs="1" name="Terms" type="tns:Terms" />
          <s:element minOccurs="0" maxOccurs="1" name="Items" type="tns:ArrayOfRateItemInformation" />
          <s:element minOccurs="0" maxOccurs="1" name="Accessorials" type="tns:ArrayOfAccessorialDetailInformation" />
          <s:element minOccurs="0" maxOccurs="1" name="AuditInformation" type="tns:RateAuditInformation" />
          <s:element minOccurs="1" maxOccurs="1" name="NumberOfSkids" type="s:int" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ArrayOfRateItemInformation">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="RateItemInformation" nillable="true" type="tns:RateItemInformation" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="RateItemInformation">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="Weight" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="HandlingUnits" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="Class" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="Rate" type="s:double" />
          <s:element minOccurs="1" maxOccurs="1" name="Gross" type="s:double" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ArrayOfAccessorialDetailInformation">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="AccessorialDetailInformation" nillable="true" type="tns:AccessorialDetailInformation" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="AccessorialDetailInformation">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="Code" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Description" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="Amount" type="s:double" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="RateAuditInformation">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="AuditLine1" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="AuditLine2" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ErrorDescription" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="RateResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="RateResult" type="tns:RateResult" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetRateQuote">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="encryptedRateNumber" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetRateQuoteResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetRateQuoteResult" type="tns:RateResult" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="CreatePickup">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="pickupInformation" type="tns:PickupInformation" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="PickupInformation">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="PickupNumber" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="CustomerReferenceNumber" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ShipperAddress" type="tns:Address" />
          <s:element minOccurs="0" maxOccurs="1" name="PickupInstructions" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="BillingInstructions" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Shipments" type="tns:ArrayOfShipmentInformation" />
          <s:element minOccurs="0" maxOccurs="1" name="SendConfirmationTo" type="tns:ArrayOfString" />
          <s:element minOccurs="0" maxOccurs="1" name="SendReceiptTo" type="tns:ArrayOfString" />
          <s:element minOccurs="1" maxOccurs="1" name="Ready" type="s:dateTime" />
          <s:element minOccurs="1" maxOccurs="1" name="Close" type="tns:MilitaryTime" />
          <s:element minOccurs="0" maxOccurs="1" name="Contact" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ContactPhoneNumber" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ContactPhoneExtension" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="RequestorPhoneNumber" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="RequestorPhoneExtension" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="RequestorName" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="Created" type="s:dateTime" />
          <s:element minOccurs="1" maxOccurs="1" name="Status" type="tns:PickupStatus" />
          <s:element minOccurs="0" maxOccurs="1" name="PartnerScac" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="PartnerPickupNumber" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ArrayOfShipmentInformation">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="ShipmentInformation" nillable="true" type="tns:ShipmentInformation" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ShipmentInformation">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="DestinationZipCode" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="HandlingUnits" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="Weight" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="IsHazardous" type="s:boolean" />
          <s:element minOccurs="1" maxOccurs="1" name="IsExpedited" type="s:boolean" />
          <s:element minOccurs="1" maxOccurs="1" name="IsFood" type="s:boolean" />
          <s:element minOccurs="1" maxOccurs="1" name="IsPoisonous" type="s:boolean" />
          <s:element minOccurs="0" maxOccurs="1" name="AdditionalFlags" type="tns:ArrayOfString" />
          <s:element minOccurs="0" maxOccurs="1" name="GuaranteedServiceOption" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Comments" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="MilitaryTime">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="Hour" type="s:short" />
          <s:element minOccurs="1" maxOccurs="1" name="Minute" type="s:short" />
        </s:sequence>
      </s:complexType>
      <s:simpleType name="PickupStatus">
        <s:restriction base="s:string">
          <s:enumeration value="Assigned" />
          <s:enumeration value="Canceled" />
          <s:enumeration value="PickedUp" />
          <s:enumeration value="None" />
          <s:enumeration value="PartnerScheduling" />
          <s:enumeration value="PartnerScheduled" />
        </s:restriction>
      </s:simpleType>
      <s:element name="CreatePickupResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="CreatePickupResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="UpdatePickup">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="pickupNumber" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="pickupInformation" type="tns:PickupInformation" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="UpdatePickupResponse">
        <s:complexType />
      </s:element>
      <s:element name="CancelPickup">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="pickupNumber" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="CancelPickupResponse">
        <s:complexType />
      </s:element>
      <s:element name="GetPickup">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="pickupNumber" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetPickupResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetPickupResult" type="tns:PickupInformation" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetPickupHistory">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="startDate" type="s:dateTime" />
            <s:element minOccurs="1" maxOccurs="1" name="endDate" type="s:dateTime" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfPickupInformation">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="PickupInformation" nillable="true" type="tns:PickupInformation" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetPickupHistoryResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetPickupHistoryResult" type="tns:ArrayOfPickupInformation" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="CreateBillOfLading">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="billOfLadingInformation" type="tns:BillOfLadingInformation" />
            <s:element minOccurs="1" maxOccurs="1" name="saveCopy" type="s:boolean" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="BillOfLadingInformation">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="Id" type="s:long" />
          <s:element minOccurs="0" maxOccurs="1" name="User" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Name" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="HazardousMaterial" type="s:boolean" />
          <s:element minOccurs="0" maxOccurs="1" name="ShipperAddress" type="tns:Address" />
          <s:element minOccurs="0" maxOccurs="1" name="ShipperContactName" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ShipperContactPhone" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ShipperContactExtension" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ConsigneeAddress" type="tns:Address" />
          <s:element minOccurs="0" maxOccurs="1" name="ConsigneeContactName" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ConsigneeContactPhone" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ConsigneeContactExtension" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ThirdPartyAddress" type="tns:Address" />
          <s:element minOccurs="0" maxOccurs="1" name="ThirdPartyContactName" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ThirdPartyContactPhone" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ThirdPartyContactExtension" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="BillOfLadingItems" type="tns:ArrayOfBillOfLadingItemInformation" />
          <s:element minOccurs="0" maxOccurs="1" name="EmergencyContactName" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="EmergencyContactPhone" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ShipperNumber" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="CarrierNumber" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="BolNumber" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="Terms" type="tns:Terms" />
          <s:element minOccurs="1" maxOccurs="1" name="IsCod" type="s:boolean" />
          <s:element minOccurs="1" maxOccurs="1" name="CodAmount" type="s:float" />
          <s:element minOccurs="1" maxOccurs="1" name="CompanyCheckAcceptable" type="s:boolean" />
          <s:element minOccurs="1" maxOccurs="1" name="CodTerms" type="tns:Terms" />
          <s:element minOccurs="0" maxOccurs="1" name="RemitAddress" type="tns:Address" />
          <s:element minOccurs="0" maxOccurs="1" name="Comments" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="PerLbDeclaredValue" type="s:float" />
          <s:element minOccurs="0" maxOccurs="1" name="POItems" type="tns:ArrayOfPOItemInformation" />
          <s:element minOccurs="0" maxOccurs="1" name="GuaranteedServiceOption" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="Created" type="s:dateTime" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ArrayOfBillOfLadingItemInformation">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="BillOfLadingItemInformation" nillable="true" type="tns:BillOfLadingItemInformation" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="BillOfLadingItemInformation">
        <s:sequence>
          <s:element minOccurs="1" maxOccurs="1" name="HandlingUnits" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="Packaging" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="Weight" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="HazardousMaterial" type="s:boolean" />
          <s:element minOccurs="0" maxOccurs="1" name="ShipmentClass" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="NmfcClass" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="NmfcSubClass" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ItemDescription" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="ArrayOfPOItemInformation">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="POItemInformation" nillable="true" type="tns:POItemInformation" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="POItemInformation">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="PONumber" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="HandlingUnits" type="s:int" />
          <s:element minOccurs="1" maxOccurs="1" name="Weight" type="s:int" />
        </s:sequence>
      </s:complexType>
      <s:element name="CreateBillOfLadingResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="CreateBillOfLadingResult" type="s:long" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="DeleteBillOfLading">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="billOfLadingId" type="s:long" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="DeleteBillOfLadingResponse">
        <s:complexType />
      </s:element>
      <s:element name="UpdateBillOfLading">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="billOfLadingInformation" type="tns:BillOfLadingInformation" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="UpdateBillOfLadingResponse">
        <s:complexType />
      </s:element>
      <s:element name="GetBillOfLadingInformation">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="billOfLadingId" type="s:long" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetBillOfLadingInformationResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetBillOfLadingInformationResult" type="tns:BillOfLadingInformation" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetBillOfLadingHistory">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="startDate" type="s:dateTime" />
            <s:element minOccurs="1" maxOccurs="1" name="endDate" type="s:dateTime" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfBillOfLadingInformation">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="BillOfLadingInformation" nillable="true" type="tns:BillOfLadingInformation" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetBillOfLadingHistoryResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetBillOfLadingHistoryResult" type="tns:ArrayOfBillOfLadingInformation" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetShipmentServiceOptions">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="originZipcode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="destinationZipcode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetShipmentServiceOptionsResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetShipmentServiceOptionsResult" type="tns:ArrayOfString" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetAccessorials">
        <s:complexType />
      </s:element>
      <s:element name="GetAccessorialsResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetAccessorialsResult" type="tns:ArrayOfAccessorialDetailInformation" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="PrintDflBillOfLading">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="bolId" type="s:long" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="PrintDflBillOfLadingResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="PrintDflBillOfLadingResult" type="s:base64Binary" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="PrintVicsBillOfLading">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="bolId" type="s:long" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="PrintVicsBillOfLadingResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="PrintVicsBillOfLadingResult" type="s:base64Binary" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GuaranteedServiceInformation" nillable="true" type="tns:GuaranteedServiceInformation" />
      <s:element name="ServiceCenter" nillable="true" type="tns:ServiceCenter" />
      <s:element name="ArrayOfServiceCenter" nillable="true" type="tns:ArrayOfServiceCenter" />
      <s:element name="ArrayOfString" nillable="true" type="tns:ArrayOfString" />
      <s:element name="ArrayOfNameValuePair" nillable="true" type="tns:ArrayOfNameValuePair" />
      <s:element name="TransitTimeResult" nillable="true" type="tns:TransitTimeResult" />
      <s:element name="RateResult" nillable="true" type="tns:RateResult" />
      <s:element name="PickupInformation" nillable="true" type="tns:PickupInformation" />
      <s:element name="ArrayOfPickupInformation" nillable="true" type="tns:ArrayOfPickupInformation" />
      <s:element name="BillOfLadingInformation" nillable="true" type="tns:BillOfLadingInformation" />
      <s:element name="ArrayOfBillOfLadingInformation" nillable="true" type="tns:ArrayOfBillOfLadingInformation" />
      <s:element name="ArrayOfAccessorialDetailInformation" nillable="true" type="tns:ArrayOfAccessorialDetailInformation" />
      <s:element name="base64Binary" nillable="true" type="s:base64Binary" />
    </s:schema>
    <s:schema targetNamespace="http://webservices.daytonfreight.com/AbstractTypes">
      <s:import namespace="http://schemas.xmlsoap.org/soap/encoding/" />
      <s:complexType name="StringArray">
        <s:complexContent mixed="false">
          <s:restriction base="soapenc:Array">
            <s:sequence>
              <s:element minOccurs="0" maxOccurs="unbounded" name="String" type="s:string" />
            </s:sequence>
          </s:restriction>
        </s:complexContent>
      </s:complexType>
    </s:schema>
  </wsdl:types>
  <wsdl:message name="SendAdditionalPickupEmailsSoapIn">
    <wsdl:part name="parameters" element="tns:SendAdditionalPickupEmails" />
  </wsdl:message>
  <wsdl:message name="SendAdditionalPickupEmailsSoapOut">
    <wsdl:part name="parameters" element="tns:SendAdditionalPickupEmailsResponse" />
  </wsdl:message>
  <wsdl:message name="SendAdditionalPickupEmailsCredentials">
    <wsdl:part name="Credentials" element="tns:Credentials" />
  </wsdl:message>
  <wsdl:message name="GetGuaranteedServiceInformationSoapIn">
    <wsdl:part name="parameters" element="tns:GetGuaranteedServiceInformation" />
  </wsdl:message>
  <wsdl:message name="GetGuaranteedServiceInformationSoapOut">
    <wsdl:part name="parameters" element="tns:GetGuaranteedServiceInformationResponse" />
  </wsdl:message>
  <wsdl:message name="GetServiceCenterInformationSoapIn">
    <wsdl:part name="parameters" element="tns:GetServiceCenterInformation" />
  </wsdl:message>
  <wsdl:message name="GetServiceCenterInformationSoapOut">
    <wsdl:part name="parameters" element="tns:GetServiceCenterInformationResponse" />
  </wsdl:message>
  <wsdl:message name="GetAllServiceCenterInformationSoapIn">
    <wsdl:part name="parameters" element="tns:GetAllServiceCenterInformation" />
  </wsdl:message>
  <wsdl:message name="GetAllServiceCenterInformationSoapOut">
    <wsdl:part name="parameters" element="tns:GetAllServiceCenterInformationResponse" />
  </wsdl:message>
  <wsdl:message name="GetShipmentClassesSoapIn">
    <wsdl:part name="parameters" element="tns:GetShipmentClasses" />
  </wsdl:message>
  <wsdl:message name="GetShipmentClassesSoapOut">
    <wsdl:part name="parameters" element="tns:GetShipmentClassesResponse" />
  </wsdl:message>
  <wsdl:message name="GetPackagingSoapIn">
    <wsdl:part name="parameters" element="tns:GetPackaging" />
  </wsdl:message>
  <wsdl:message name="GetPackagingSoapOut">
    <wsdl:part name="parameters" element="tns:GetPackagingResponse" />
  </wsdl:message>
  <wsdl:message name="GetTransitTimeSoapIn">
    <wsdl:part name="parameters" element="tns:GetTransitTime" />
  </wsdl:message>
  <wsdl:message name="GetTransitTimeSoapOut">
    <wsdl:part name="parameters" element="tns:GetTransitTimeResponse" />
  </wsdl:message>
  <wsdl:message name="RateSoapIn">
    <wsdl:part name="parameters" element="tns:Rate" />
  </wsdl:message>
  <wsdl:message name="RateSoapOut">
    <wsdl:part name="parameters" element="tns:RateResponse" />
  </wsdl:message>
  <wsdl:message name="RateCredentials">
    <wsdl:part name="Credentials" element="tns:Credentials" />
  </wsdl:message>
  <wsdl:message name="GetRateQuoteSoapIn">
    <wsdl:part name="parameters" element="tns:GetRateQuote" />
  </wsdl:message>
  <wsdl:message name="GetRateQuoteSoapOut">
    <wsdl:part name="parameters" element="tns:GetRateQuoteResponse" />
  </wsdl:message>
  <wsdl:message name="GetRateQuoteCredentials">
    <wsdl:part name="Credentials" element="tns:Credentials" />
  </wsdl:message>
  <wsdl:message name="CreatePickupSoapIn">
    <wsdl:part name="parameters" element="tns:CreatePickup" />
  </wsdl:message>
  <wsdl:message name="CreatePickupSoapOut">
    <wsdl:part name="parameters" element="tns:CreatePickupResponse" />
  </wsdl:message>
  <wsdl:message name="CreatePickupCredentials">
    <wsdl:part name="Credentials" element="tns:Credentials" />
  </wsdl:message>
  <wsdl:message name="UpdatePickupSoapIn">
    <wsdl:part name="parameters" element="tns:UpdatePickup" />
  </wsdl:message>
  <wsdl:message name="UpdatePickupSoapOut">
    <wsdl:part name="parameters" element="tns:UpdatePickupResponse" />
  </wsdl:message>
  <wsdl:message name="UpdatePickupCredentials">
    <wsdl:part name="Credentials" element="tns:Credentials" />
  </wsdl:message>
  <wsdl:message name="CancelPickupSoapIn">
    <wsdl:part name="parameters" element="tns:CancelPickup" />
  </wsdl:message>
  <wsdl:message name="CancelPickupSoapOut">
    <wsdl:part name="parameters" element="tns:CancelPickupResponse" />
  </wsdl:message>
  <wsdl:message name="CancelPickupCredentials">
    <wsdl:part name="Credentials" element="tns:Credentials" />
  </wsdl:message>
  <wsdl:message name="GetPickupSoapIn">
    <wsdl:part name="parameters" element="tns:GetPickup" />
  </wsdl:message>
  <wsdl:message name="GetPickupSoapOut">
    <wsdl:part name="parameters" element="tns:GetPickupResponse" />
  </wsdl:message>
  <wsdl:message name="GetPickupCredentials">
    <wsdl:part name="Credentials" element="tns:Credentials" />
  </wsdl:message>
  <wsdl:message name="GetPickupHistorySoapIn">
    <wsdl:part name="parameters" element="tns:GetPickupHistory" />
  </wsdl:message>
  <wsdl:message name="GetPickupHistorySoapOut">
    <wsdl:part name="parameters" element="tns:GetPickupHistoryResponse" />
  </wsdl:message>
  <wsdl:message name="GetPickupHistoryCredentials">
    <wsdl:part name="Credentials" element="tns:Credentials" />
  </wsdl:message>
  <wsdl:message name="CreateBillOfLadingSoapIn">
    <wsdl:part name="parameters" element="tns:CreateBillOfLading" />
  </wsdl:message>
  <wsdl:message name="CreateBillOfLadingSoapOut">
    <wsdl:part name="parameters" element="tns:CreateBillOfLadingResponse" />
  </wsdl:message>
  <wsdl:message name="CreateBillOfLadingCredentials">
    <wsdl:part name="Credentials" element="tns:Credentials" />
  </wsdl:message>
  <wsdl:message name="DeleteBillOfLadingSoapIn">
    <wsdl:part name="parameters" element="tns:DeleteBillOfLading" />
  </wsdl:message>
  <wsdl:message name="DeleteBillOfLadingSoapOut">
    <wsdl:part name="parameters" element="tns:DeleteBillOfLadingResponse" />
  </wsdl:message>
  <wsdl:message name="DeleteBillOfLadingCredentials">
    <wsdl:part name="Credentials" element="tns:Credentials" />
  </wsdl:message>
  <wsdl:message name="UpdateBillOfLadingSoapIn">
    <wsdl:part name="parameters" element="tns:UpdateBillOfLading" />
  </wsdl:message>
  <wsdl:message name="UpdateBillOfLadingSoapOut">
    <wsdl:part name="parameters" element="tns:UpdateBillOfLadingResponse" />
  </wsdl:message>
  <wsdl:message name="UpdateBillOfLadingCredentials">
    <wsdl:part name="Credentials" element="tns:Credentials" />
  </wsdl:message>
  <wsdl:message name="GetBillOfLadingInformationSoapIn">
    <wsdl:part name="parameters" element="tns:GetBillOfLadingInformation" />
  </wsdl:message>
  <wsdl:message name="GetBillOfLadingInformationSoapOut">
    <wsdl:part name="parameters" element="tns:GetBillOfLadingInformationResponse" />
  </wsdl:message>
  <wsdl:message name="GetBillOfLadingInformationCredentials">
    <wsdl:part name="Credentials" element="tns:Credentials" />
  </wsdl:message>
  <wsdl:message name="GetBillOfLadingHistorySoapIn">
    <wsdl:part name="parameters" element="tns:GetBillOfLadingHistory" />
  </wsdl:message>
  <wsdl:message name="GetBillOfLadingHistorySoapOut">
    <wsdl:part name="parameters" element="tns:GetBillOfLadingHistoryResponse" />
  </wsdl:message>
  <wsdl:message name="GetBillOfLadingHistoryCredentials">
    <wsdl:part name="Credentials" element="tns:Credentials" />
  </wsdl:message>
  <wsdl:message name="GetShipmentServiceOptionsSoapIn">
    <wsdl:part name="parameters" element="tns:GetShipmentServiceOptions" />
  </wsdl:message>
  <wsdl:message name="GetShipmentServiceOptionsSoapOut">
    <wsdl:part name="parameters" element="tns:GetShipmentServiceOptionsResponse" />
  </wsdl:message>
  <wsdl:message name="GetAccessorialsSoapIn">
    <wsdl:part name="parameters" element="tns:GetAccessorials" />
  </wsdl:message>
  <wsdl:message name="GetAccessorialsSoapOut">
    <wsdl:part name="parameters" element="tns:GetAccessorialsResponse" />
  </wsdl:message>
  <wsdl:message name="PrintDflBillOfLadingSoapIn">
    <wsdl:part name="parameters" element="tns:PrintDflBillOfLading" />
  </wsdl:message>
  <wsdl:message name="PrintDflBillOfLadingSoapOut">
    <wsdl:part name="parameters" element="tns:PrintDflBillOfLadingResponse" />
  </wsdl:message>
  <wsdl:message name="PrintDflBillOfLadingCredentials">
    <wsdl:part name="Credentials" element="tns:Credentials" />
  </wsdl:message>
  <wsdl:message name="PrintVicsBillOfLadingSoapIn">
    <wsdl:part name="parameters" element="tns:PrintVicsBillOfLading" />
  </wsdl:message>
  <wsdl:message name="PrintVicsBillOfLadingSoapOut">
    <wsdl:part name="parameters" element="tns:PrintVicsBillOfLadingResponse" />
  </wsdl:message>
  <wsdl:message name="PrintVicsBillOfLadingCredentials">
    <wsdl:part name="Credentials" element="tns:Credentials" />
  </wsdl:message>
  <wsdl:message name="SendAdditionalPickupEmailsHttpGetIn">
    <wsdl:part name="pickupNumber" type="s:string" />
    <wsdl:part name="sendReceiptTo" type="s1:StringArray" />
    <wsdl:part name="sendConfirmationTo" type="s1:StringArray" />
  </wsdl:message>
  <wsdl:message name="SendAdditionalPickupEmailsHttpGetOut" />
  <wsdl:message name="GetGuaranteedServiceInformationHttpGetIn">
    <wsdl:part name="originZipcode" type="s:string" />
    <wsdl:part name="destinationZipcode" type="s:string" />
    <wsdl:part name="pickupDate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetGuaranteedServiceInformationHttpGetOut">
    <wsdl:part name="Body" element="tns:GuaranteedServiceInformation" />
  </wsdl:message>
  <wsdl:message name="GetServiceCenterInformationHttpGetIn">
    <wsdl:part name="abbreviation" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetServiceCenterInformationHttpGetOut">
    <wsdl:part name="Body" element="tns:ServiceCenter" />
  </wsdl:message>
  <wsdl:message name="GetAllServiceCenterInformationHttpGetIn" />
  <wsdl:message name="GetAllServiceCenterInformationHttpGetOut">
    <wsdl:part name="Body" element="tns:ArrayOfServiceCenter" />
  </wsdl:message>
  <wsdl:message name="GetShipmentClassesHttpGetIn" />
  <wsdl:message name="GetShipmentClassesHttpGetOut">
    <wsdl:part name="Body" element="tns:ArrayOfString" />
  </wsdl:message>
  <wsdl:message name="GetPackagingHttpGetIn" />
  <wsdl:message name="GetPackagingHttpGetOut">
    <wsdl:part name="Body" element="tns:ArrayOfNameValuePair" />
  </wsdl:message>
  <wsdl:message name="GetTransitTimeHttpGetIn">
    <wsdl:part name="originZipcode" type="s:string" />
    <wsdl:part name="destinationZipcode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetTransitTimeHttpGetOut">
    <wsdl:part name="Body" element="tns:TransitTimeResult" />
  </wsdl:message>
  <wsdl:message name="GetRateQuoteHttpGetIn">
    <wsdl:part name="encryptedRateNumber" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetRateQuoteHttpGetOut">
    <wsdl:part name="Body" element="tns:RateResult" />
  </wsdl:message>
  <wsdl:message name="CancelPickupHttpGetIn">
    <wsdl:part name="pickupNumber" type="s:string" />
  </wsdl:message>
  <wsdl:message name="CancelPickupHttpGetOut" />
  <wsdl:message name="GetPickupHttpGetIn">
    <wsdl:part name="pickupNumber" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetPickupHttpGetOut">
    <wsdl:part name="Body" element="tns:PickupInformation" />
  </wsdl:message>
  <wsdl:message name="GetPickupHistoryHttpGetIn">
    <wsdl:part name="startDate" type="s:string" />
    <wsdl:part name="endDate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetPickupHistoryHttpGetOut">
    <wsdl:part name="Body" element="tns:ArrayOfPickupInformation" />
  </wsdl:message>
  <wsdl:message name="DeleteBillOfLadingHttpGetIn">
    <wsdl:part name="billOfLadingId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="DeleteBillOfLadingHttpGetOut" />
  <wsdl:message name="GetBillOfLadingInformationHttpGetIn">
    <wsdl:part name="billOfLadingId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetBillOfLadingInformationHttpGetOut">
    <wsdl:part name="Body" element="tns:BillOfLadingInformation" />
  </wsdl:message>
  <wsdl:message name="GetBillOfLadingHistoryHttpGetIn">
    <wsdl:part name="startDate" type="s:string" />
    <wsdl:part name="endDate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetBillOfLadingHistoryHttpGetOut">
    <wsdl:part name="Body" element="tns:ArrayOfBillOfLadingInformation" />
  </wsdl:message>
  <wsdl:message name="GetShipmentServiceOptionsHttpGetIn">
    <wsdl:part name="originZipcode" type="s:string" />
    <wsdl:part name="destinationZipcode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetShipmentServiceOptionsHttpGetOut">
    <wsdl:part name="Body" element="tns:ArrayOfString" />
  </wsdl:message>
  <wsdl:message name="GetAccessorialsHttpGetIn" />
  <wsdl:message name="GetAccessorialsHttpGetOut">
    <wsdl:part name="Body" element="tns:ArrayOfAccessorialDetailInformation" />
  </wsdl:message>
  <wsdl:message name="PrintDflBillOfLadingHttpGetIn">
    <wsdl:part name="bolId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="PrintDflBillOfLadingHttpGetOut">
    <wsdl:part name="Body" element="tns:base64Binary" />
  </wsdl:message>
  <wsdl:message name="PrintVicsBillOfLadingHttpGetIn">
    <wsdl:part name="bolId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="PrintVicsBillOfLadingHttpGetOut">
    <wsdl:part name="Body" element="tns:base64Binary" />
  </wsdl:message>
  <wsdl:message name="SendAdditionalPickupEmailsHttpPostIn">
    <wsdl:part name="pickupNumber" type="s:string" />
    <wsdl:part name="sendReceiptTo" type="s1:StringArray" />
    <wsdl:part name="sendConfirmationTo" type="s1:StringArray" />
  </wsdl:message>
  <wsdl:message name="SendAdditionalPickupEmailsHttpPostOut" />
  <wsdl:message name="GetGuaranteedServiceInformationHttpPostIn">
    <wsdl:part name="originZipcode" type="s:string" />
    <wsdl:part name="destinationZipcode" type="s:string" />
    <wsdl:part name="pickupDate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetGuaranteedServiceInformationHttpPostOut">
    <wsdl:part name="Body" element="tns:GuaranteedServiceInformation" />
  </wsdl:message>
  <wsdl:message name="GetServiceCenterInformationHttpPostIn">
    <wsdl:part name="abbreviation" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetServiceCenterInformationHttpPostOut">
    <wsdl:part name="Body" element="tns:ServiceCenter" />
  </wsdl:message>
  <wsdl:message name="GetAllServiceCenterInformationHttpPostIn" />
  <wsdl:message name="GetAllServiceCenterInformationHttpPostOut">
    <wsdl:part name="Body" element="tns:ArrayOfServiceCenter" />
  </wsdl:message>
  <wsdl:message name="GetShipmentClassesHttpPostIn" />
  <wsdl:message name="GetShipmentClassesHttpPostOut">
    <wsdl:part name="Body" element="tns:ArrayOfString" />
  </wsdl:message>
  <wsdl:message name="GetPackagingHttpPostIn" />
  <wsdl:message name="GetPackagingHttpPostOut">
    <wsdl:part name="Body" element="tns:ArrayOfNameValuePair" />
  </wsdl:message>
  <wsdl:message name="GetTransitTimeHttpPostIn">
    <wsdl:part name="originZipcode" type="s:string" />
    <wsdl:part name="destinationZipcode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetTransitTimeHttpPostOut">
    <wsdl:part name="Body" element="tns:TransitTimeResult" />
  </wsdl:message>
  <wsdl:message name="GetRateQuoteHttpPostIn">
    <wsdl:part name="encryptedRateNumber" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetRateQuoteHttpPostOut">
    <wsdl:part name="Body" element="tns:RateResult" />
  </wsdl:message>
  <wsdl:message name="CancelPickupHttpPostIn">
    <wsdl:part name="pickupNumber" type="s:string" />
  </wsdl:message>
  <wsdl:message name="CancelPickupHttpPostOut" />
  <wsdl:message name="GetPickupHttpPostIn">
    <wsdl:part name="pickupNumber" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetPickupHttpPostOut">
    <wsdl:part name="Body" element="tns:PickupInformation" />
  </wsdl:message>
  <wsdl:message name="GetPickupHistoryHttpPostIn">
    <wsdl:part name="startDate" type="s:string" />
    <wsdl:part name="endDate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetPickupHistoryHttpPostOut">
    <wsdl:part name="Body" element="tns:ArrayOfPickupInformation" />
  </wsdl:message>
  <wsdl:message name="DeleteBillOfLadingHttpPostIn">
    <wsdl:part name="billOfLadingId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="DeleteBillOfLadingHttpPostOut" />
  <wsdl:message name="GetBillOfLadingInformationHttpPostIn">
    <wsdl:part name="billOfLadingId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetBillOfLadingInformationHttpPostOut">
    <wsdl:part name="Body" element="tns:BillOfLadingInformation" />
  </wsdl:message>
  <wsdl:message name="GetBillOfLadingHistoryHttpPostIn">
    <wsdl:part name="startDate" type="s:string" />
    <wsdl:part name="endDate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetBillOfLadingHistoryHttpPostOut">
    <wsdl:part name="Body" element="tns:ArrayOfBillOfLadingInformation" />
  </wsdl:message>
  <wsdl:message name="GetShipmentServiceOptionsHttpPostIn">
    <wsdl:part name="originZipcode" type="s:string" />
    <wsdl:part name="destinationZipcode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetShipmentServiceOptionsHttpPostOut">
    <wsdl:part name="Body" element="tns:ArrayOfString" />
  </wsdl:message>
  <wsdl:message name="GetAccessorialsHttpPostIn" />
  <wsdl:message name="GetAccessorialsHttpPostOut">
    <wsdl:part name="Body" element="tns:ArrayOfAccessorialDetailInformation" />
  </wsdl:message>
  <wsdl:message name="PrintDflBillOfLadingHttpPostIn">
    <wsdl:part name="bolId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="PrintDflBillOfLadingHttpPostOut">
    <wsdl:part name="Body" element="tns:base64Binary" />
  </wsdl:message>
  <wsdl:message name="PrintVicsBillOfLadingHttpPostIn">
    <wsdl:part name="bolId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="PrintVicsBillOfLadingHttpPostOut">
    <wsdl:part name="Body" element="tns:base64Binary" />
  </wsdl:message>
  <wsdl:portType name="ShippingServiceSoap">
    <wsdl:operation name="SendAdditionalPickupEmails">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Sends additional pickup receipts and pickup confirmation email messages.</wsdl:documentation>
      <wsdl:input message="tns:SendAdditionalPickupEmailsSoapIn" />
      <wsdl:output message="tns:SendAdditionalPickupEmailsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetGuaranteedServiceInformation">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets guaranteed service information.</wsdl:documentation>
      <wsdl:input message="tns:GetGuaranteedServiceInformationSoapIn" />
      <wsdl:output message="tns:GetGuaranteedServiceInformationSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetServiceCenterInformation">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets information for the specified service center.</wsdl:documentation>
      <wsdl:input message="tns:GetServiceCenterInformationSoapIn" />
      <wsdl:output message="tns:GetServiceCenterInformationSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetAllServiceCenterInformation">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets information for all service centers.</wsdl:documentation>
      <wsdl:input message="tns:GetAllServiceCenterInformationSoapIn" />
      <wsdl:output message="tns:GetAllServiceCenterInformationSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetShipmentClasses">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets all possible shipment classes.</wsdl:documentation>
      <wsdl:input message="tns:GetShipmentClassesSoapIn" />
      <wsdl:output message="tns:GetShipmentClassesSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetPackaging">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets all possible packaging types along with the appropriate codes.</wsdl:documentation>
      <wsdl:input message="tns:GetPackagingSoapIn" />
      <wsdl:output message="tns:GetPackagingSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetTransitTime">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Calculates transit times given an origin and desitnation zip code.</wsdl:documentation>
      <wsdl:input message="tns:GetTransitTimeSoapIn" />
      <wsdl:output message="tns:GetTransitTimeSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="Rate">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Calculates a rate based on the shipment details provided.</wsdl:documentation>
      <wsdl:input message="tns:RateSoapIn" />
      <wsdl:output message="tns:RateSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetRateQuote">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Retrieves a past rate quote.</wsdl:documentation>
      <wsdl:input message="tns:GetRateQuoteSoapIn" />
      <wsdl:output message="tns:GetRateQuoteSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="CreatePickup">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Creates a pickup with the given pickup information.</wsdl:documentation>
      <wsdl:input message="tns:CreatePickupSoapIn" />
      <wsdl:output message="tns:CreatePickupSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="UpdatePickup">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Updates pickup with the given pickup information.</wsdl:documentation>
      <wsdl:input message="tns:UpdatePickupSoapIn" />
      <wsdl:output message="tns:UpdatePickupSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="CancelPickup">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Cancels the pickup specified by the given pickup number.</wsdl:documentation>
      <wsdl:input message="tns:CancelPickupSoapIn" />
      <wsdl:output message="tns:CancelPickupSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetPickup">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets the pickup information for the given pickup number.</wsdl:documentation>
      <wsdl:input message="tns:GetPickupSoapIn" />
      <wsdl:output message="tns:GetPickupSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetPickupHistory">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets pickup history for a user between a given date range.</wsdl:documentation>
      <wsdl:input message="tns:GetPickupHistorySoapIn" />
      <wsdl:output message="tns:GetPickupHistorySoapOut" />
    </wsdl:operation>
    <wsdl:operation name="CreateBillOfLading">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Creates a Dayton Freight Bill of Lading with the provided information.</wsdl:documentation>
      <wsdl:input message="tns:CreateBillOfLadingSoapIn" />
      <wsdl:output message="tns:CreateBillOfLadingSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="DeleteBillOfLading">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Deletes a Dayton Freight Bill of Lading.</wsdl:documentation>
      <wsdl:input message="tns:DeleteBillOfLadingSoapIn" />
      <wsdl:output message="tns:DeleteBillOfLadingSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="UpdateBillOfLading">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Updates a Dayton Freight Bill of Lading with the provided information.</wsdl:documentation>
      <wsdl:input message="tns:UpdateBillOfLadingSoapIn" />
      <wsdl:output message="tns:UpdateBillOfLadingSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBillOfLadingInformation">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets bill of lading information for the requested bill of lading id.</wsdl:documentation>
      <wsdl:input message="tns:GetBillOfLadingInformationSoapIn" />
      <wsdl:output message="tns:GetBillOfLadingInformationSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBillOfLadingHistory">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets bill of lading history for a user between a given date range.</wsdl:documentation>
      <wsdl:input message="tns:GetBillOfLadingHistorySoapIn" />
      <wsdl:output message="tns:GetBillOfLadingHistorySoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetShipmentServiceOptions">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets service options for a particular shipment from origin to destination zip code.</wsdl:documentation>
      <wsdl:input message="tns:GetShipmentServiceOptionsSoapIn" />
      <wsdl:output message="tns:GetShipmentServiceOptionsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetAccessorials">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets accessorial codes and descriptions to be used when requesting rates.</wsdl:documentation>
      <wsdl:input message="tns:GetAccessorialsSoapIn" />
      <wsdl:output message="tns:GetAccessorialsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="PrintDflBillOfLading">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Creates a Dayton Freight Lines Bill of Lading PDF and returns the binary data.</wsdl:documentation>
      <wsdl:input message="tns:PrintDflBillOfLadingSoapIn" />
      <wsdl:output message="tns:PrintDflBillOfLadingSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="PrintVicsBillOfLading">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Creates a VICS Bill of Lading PDF and returns the binary data.</wsdl:documentation>
      <wsdl:input message="tns:PrintVicsBillOfLadingSoapIn" />
      <wsdl:output message="tns:PrintVicsBillOfLadingSoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:portType name="ShippingServiceHttpGet">
    <wsdl:operation name="SendAdditionalPickupEmails">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Sends additional pickup receipts and pickup confirmation email messages.</wsdl:documentation>
      <wsdl:input message="tns:SendAdditionalPickupEmailsHttpGetIn" />
      <wsdl:output message="tns:SendAdditionalPickupEmailsHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetGuaranteedServiceInformation">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets guaranteed service information.</wsdl:documentation>
      <wsdl:input message="tns:GetGuaranteedServiceInformationHttpGetIn" />
      <wsdl:output message="tns:GetGuaranteedServiceInformationHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetServiceCenterInformation">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets information for the specified service center.</wsdl:documentation>
      <wsdl:input message="tns:GetServiceCenterInformationHttpGetIn" />
      <wsdl:output message="tns:GetServiceCenterInformationHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetAllServiceCenterInformation">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets information for all service centers.</wsdl:documentation>
      <wsdl:input message="tns:GetAllServiceCenterInformationHttpGetIn" />
      <wsdl:output message="tns:GetAllServiceCenterInformationHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetShipmentClasses">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets all possible shipment classes.</wsdl:documentation>
      <wsdl:input message="tns:GetShipmentClassesHttpGetIn" />
      <wsdl:output message="tns:GetShipmentClassesHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetPackaging">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets all possible packaging types along with the appropriate codes.</wsdl:documentation>
      <wsdl:input message="tns:GetPackagingHttpGetIn" />
      <wsdl:output message="tns:GetPackagingHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetTransitTime">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Calculates transit times given an origin and desitnation zip code.</wsdl:documentation>
      <wsdl:input message="tns:GetTransitTimeHttpGetIn" />
      <wsdl:output message="tns:GetTransitTimeHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetRateQuote">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Retrieves a past rate quote.</wsdl:documentation>
      <wsdl:input message="tns:GetRateQuoteHttpGetIn" />
      <wsdl:output message="tns:GetRateQuoteHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="CancelPickup">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Cancels the pickup specified by the given pickup number.</wsdl:documentation>
      <wsdl:input message="tns:CancelPickupHttpGetIn" />
      <wsdl:output message="tns:CancelPickupHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetPickup">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets the pickup information for the given pickup number.</wsdl:documentation>
      <wsdl:input message="tns:GetPickupHttpGetIn" />
      <wsdl:output message="tns:GetPickupHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetPickupHistory">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets pickup history for a user between a given date range.</wsdl:documentation>
      <wsdl:input message="tns:GetPickupHistoryHttpGetIn" />
      <wsdl:output message="tns:GetPickupHistoryHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="DeleteBillOfLading">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Deletes a Dayton Freight Bill of Lading.</wsdl:documentation>
      <wsdl:input message="tns:DeleteBillOfLadingHttpGetIn" />
      <wsdl:output message="tns:DeleteBillOfLadingHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBillOfLadingInformation">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets bill of lading information for the requested bill of lading id.</wsdl:documentation>
      <wsdl:input message="tns:GetBillOfLadingInformationHttpGetIn" />
      <wsdl:output message="tns:GetBillOfLadingInformationHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBillOfLadingHistory">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets bill of lading history for a user between a given date range.</wsdl:documentation>
      <wsdl:input message="tns:GetBillOfLadingHistoryHttpGetIn" />
      <wsdl:output message="tns:GetBillOfLadingHistoryHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetShipmentServiceOptions">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets service options for a particular shipment from origin to destination zip code.</wsdl:documentation>
      <wsdl:input message="tns:GetShipmentServiceOptionsHttpGetIn" />
      <wsdl:output message="tns:GetShipmentServiceOptionsHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetAccessorials">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets accessorial codes and descriptions to be used when requesting rates.</wsdl:documentation>
      <wsdl:input message="tns:GetAccessorialsHttpGetIn" />
      <wsdl:output message="tns:GetAccessorialsHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="PrintDflBillOfLading">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Creates a Dayton Freight Lines Bill of Lading PDF and returns the binary data.</wsdl:documentation>
      <wsdl:input message="tns:PrintDflBillOfLadingHttpGetIn" />
      <wsdl:output message="tns:PrintDflBillOfLadingHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="PrintVicsBillOfLading">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Creates a VICS Bill of Lading PDF and returns the binary data.</wsdl:documentation>
      <wsdl:input message="tns:PrintVicsBillOfLadingHttpGetIn" />
      <wsdl:output message="tns:PrintVicsBillOfLadingHttpGetOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:portType name="ShippingServiceHttpPost">
    <wsdl:operation name="SendAdditionalPickupEmails">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Sends additional pickup receipts and pickup confirmation email messages.</wsdl:documentation>
      <wsdl:input message="tns:SendAdditionalPickupEmailsHttpPostIn" />
      <wsdl:output message="tns:SendAdditionalPickupEmailsHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetGuaranteedServiceInformation">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets guaranteed service information.</wsdl:documentation>
      <wsdl:input message="tns:GetGuaranteedServiceInformationHttpPostIn" />
      <wsdl:output message="tns:GetGuaranteedServiceInformationHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetServiceCenterInformation">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets information for the specified service center.</wsdl:documentation>
      <wsdl:input message="tns:GetServiceCenterInformationHttpPostIn" />
      <wsdl:output message="tns:GetServiceCenterInformationHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetAllServiceCenterInformation">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets information for all service centers.</wsdl:documentation>
      <wsdl:input message="tns:GetAllServiceCenterInformationHttpPostIn" />
      <wsdl:output message="tns:GetAllServiceCenterInformationHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetShipmentClasses">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets all possible shipment classes.</wsdl:documentation>
      <wsdl:input message="tns:GetShipmentClassesHttpPostIn" />
      <wsdl:output message="tns:GetShipmentClassesHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetPackaging">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets all possible packaging types along with the appropriate codes.</wsdl:documentation>
      <wsdl:input message="tns:GetPackagingHttpPostIn" />
      <wsdl:output message="tns:GetPackagingHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetTransitTime">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Calculates transit times given an origin and desitnation zip code.</wsdl:documentation>
      <wsdl:input message="tns:GetTransitTimeHttpPostIn" />
      <wsdl:output message="tns:GetTransitTimeHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetRateQuote">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Retrieves a past rate quote.</wsdl:documentation>
      <wsdl:input message="tns:GetRateQuoteHttpPostIn" />
      <wsdl:output message="tns:GetRateQuoteHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="CancelPickup">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Cancels the pickup specified by the given pickup number.</wsdl:documentation>
      <wsdl:input message="tns:CancelPickupHttpPostIn" />
      <wsdl:output message="tns:CancelPickupHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetPickup">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets the pickup information for the given pickup number.</wsdl:documentation>
      <wsdl:input message="tns:GetPickupHttpPostIn" />
      <wsdl:output message="tns:GetPickupHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetPickupHistory">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets pickup history for a user between a given date range.</wsdl:documentation>
      <wsdl:input message="tns:GetPickupHistoryHttpPostIn" />
      <wsdl:output message="tns:GetPickupHistoryHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="DeleteBillOfLading">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Deletes a Dayton Freight Bill of Lading.</wsdl:documentation>
      <wsdl:input message="tns:DeleteBillOfLadingHttpPostIn" />
      <wsdl:output message="tns:DeleteBillOfLadingHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBillOfLadingInformation">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets bill of lading information for the requested bill of lading id.</wsdl:documentation>
      <wsdl:input message="tns:GetBillOfLadingInformationHttpPostIn" />
      <wsdl:output message="tns:GetBillOfLadingInformationHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBillOfLadingHistory">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets bill of lading history for a user between a given date range.</wsdl:documentation>
      <wsdl:input message="tns:GetBillOfLadingHistoryHttpPostIn" />
      <wsdl:output message="tns:GetBillOfLadingHistoryHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetShipmentServiceOptions">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets service options for a particular shipment from origin to destination zip code.</wsdl:documentation>
      <wsdl:input message="tns:GetShipmentServiceOptionsHttpPostIn" />
      <wsdl:output message="tns:GetShipmentServiceOptionsHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetAccessorials">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Gets accessorial codes and descriptions to be used when requesting rates.</wsdl:documentation>
      <wsdl:input message="tns:GetAccessorialsHttpPostIn" />
      <wsdl:output message="tns:GetAccessorialsHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="PrintDflBillOfLading">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Creates a Dayton Freight Lines Bill of Lading PDF and returns the binary data.</wsdl:documentation>
      <wsdl:input message="tns:PrintDflBillOfLadingHttpPostIn" />
      <wsdl:output message="tns:PrintDflBillOfLadingHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="PrintVicsBillOfLading">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">Creates a VICS Bill of Lading PDF and returns the binary data.</wsdl:documentation>
      <wsdl:input message="tns:PrintVicsBillOfLadingHttpPostIn" />
      <wsdl:output message="tns:PrintVicsBillOfLadingHttpPostOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="ShippingServiceSoap" type="tns:ShippingServiceSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="SendAdditionalPickupEmails">
      <soap:operation soapAction="http://webservices.daytonfreight.com/SendAdditionalPickupEmails" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
        <soap:header message="tns:SendAdditionalPickupEmailsCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetGuaranteedServiceInformation">
      <soap:operation soapAction="http://webservices.daytonfreight.com/GetGuaranteedServiceInformation" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetServiceCenterInformation">
      <soap:operation soapAction="http://webservices.daytonfreight.com/GetServiceCenterInformation" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAllServiceCenterInformation">
      <soap:operation soapAction="http://webservices.daytonfreight.com/GetAllServiceCenterInformation" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetShipmentClasses">
      <soap:operation soapAction="http://webservices.daytonfreight.com/GetShipmentClasses" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetPackaging">
      <soap:operation soapAction="http://webservices.daytonfreight.com/GetPackaging" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTransitTime">
      <soap:operation soapAction="http://webservices.daytonfreight.com/GetTransitTime" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Rate">
      <soap:operation soapAction="http://webservices.daytonfreight.com/Rate" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
        <soap:header message="tns:RateCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetRateQuote">
      <soap:operation soapAction="http://webservices.daytonfreight.com/GetRateQuote" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
        <soap:header message="tns:GetRateQuoteCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="CreatePickup">
      <soap:operation soapAction="http://webservices.daytonfreight.com/CreatePickup" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
        <soap:header message="tns:CreatePickupCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="UpdatePickup">
      <soap:operation soapAction="http://webservices.daytonfreight.com/UpdatePickup" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
        <soap:header message="tns:UpdatePickupCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="CancelPickup">
      <soap:operation soapAction="http://webservices.daytonfreight.com/CancelPickup" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
        <soap:header message="tns:CancelPickupCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetPickup">
      <soap:operation soapAction="http://webservices.daytonfreight.com/GetPickup" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
        <soap:header message="tns:GetPickupCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetPickupHistory">
      <soap:operation soapAction="http://webservices.daytonfreight.com/GetPickupHistory" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
        <soap:header message="tns:GetPickupHistoryCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="CreateBillOfLading">
      <soap:operation soapAction="http://webservices.daytonfreight.com/CreateBillOfLading" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
        <soap:header message="tns:CreateBillOfLadingCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="DeleteBillOfLading">
      <soap:operation soapAction="http://webservices.daytonfreight.com/DeleteBillOfLading" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
        <soap:header message="tns:DeleteBillOfLadingCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="UpdateBillOfLading">
      <soap:operation soapAction="http://webservices.daytonfreight.com/UpdateBillOfLading" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
        <soap:header message="tns:UpdateBillOfLadingCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBillOfLadingInformation">
      <soap:operation soapAction="http://webservices.daytonfreight.com/GetBillOfLadingInformation" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
        <soap:header message="tns:GetBillOfLadingInformationCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBillOfLadingHistory">
      <soap:operation soapAction="http://webservices.daytonfreight.com/GetBillOfLadingHistory" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
        <soap:header message="tns:GetBillOfLadingHistoryCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetShipmentServiceOptions">
      <soap:operation soapAction="http://webservices.daytonfreight.com/GetShipmentServiceOptions" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAccessorials">
      <soap:operation soapAction="http://webservices.daytonfreight.com/GetAccessorials" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PrintDflBillOfLading">
      <soap:operation soapAction="http://webservices.daytonfreight.com/PrintDflBillOfLading" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
        <soap:header message="tns:PrintDflBillOfLadingCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PrintVicsBillOfLading">
      <soap:operation soapAction="http://webservices.daytonfreight.com/PrintVicsBillOfLading" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
        <soap:header message="tns:PrintVicsBillOfLadingCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="ShippingServiceSoap12" type="tns:ShippingServiceSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="SendAdditionalPickupEmails">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/SendAdditionalPickupEmails" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
        <soap12:header message="tns:SendAdditionalPickupEmailsCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetGuaranteedServiceInformation">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/GetGuaranteedServiceInformation" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetServiceCenterInformation">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/GetServiceCenterInformation" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAllServiceCenterInformation">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/GetAllServiceCenterInformation" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetShipmentClasses">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/GetShipmentClasses" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetPackaging">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/GetPackaging" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTransitTime">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/GetTransitTime" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="Rate">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/Rate" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
        <soap12:header message="tns:RateCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetRateQuote">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/GetRateQuote" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
        <soap12:header message="tns:GetRateQuoteCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="CreatePickup">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/CreatePickup" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
        <soap12:header message="tns:CreatePickupCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="UpdatePickup">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/UpdatePickup" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
        <soap12:header message="tns:UpdatePickupCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="CancelPickup">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/CancelPickup" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
        <soap12:header message="tns:CancelPickupCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetPickup">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/GetPickup" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
        <soap12:header message="tns:GetPickupCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetPickupHistory">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/GetPickupHistory" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
        <soap12:header message="tns:GetPickupHistoryCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="CreateBillOfLading">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/CreateBillOfLading" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
        <soap12:header message="tns:CreateBillOfLadingCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="DeleteBillOfLading">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/DeleteBillOfLading" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
        <soap12:header message="tns:DeleteBillOfLadingCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="UpdateBillOfLading">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/UpdateBillOfLading" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
        <soap12:header message="tns:UpdateBillOfLadingCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBillOfLadingInformation">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/GetBillOfLadingInformation" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
        <soap12:header message="tns:GetBillOfLadingInformationCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBillOfLadingHistory">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/GetBillOfLadingHistory" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
        <soap12:header message="tns:GetBillOfLadingHistoryCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetShipmentServiceOptions">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/GetShipmentServiceOptions" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAccessorials">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/GetAccessorials" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PrintDflBillOfLading">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/PrintDflBillOfLading" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
        <soap12:header message="tns:PrintDflBillOfLadingCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PrintVicsBillOfLading">
      <soap12:operation soapAction="http://webservices.daytonfreight.com/PrintVicsBillOfLading" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
        <soap12:header message="tns:PrintVicsBillOfLadingCredentials" part="Credentials" use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="ShippingServiceHttpGet" type="tns:ShippingServiceHttpGet">
    <http:binding verb="GET" />
    <wsdl:operation name="SendAdditionalPickupEmails">
      <http:operation location="/SendAdditionalPickupEmails" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output />
    </wsdl:operation>
    <wsdl:operation name="GetGuaranteedServiceInformation">
      <http:operation location="/GetGuaranteedServiceInformation" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetServiceCenterInformation">
      <http:operation location="/GetServiceCenterInformation" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAllServiceCenterInformation">
      <http:operation location="/GetAllServiceCenterInformation" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetShipmentClasses">
      <http:operation location="/GetShipmentClasses" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetPackaging">
      <http:operation location="/GetPackaging" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTransitTime">
      <http:operation location="/GetTransitTime" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetRateQuote">
      <http:operation location="/GetRateQuote" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="CancelPickup">
      <http:operation location="/CancelPickup" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output />
    </wsdl:operation>
    <wsdl:operation name="GetPickup">
      <http:operation location="/GetPickup" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetPickupHistory">
      <http:operation location="/GetPickupHistory" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="DeleteBillOfLading">
      <http:operation location="/DeleteBillOfLading" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output />
    </wsdl:operation>
    <wsdl:operation name="GetBillOfLadingInformation">
      <http:operation location="/GetBillOfLadingInformation" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBillOfLadingHistory">
      <http:operation location="/GetBillOfLadingHistory" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetShipmentServiceOptions">
      <http:operation location="/GetShipmentServiceOptions" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAccessorials">
      <http:operation location="/GetAccessorials" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PrintDflBillOfLading">
      <http:operation location="/PrintDflBillOfLading" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PrintVicsBillOfLading">
      <http:operation location="/PrintVicsBillOfLading" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="ShippingServiceHttpPost" type="tns:ShippingServiceHttpPost">
    <http:binding verb="POST" />
    <wsdl:operation name="SendAdditionalPickupEmails">
      <http:operation location="/SendAdditionalPickupEmails" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output />
    </wsdl:operation>
    <wsdl:operation name="GetGuaranteedServiceInformation">
      <http:operation location="/GetGuaranteedServiceInformation" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetServiceCenterInformation">
      <http:operation location="/GetServiceCenterInformation" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAllServiceCenterInformation">
      <http:operation location="/GetAllServiceCenterInformation" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetShipmentClasses">
      <http:operation location="/GetShipmentClasses" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetPackaging">
      <http:operation location="/GetPackaging" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTransitTime">
      <http:operation location="/GetTransitTime" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetRateQuote">
      <http:operation location="/GetRateQuote" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="CancelPickup">
      <http:operation location="/CancelPickup" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output />
    </wsdl:operation>
    <wsdl:operation name="GetPickup">
      <http:operation location="/GetPickup" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetPickupHistory">
      <http:operation location="/GetPickupHistory" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="DeleteBillOfLading">
      <http:operation location="/DeleteBillOfLading" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output />
    </wsdl:operation>
    <wsdl:operation name="GetBillOfLadingInformation">
      <http:operation location="/GetBillOfLadingInformation" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBillOfLadingHistory">
      <http:operation location="/GetBillOfLadingHistory" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetShipmentServiceOptions">
      <http:operation location="/GetShipmentServiceOptions" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAccessorials">
      <http:operation location="/GetAccessorials" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PrintDflBillOfLading">
      <http:operation location="/PrintDflBillOfLading" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="PrintVicsBillOfLading">
      <http:operation location="/PrintVicsBillOfLading" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="ShippingService">
    <wsdl:port name="ShippingServiceSoap" binding="tns:ShippingServiceSoap">
      <soap:address location="http://legacy.daytonfreight.com/WebServices_v1.1/ShippingService.asmx" />
    </wsdl:port>
    <wsdl:port name="ShippingServiceSoap12" binding="tns:ShippingServiceSoap12">
      <soap12:address location="http://legacy.daytonfreight.com/WebServices_v1.1/ShippingService.asmx" />
    </wsdl:port>
    <wsdl:port name="ShippingServiceHttpGet" binding="tns:ShippingServiceHttpGet">
      <http:address location="http://legacy.daytonfreight.com/WebServices_v1.1/ShippingService.asmx" />
    </wsdl:port>
    <wsdl:port name="ShippingServiceHttpPost" binding="tns:ShippingServiceHttpPost">
      <http:address location="http://legacy.daytonfreight.com/WebServices_v1.1/ShippingService.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>