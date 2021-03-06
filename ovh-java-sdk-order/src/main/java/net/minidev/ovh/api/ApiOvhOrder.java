package net.minidev.ovh.api;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import net.minidev.ovh.api.cdn.webstorage.OvhOrderStorageEnum;
import net.minidev.ovh.api.cdn.webstorage.OvhOrderTrafficEnum;
import net.minidev.ovh.api.cdnanycast.OvhOrderCacheRuleEnum;
import net.minidev.ovh.api.cdnanycast.OvhOrderQuotaEnum;
import net.minidev.ovh.api.dedicated.OvhNasHAOfferEnum;
import net.minidev.ovh.api.dedicated.OvhNasHAZoneEnum;
import net.minidev.ovh.api.dedicated.server.OvhBackupStorageCapacityEnum;
import net.minidev.ovh.api.dedicated.server.OvhBandwidthOrderEnum;
import net.minidev.ovh.api.dedicated.server.OvhBandwidthOrderTypeEnum;
import net.minidev.ovh.api.dedicated.server.OvhBandwidthvRackOrderEnum;
import net.minidev.ovh.api.dedicated.server.OvhFirewallModelEnum;
import net.minidev.ovh.api.dedicated.server.OvhIpBlockSizeEnum;
import net.minidev.ovh.api.dedicated.server.OvhIpCountryEnum;
import net.minidev.ovh.api.dedicated.server.OvhIpStaticCountryEnum;
import net.minidev.ovh.api.dedicated.server.OvhIpTypeOrderableEnum;
import net.minidev.ovh.api.dedicated.server.OvhOrderableSysFeatureEnum;
import net.minidev.ovh.api.dedicated.server.OvhTrafficOrderEnum;
import net.minidev.ovh.api.dedicated.server.OvhUsbKeyCapacityEnum;
import net.minidev.ovh.api.dedicatedcloud.OvhAdditionalBandwidthEnum;
import net.minidev.ovh.api.dedicatedcloud.OvhIpCountriesEnum;
import net.minidev.ovh.api.dedicatedcloud.OvhOrderableIpBlockRangeEnum;
import net.minidev.ovh.api.dedicatedcloud.ressources.OvhUpgradeRessourceTypeEnum;
import net.minidev.ovh.api.dedicatedcloud.ressources.OvhUpgradeTypeEnum;
import net.minidev.ovh.api.email.exchange.OvhAccountQuotaEnum;
import net.minidev.ovh.api.email.exchange.OvhOutlookVersionEnum;
import net.minidev.ovh.api.email.exchange.OvhOvhLicenceEnum;
import net.minidev.ovh.api.freefax.OvhQuantityEnum;
import net.minidev.ovh.api.hosting.privatedatabase.OvhAvailableRamSizeEnum;
import net.minidev.ovh.api.hosting.privatedatabase.OvhDatacenterEnum;
import net.minidev.ovh.api.hosting.privatedatabase.OvhOrderableVersionEnum;
import net.minidev.ovh.api.hosting.web.OvhBandwidthOfferEnum;
import net.minidev.ovh.api.hosting.web.OvhCdnOfferEnum;
import net.minidev.ovh.api.hosting.web.OvhDnsZoneEnum;
import net.minidev.ovh.api.hosting.web.OvhOfferEnum;
import net.minidev.ovh.api.hosting.web.database.OvhSqlPersoOfferEnum;
import net.minidev.ovh.api.hosting.web.module.OvhOrderableNameEnum;
import net.minidev.ovh.api.hosting.web.order.OvhMxPlanEnum;
import net.minidev.ovh.api.license.OvhCloudLinuxVersionEnum;
import net.minidev.ovh.api.license.OvhLicenseTypeEnum;
import net.minidev.ovh.api.license.OvhOrderableAntispamEnum;
import net.minidev.ovh.api.license.OvhOrderableAntivirusEnum;
import net.minidev.ovh.api.license.OvhOrderableCpanelVersionEnum;
import net.minidev.ovh.api.license.OvhOrderableDirectAdminVersionEnum;
import net.minidev.ovh.api.license.OvhOrderablePleskDomainNumberEnum;
import net.minidev.ovh.api.license.OvhOrderablePleskLanguagePackEnum;
import net.minidev.ovh.api.license.OvhOrderableVirtuozzoContainerNumberEnum;
import net.minidev.ovh.api.license.OvhOrderableVirtuozzoVersionEnum;
import net.minidev.ovh.api.license.OvhPleskApplicationSetEnum;
import net.minidev.ovh.api.license.OvhPleskVersionEnum;
import net.minidev.ovh.api.license.OvhSqlServerVersionEnum;
import net.minidev.ovh.api.license.OvhWindowsOsVersionEnum;
import net.minidev.ovh.api.license.OvhWindowsSqlVersionEnum;
import net.minidev.ovh.api.license.OvhWorkLightVersionEnum;
import net.minidev.ovh.api.nichandle.OvhLegalFormEnum;
import net.minidev.ovh.api.nichandle.OvhOvhSubsidiaryEnum;
import net.minidev.ovh.api.order.OvhOrder;
import net.minidev.ovh.api.order.cart.OvhCart;
import net.minidev.ovh.api.order.cart.OvhConfigurationItem;
import net.minidev.ovh.api.order.cart.OvhConfigurationRequirements;
import net.minidev.ovh.api.order.cart.OvhDomainPacksProductInformation;
import net.minidev.ovh.api.order.cart.OvhGenericOptionDefinition;
import net.minidev.ovh.api.order.cart.OvhGenericProductDefinition;
import net.minidev.ovh.api.order.cart.OvhItem;
import net.minidev.ovh.api.order.cart.OvhProductInformation;
import net.minidev.ovh.api.order.cart.OvhWebHostingProductInformation;
import net.minidev.ovh.api.order.catalog.privatecloud.OvhCatalog;
import net.minidev.ovh.api.order.upgrade.OvhOrderUpgradeOperationAndOrder;
import net.minidev.ovh.api.overthebox.OvhShippingMethodEnum;
import net.minidev.ovh.api.telephony.OvhLineTypeEnum;
import net.minidev.ovh.api.telephony.OvhNumberCountryEnum;
import net.minidev.ovh.api.telephony.OvhNumberOffer;
import net.minidev.ovh.api.telephony.OvhNumberPoolEnum;
import net.minidev.ovh.api.telephony.OvhNumberSpecialTypologyEnum;
import net.minidev.ovh.api.telephony.OvhSecurityDepositAmountsEnum;
import net.minidev.ovh.api.telephony.portability.OvhCountriesAvailable;
import net.minidev.ovh.api.telephony.portability.OvhNumberType;
import net.minidev.ovh.api.telephony.portability.OvhOfferType;
import net.minidev.ovh.api.telephony.portability.OvhSocialReason;
import net.minidev.ovh.api.telephony.portability.OvhSpecialNumberCategoryEnum;
import net.minidev.ovh.api.veeamcloudconnect.OvhOffer;
import net.minidev.ovh.api.vps.OvhPleskLicenseDomainNumberEnum;
import net.minidev.ovh.api.vps.additionaldisk.OvhAdditionalDiskSizeEnum;
import net.minidev.ovh.api.vps.ip.OvhGeolocationEnum;
import net.minidev.ovh.core.ApiOvhBase;
import net.minidev.ovh.core.ApiOvhCore;

/**
 * BasePath:https://eu.api.ovh.com/1.0
 * ResourcePath:/order
 * version:1.0
 */
public class ApiOvhOrder extends ApiOvhBase {
	public ApiOvhOrder(ApiOvhCore core) {
		super(core);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/telephony/lines/{serviceName}/addSimultaneousLines
	 * @param quantity [required] The quantity of extra simultaneous lines to add
	 * @param billingAccount [required] The name of your billingAccount
	 * @param serviceName [required] Your line number
	 * @deprecated
	 */
	public OvhOrder telephony_lines_serviceName_addSimultaneousLines_GET(String serviceName, String billingAccount, Long quantity) throws IOException {
		String qPath = "/order/telephony/lines/{serviceName}/addSimultaneousLines";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "billingAccount", billingAccount);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/telephony/lines/{serviceName}/addSimultaneousLines
	 * @param quantity [required] The quantity of extra simultaneous lines to add
	 * @param billingAccount [required] The name of your billingAccount
	 * @param serviceName [required] Your line number
	 * @deprecated
	 */
	public OvhOrder telephony_lines_serviceName_addSimultaneousLines_POST(String serviceName, String billingAccount, Long quantity) throws IOException {
		String qPath = "/order/telephony/lines/{serviceName}/addSimultaneousLines";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "billingAccount", billingAccount);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/telephony/lines/{serviceName}
	 * @param serviceName [required] Your line number
	 */
	public ArrayList<String> telephony_lines_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/telephony/lines/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}
	private static TypeReference<ArrayList<String>> t1 = new TypeReference<ArrayList<String>>() {};

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/telephony/lines/{serviceName}/updateSimultaneousChannels
	 * @param quantity [required] The quantity of total simultaneous channels requested
	 * @param serviceName [required] Your line number
	 */
	public OvhOrder telephony_lines_serviceName_updateSimultaneousChannels_GET(String serviceName, Long quantity) throws IOException {
		String qPath = "/order/telephony/lines/{serviceName}/updateSimultaneousChannels";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/telephony/lines/{serviceName}/updateSimultaneousChannels
	 * @param quantity [required] The quantity of total simultaneous channels requested
	 * @param serviceName [required] Your line number
	 */
	public OvhOrder telephony_lines_serviceName_updateSimultaneousChannels_POST(String serviceName, Long quantity) throws IOException {
		String qPath = "/order/telephony/lines/{serviceName}/updateSimultaneousChannels";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/telephony/lines/{serviceName}/hardware
	 * @param mondialRelayId [required] Use /supply/mondialRelay entry point to specify a relay point and ignore shipping contact address information entry.
	 * @param retractation [required] Retractation rights if set
	 * @param shippingContactId [required] Shipping contact information id from /me entry point
	 * @param hardware [required] The hardware you want to order for this specific line
	 * @param serviceName [required] Your line number
	 */
	public OvhOrder telephony_lines_serviceName_hardware_GET(String serviceName, String hardware, String mondialRelayId, Boolean retractation, String shippingContactId) throws IOException {
		String qPath = "/order/telephony/lines/{serviceName}/hardware";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "hardware", hardware);
		query(sb, "mondialRelayId", mondialRelayId);
		query(sb, "retractation", retractation);
		query(sb, "shippingContactId", shippingContactId);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/telephony/lines/{serviceName}/hardware
	 * @param mondialRelayId [required] Use /supply/mondialRelay entry point to specify a relay point and ignore shipping contact address information entry.
	 * @param retractation [required] Retractation rights if set
	 * @param shippingContactId [required] Shipping contact information id from /me entry point
	 * @param hardware [required] The hardware you want to order for this specific line
	 * @param serviceName [required] Your line number
	 */
	public OvhOrder telephony_lines_serviceName_hardware_POST(String serviceName, String hardware, String mondialRelayId, Boolean retractation, String shippingContactId) throws IOException {
		String qPath = "/order/telephony/lines/{serviceName}/hardware";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "hardware", hardware);
		addBody(o, "mondialRelayId", mondialRelayId);
		addBody(o, "retractation", retractation);
		addBody(o, "shippingContactId", shippingContactId);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/telephony/lines
	 */
	public ArrayList<String> telephony_lines_GET() throws IOException {
		String qPath = "/order/telephony/lines";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/telephony
	 */
	public ArrayList<String> telephony_GET() throws IOException {
		String qPath = "/order/telephony";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/telephony/{billingAccount}/numberNogeographic
	 * @param pool [required] Number of alias in case of pool
	 * @param streetName [required] Street name
	 * @param specificNumber [required] Preselected standard number
	 * @param firstname [required] Contact firstname
	 * @param legalform [required] Legal form
	 * @param email [required]
	 * @param country [required] Number country
	 * @param streetNumber [required] Street number
	 * @param phone [required] Contact phone
	 * @param city [required] Contact city
	 * @param displayUniversalDirectory [required] Publish contact informations on universal directories
	 * @param ape [required] Company ape
	 * @param offer [required] Number offer
	 * @param retractation [required] Retractation rights if set
	 * @param socialNomination [required] Company social nomination
	 * @param name [required] Contact name
	 * @param siret [required] Companu siret
	 * @param zip [required] Contact zip
	 * @param organisation [required] Contact organisation
	 * @param billingAccount [required] The name of your billingAccount
	 */
	public OvhOrder telephony_billingAccount_numberNogeographic_GET(String billingAccount, String ape, String city, OvhNumberCountryEnum country, Boolean displayUniversalDirectory, String email, String firstname, OvhLegalFormEnum legalform, String name, OvhNumberOffer offer, String organisation, String phone, OvhNumberPoolEnum pool, Boolean retractation, String siret, String socialNomination, String specificNumber, String streetName, String streetNumber, String zip) throws IOException {
		String qPath = "/order/telephony/{billingAccount}/numberNogeographic";
		StringBuilder sb = path(qPath, billingAccount);
		query(sb, "ape", ape);
		query(sb, "city", city);
		query(sb, "country", country);
		query(sb, "displayUniversalDirectory", displayUniversalDirectory);
		query(sb, "email", email);
		query(sb, "firstname", firstname);
		query(sb, "legalform", legalform);
		query(sb, "name", name);
		query(sb, "offer", offer);
		query(sb, "organisation", organisation);
		query(sb, "phone", phone);
		query(sb, "pool", pool);
		query(sb, "retractation", retractation);
		query(sb, "siret", siret);
		query(sb, "socialNomination", socialNomination);
		query(sb, "specificNumber", specificNumber);
		query(sb, "streetName", streetName);
		query(sb, "streetNumber", streetNumber);
		query(sb, "zip", zip);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/telephony/{billingAccount}/numberNogeographic
	 * @param pool [required] Number of alias in case of pool
	 * @param streetName [required] Street name
	 * @param specificNumber [required] Preselected standard number
	 * @param firstname [required] Contact firstname
	 * @param legalform [required] Legal form
	 * @param email [required]
	 * @param country [required] Number country
	 * @param streetNumber [required] Street number
	 * @param phone [required] Contact phone
	 * @param city [required] Contact city
	 * @param displayUniversalDirectory [required] Publish contact informations on universal directories
	 * @param ape [required] Company ape
	 * @param offer [required] Number offer
	 * @param retractation [required] Retractation rights if set
	 * @param socialNomination [required] Company social nomination
	 * @param name [required] Contact name
	 * @param siret [required] Companu siret
	 * @param zip [required] Contact zip
	 * @param organisation [required] Contact organisation
	 * @param billingAccount [required] The name of your billingAccount
	 */
	public OvhOrder telephony_billingAccount_numberNogeographic_POST(String billingAccount, String ape, String city, OvhNumberCountryEnum country, Boolean displayUniversalDirectory, String email, String firstname, OvhLegalFormEnum legalform, String name, OvhNumberOffer offer, String organisation, String phone, OvhNumberPoolEnum pool, Boolean retractation, String siret, String socialNomination, String specificNumber, String streetName, String streetNumber, String zip) throws IOException {
		String qPath = "/order/telephony/{billingAccount}/numberNogeographic";
		StringBuilder sb = path(qPath, billingAccount);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "ape", ape);
		addBody(o, "city", city);
		addBody(o, "country", country);
		addBody(o, "displayUniversalDirectory", displayUniversalDirectory);
		addBody(o, "email", email);
		addBody(o, "firstname", firstname);
		addBody(o, "legalform", legalform);
		addBody(o, "name", name);
		addBody(o, "offer", offer);
		addBody(o, "organisation", organisation);
		addBody(o, "phone", phone);
		addBody(o, "pool", pool);
		addBody(o, "retractation", retractation);
		addBody(o, "siret", siret);
		addBody(o, "socialNomination", socialNomination);
		addBody(o, "specificNumber", specificNumber);
		addBody(o, "streetName", streetName);
		addBody(o, "streetNumber", streetNumber);
		addBody(o, "zip", zip);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/telephony/{billingAccount}/accessories
	 * @param shippingContactId [required] Shipping contact information id from /me entry point
	 * @param accessories [required] Accessories to order
	 * @param mondialRelayId [required] Use /supply/mondialRelay entry point to specify a relay point and ignore shipping contact address information entry.
	 * @param retractation [required] Retractation rights if set
	 * @param billingAccount [required] The name of your billingAccount
	 */
	public OvhOrder telephony_billingAccount_accessories_GET(String billingAccount, String[] accessories, String mondialRelayId, Boolean retractation, Long shippingContactId) throws IOException {
		String qPath = "/order/telephony/{billingAccount}/accessories";
		StringBuilder sb = path(qPath, billingAccount);
		query(sb, "accessories", accessories);
		query(sb, "mondialRelayId", mondialRelayId);
		query(sb, "retractation", retractation);
		query(sb, "shippingContactId", shippingContactId);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/telephony/{billingAccount}/accessories
	 * @param shippingContactId [required] Shipping contact information id from /me entry point
	 * @param accessories [required] Accessories to order
	 * @param mondialRelayId [required] Use /supply/mondialRelay entry point to specify a relay point and ignore shipping contact address information entry.
	 * @param retractation [required] Retractation rights if set
	 * @param billingAccount [required] The name of your billingAccount
	 */
	public OvhOrder telephony_billingAccount_accessories_POST(String billingAccount, String[] accessories, String mondialRelayId, Boolean retractation, Long shippingContactId) throws IOException {
		String qPath = "/order/telephony/{billingAccount}/accessories";
		StringBuilder sb = path(qPath, billingAccount);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "accessories", accessories);
		addBody(o, "mondialRelayId", mondialRelayId);
		addBody(o, "retractation", retractation);
		addBody(o, "shippingContactId", shippingContactId);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/telephony/{billingAccount}
	 * @param billingAccount [required] The name of your billingAccount
	 */
	public ArrayList<String> telephony_billingAccount_GET(String billingAccount) throws IOException {
		String qPath = "/order/telephony/{billingAccount}";
		StringBuilder sb = path(qPath, billingAccount);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/telephony/{billingAccount}/portability
	 * @param displayUniversalDirectory [required] Publish informations on directory ? (Yellow Pages, 118XXX, ...)
	 * @param city [required] Address city
	 * @param contactName [required] Your contact name
	 * @param callNumber [required] The number you want to port
	 * @param mobilePhone [required] Mobile phone to use to text portability status
	 * @param contactNumber [required] Your contact phone number
	 * @param offer [required] The offer : individual or company
	 * @param name [required] Your name
	 * @param executeAsSoonAsPossible [required] Ask to port the number as soon as possible
	 * @param siret [required] If you port under your society, the SIRET number
	 * @param firstName [required] Your firstname
	 * @param floor [required] Address floor
	 * @param specialNumberCategory [required] The special number category (needed if type is special)
	 * @param streetNumberExtra [required] Address street number extra : bis, ter, ...
	 * @param zip [required] Address zip code
	 * @param desireDate [required] The date you want for portability execution. Overridden if flag executeAsSoonAsPossible is set
	 * @param stair [required] Address stair
	 * @param socialReason [required] Your social reason
	 * @param streetName [required] Address street name
	 * @param streetType [required] Address street type
	 * @param fiabilisation [required] Ask for a fiabilisation or not (FR only)
	 * @param lineToRedirectAliasTo [required] Redirect ported numbers to the specific line
	 * @param type [required] The type of number : landline or special
	 * @param building [required] Address building
	 * @param listNumbers [required] Extra numbers to be ported, a comma separated list of numbers
	 * @param door [required] Address door
	 * @param streetNumber [required] Address street number
	 * @param rio [required] RIO of the number for individual offer
	 * @param country [required] Country of number
	 * @param billingAccount [required] The name of your billingAccount
	 */
	public OvhOrder telephony_billingAccount_portability_GET(String billingAccount, String building, String callNumber, String city, String contactName, String contactNumber, OvhCountriesAvailable country, Date desireDate, Boolean displayUniversalDirectory, String door, Boolean executeAsSoonAsPossible, Boolean fiabilisation, String firstName, Double floor, String lineToRedirectAliasTo, String listNumbers, String mobilePhone, String name, OvhOfferType offer, String rio, String siret, OvhSocialReason socialReason, OvhSpecialNumberCategoryEnum specialNumberCategory, Double stair, String streetName, Double streetNumber, String streetNumberExtra, String streetType, OvhNumberType type, String zip) throws IOException {
		String qPath = "/order/telephony/{billingAccount}/portability";
		StringBuilder sb = path(qPath, billingAccount);
		query(sb, "building", building);
		query(sb, "callNumber", callNumber);
		query(sb, "city", city);
		query(sb, "contactName", contactName);
		query(sb, "contactNumber", contactNumber);
		query(sb, "country", country);
		query(sb, "desireDate", desireDate);
		query(sb, "displayUniversalDirectory", displayUniversalDirectory);
		query(sb, "door", door);
		query(sb, "executeAsSoonAsPossible", executeAsSoonAsPossible);
		query(sb, "fiabilisation", fiabilisation);
		query(sb, "firstName", firstName);
		query(sb, "floor", floor);
		query(sb, "lineToRedirectAliasTo", lineToRedirectAliasTo);
		query(sb, "listNumbers", listNumbers);
		query(sb, "mobilePhone", mobilePhone);
		query(sb, "name", name);
		query(sb, "offer", offer);
		query(sb, "rio", rio);
		query(sb, "siret", siret);
		query(sb, "socialReason", socialReason);
		query(sb, "specialNumberCategory", specialNumberCategory);
		query(sb, "stair", stair);
		query(sb, "streetName", streetName);
		query(sb, "streetNumber", streetNumber);
		query(sb, "streetNumberExtra", streetNumberExtra);
		query(sb, "streetType", streetType);
		query(sb, "type", type);
		query(sb, "zip", zip);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/telephony/{billingAccount}/portability
	 * @param displayUniversalDirectory [required] Publish informations on directory ? (Yellow Pages, 118XXX, ...)
	 * @param city [required] Address city
	 * @param contactName [required] Your contact name
	 * @param callNumber [required] The number you want to port
	 * @param mobilePhone [required] Mobile phone to use to text portability status
	 * @param contactNumber [required] Your contact phone number
	 * @param offer [required] The offer : individual or company
	 * @param name [required] Your name
	 * @param executeAsSoonAsPossible [required] Ask to port the number as soon as possible
	 * @param siret [required] If you port under your society, the SIRET number
	 * @param firstName [required] Your firstname
	 * @param floor [required] Address floor
	 * @param specialNumberCategory [required] The special number category (needed if type is special)
	 * @param streetNumberExtra [required] Address street number extra : bis, ter, ...
	 * @param zip [required] Address zip code
	 * @param desireDate [required] The date you want for portability execution. Overridden if flag executeAsSoonAsPossible is set
	 * @param stair [required] Address stair
	 * @param socialReason [required] Your social reason
	 * @param streetName [required] Address street name
	 * @param streetType [required] Address street type
	 * @param fiabilisation [required] Ask for a fiabilisation or not (FR only)
	 * @param lineToRedirectAliasTo [required] Redirect ported numbers to the specific line
	 * @param type [required] The type of number : landline or special
	 * @param building [required] Address building
	 * @param listNumbers [required] Extra numbers to be ported, a comma separated list of numbers
	 * @param door [required] Address door
	 * @param streetNumber [required] Address street number
	 * @param rio [required] RIO of the number for individual offer
	 * @param country [required] Country of number
	 * @param billingAccount [required] The name of your billingAccount
	 */
	public OvhOrder telephony_billingAccount_portability_POST(String billingAccount, String building, String callNumber, String city, String contactName, String contactNumber, OvhCountriesAvailable country, Date desireDate, Boolean displayUniversalDirectory, String door, Boolean executeAsSoonAsPossible, Boolean fiabilisation, String firstName, Double floor, String lineToRedirectAliasTo, String listNumbers, String mobilePhone, String name, OvhOfferType offer, String rio, String siret, OvhSocialReason socialReason, OvhSpecialNumberCategoryEnum specialNumberCategory, Double stair, String streetName, Double streetNumber, String streetNumberExtra, String streetType, OvhNumberType type, String zip) throws IOException {
		String qPath = "/order/telephony/{billingAccount}/portability";
		StringBuilder sb = path(qPath, billingAccount);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "building", building);
		addBody(o, "callNumber", callNumber);
		addBody(o, "city", city);
		addBody(o, "contactName", contactName);
		addBody(o, "contactNumber", contactNumber);
		addBody(o, "country", country);
		addBody(o, "desireDate", desireDate);
		addBody(o, "displayUniversalDirectory", displayUniversalDirectory);
		addBody(o, "door", door);
		addBody(o, "executeAsSoonAsPossible", executeAsSoonAsPossible);
		addBody(o, "fiabilisation", fiabilisation);
		addBody(o, "firstName", firstName);
		addBody(o, "floor", floor);
		addBody(o, "lineToRedirectAliasTo", lineToRedirectAliasTo);
		addBody(o, "listNumbers", listNumbers);
		addBody(o, "mobilePhone", mobilePhone);
		addBody(o, "name", name);
		addBody(o, "offer", offer);
		addBody(o, "rio", rio);
		addBody(o, "siret", siret);
		addBody(o, "socialReason", socialReason);
		addBody(o, "specialNumberCategory", specialNumberCategory);
		addBody(o, "stair", stair);
		addBody(o, "streetName", streetName);
		addBody(o, "streetNumber", streetNumber);
		addBody(o, "streetNumberExtra", streetNumberExtra);
		addBody(o, "streetType", streetType);
		addBody(o, "type", type);
		addBody(o, "zip", zip);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/telephony/{billingAccount}/numberSpecial
	 * @param typology [required] Special range typology
	 * @param streetNumber [required] Street number
	 * @param phone [required] Contact phone
	 * @param country [required] Number country
	 * @param email [required]
	 * @param legalform [required] Legal form
	 * @param firstname [required] Contact firstname
	 * @param specificNumber [required] Preselected standard number
	 * @param streetName [required] Street name
	 * @param pool [required] Number of alias in case of pool
	 * @param range [required] Special range
	 * @param organisation [required] Contact organisation
	 * @param zip [required] Contact zip
	 * @param siret [required] Companu siret
	 * @param name [required] Contact name
	 * @param socialNomination [required] Company social nomination
	 * @param retractation [required] Retractation rights if set
	 * @param ape [required] Company ape
	 * @param displayUniversalDirectory [required] Publish contact informations on universal directories
	 * @param city [required] Contact city
	 * @param billingAccount [required] The name of your billingAccount
	 */
	public OvhOrder telephony_billingAccount_numberSpecial_GET(String billingAccount, String ape, String city, OvhNumberCountryEnum country, Boolean displayUniversalDirectory, String email, String firstname, OvhLegalFormEnum legalform, String name, String organisation, String phone, OvhNumberPoolEnum pool, String range, Boolean retractation, String siret, String socialNomination, String specificNumber, String streetName, String streetNumber, OvhNumberSpecialTypologyEnum typology, String zip) throws IOException {
		String qPath = "/order/telephony/{billingAccount}/numberSpecial";
		StringBuilder sb = path(qPath, billingAccount);
		query(sb, "ape", ape);
		query(sb, "city", city);
		query(sb, "country", country);
		query(sb, "displayUniversalDirectory", displayUniversalDirectory);
		query(sb, "email", email);
		query(sb, "firstname", firstname);
		query(sb, "legalform", legalform);
		query(sb, "name", name);
		query(sb, "organisation", organisation);
		query(sb, "phone", phone);
		query(sb, "pool", pool);
		query(sb, "range", range);
		query(sb, "retractation", retractation);
		query(sb, "siret", siret);
		query(sb, "socialNomination", socialNomination);
		query(sb, "specificNumber", specificNumber);
		query(sb, "streetName", streetName);
		query(sb, "streetNumber", streetNumber);
		query(sb, "typology", typology);
		query(sb, "zip", zip);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/telephony/{billingAccount}/numberSpecial
	 * @param typology [required] Special range typology
	 * @param streetNumber [required] Street number
	 * @param phone [required] Contact phone
	 * @param country [required] Number country
	 * @param email [required]
	 * @param legalform [required] Legal form
	 * @param firstname [required] Contact firstname
	 * @param specificNumber [required] Preselected standard number
	 * @param streetName [required] Street name
	 * @param pool [required] Number of alias in case of pool
	 * @param range [required] Special range
	 * @param organisation [required] Contact organisation
	 * @param zip [required] Contact zip
	 * @param siret [required] Companu siret
	 * @param name [required] Contact name
	 * @param socialNomination [required] Company social nomination
	 * @param retractation [required] Retractation rights if set
	 * @param ape [required] Company ape
	 * @param displayUniversalDirectory [required] Publish contact informations on universal directories
	 * @param city [required] Contact city
	 * @param billingAccount [required] The name of your billingAccount
	 */
	public OvhOrder telephony_billingAccount_numberSpecial_POST(String billingAccount, String ape, String city, OvhNumberCountryEnum country, Boolean displayUniversalDirectory, String email, String firstname, OvhLegalFormEnum legalform, String name, String organisation, String phone, OvhNumberPoolEnum pool, String range, Boolean retractation, String siret, String socialNomination, String specificNumber, String streetName, String streetNumber, OvhNumberSpecialTypologyEnum typology, String zip) throws IOException {
		String qPath = "/order/telephony/{billingAccount}/numberSpecial";
		StringBuilder sb = path(qPath, billingAccount);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "ape", ape);
		addBody(o, "city", city);
		addBody(o, "country", country);
		addBody(o, "displayUniversalDirectory", displayUniversalDirectory);
		addBody(o, "email", email);
		addBody(o, "firstname", firstname);
		addBody(o, "legalform", legalform);
		addBody(o, "name", name);
		addBody(o, "organisation", organisation);
		addBody(o, "phone", phone);
		addBody(o, "pool", pool);
		addBody(o, "range", range);
		addBody(o, "retractation", retractation);
		addBody(o, "siret", siret);
		addBody(o, "socialNomination", socialNomination);
		addBody(o, "specificNumber", specificNumber);
		addBody(o, "streetName", streetName);
		addBody(o, "streetNumber", streetNumber);
		addBody(o, "typology", typology);
		addBody(o, "zip", zip);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/telephony/{billingAccount}/securityDeposit
	 * @param amount [required] The amount, in euros, to credit to the current security deposit
	 * @param billingAccount [required] The name of your billingAccount
	 */
	public OvhOrder telephony_billingAccount_securityDeposit_GET(String billingAccount, OvhSecurityDepositAmountsEnum amount) throws IOException {
		String qPath = "/order/telephony/{billingAccount}/securityDeposit";
		StringBuilder sb = path(qPath, billingAccount);
		query(sb, "amount", amount);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/telephony/{billingAccount}/securityDeposit
	 * @param amount [required] The amount, in euros, to credit to the current security deposit
	 * @param billingAccount [required] The name of your billingAccount
	 */
	public OvhOrder telephony_billingAccount_securityDeposit_POST(String billingAccount, OvhSecurityDepositAmountsEnum amount) throws IOException {
		String qPath = "/order/telephony/{billingAccount}/securityDeposit";
		StringBuilder sb = path(qPath, billingAccount);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "amount", amount);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/telephony/{billingAccount}/numberGeographic
	 * @param city [required] Contact city
	 * @param displayUniversalDirectory [required] Publish contact informations on universal directories
	 * @param offer [required] Number offer
	 * @param ape [required] Company ape
	 * @param name [required] Contact name
	 * @param retractation [required] Retractation rights if set
	 * @param socialNomination [required] Company social nomination
	 * @param zip [required] Contact zip
	 * @param organisation [required] Contact organisation
	 * @param siret [required] Companu siret
	 * @param streetName [required] Street name
	 * @param pool [required] Number of alias in case of pool
	 * @param specificNumber [required] Preselected standard number
	 * @param zone [required] Zone
	 * @param firstname [required] Contact firstname
	 * @param legalform [required] Legal form
	 * @param email [required]
	 * @param country [required] Number country
	 * @param streetNumber [required] Street number
	 * @param phone [required] Contact phone
	 * @param billingAccount [required] The name of your billingAccount
	 */
	public OvhOrder telephony_billingAccount_numberGeographic_GET(String billingAccount, String ape, String city, OvhNumberCountryEnum country, Boolean displayUniversalDirectory, String email, String firstname, OvhLegalFormEnum legalform, String name, OvhNumberOffer offer, String organisation, String phone, OvhNumberPoolEnum pool, Boolean retractation, String siret, String socialNomination, String specificNumber, String streetName, String streetNumber, String zip, String zone) throws IOException {
		String qPath = "/order/telephony/{billingAccount}/numberGeographic";
		StringBuilder sb = path(qPath, billingAccount);
		query(sb, "ape", ape);
		query(sb, "city", city);
		query(sb, "country", country);
		query(sb, "displayUniversalDirectory", displayUniversalDirectory);
		query(sb, "email", email);
		query(sb, "firstname", firstname);
		query(sb, "legalform", legalform);
		query(sb, "name", name);
		query(sb, "offer", offer);
		query(sb, "organisation", organisation);
		query(sb, "phone", phone);
		query(sb, "pool", pool);
		query(sb, "retractation", retractation);
		query(sb, "siret", siret);
		query(sb, "socialNomination", socialNomination);
		query(sb, "specificNumber", specificNumber);
		query(sb, "streetName", streetName);
		query(sb, "streetNumber", streetNumber);
		query(sb, "zip", zip);
		query(sb, "zone", zone);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/telephony/{billingAccount}/numberGeographic
	 * @param city [required] Contact city
	 * @param displayUniversalDirectory [required] Publish contact informations on universal directories
	 * @param offer [required] Number offer
	 * @param ape [required] Company ape
	 * @param name [required] Contact name
	 * @param retractation [required] Retractation rights if set
	 * @param socialNomination [required] Company social nomination
	 * @param zip [required] Contact zip
	 * @param organisation [required] Contact organisation
	 * @param siret [required] Companu siret
	 * @param streetName [required] Street name
	 * @param pool [required] Number of alias in case of pool
	 * @param specificNumber [required] Preselected standard number
	 * @param zone [required] Zone
	 * @param firstname [required] Contact firstname
	 * @param legalform [required] Legal form
	 * @param email [required]
	 * @param country [required] Number country
	 * @param streetNumber [required] Street number
	 * @param phone [required] Contact phone
	 * @param billingAccount [required] The name of your billingAccount
	 */
	public OvhOrder telephony_billingAccount_numberGeographic_POST(String billingAccount, String ape, String city, OvhNumberCountryEnum country, Boolean displayUniversalDirectory, String email, String firstname, OvhLegalFormEnum legalform, String name, OvhNumberOffer offer, String organisation, String phone, OvhNumberPoolEnum pool, Boolean retractation, String siret, String socialNomination, String specificNumber, String streetName, String streetNumber, String zip, String zone) throws IOException {
		String qPath = "/order/telephony/{billingAccount}/numberGeographic";
		StringBuilder sb = path(qPath, billingAccount);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "ape", ape);
		addBody(o, "city", city);
		addBody(o, "country", country);
		addBody(o, "displayUniversalDirectory", displayUniversalDirectory);
		addBody(o, "email", email);
		addBody(o, "firstname", firstname);
		addBody(o, "legalform", legalform);
		addBody(o, "name", name);
		addBody(o, "offer", offer);
		addBody(o, "organisation", organisation);
		addBody(o, "phone", phone);
		addBody(o, "pool", pool);
		addBody(o, "retractation", retractation);
		addBody(o, "siret", siret);
		addBody(o, "socialNomination", socialNomination);
		addBody(o, "specificNumber", specificNumber);
		addBody(o, "streetName", streetName);
		addBody(o, "streetNumber", streetNumber);
		addBody(o, "zip", zip);
		addBody(o, "zone", zone);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/telephony/{billingAccount}/line
	 * @param mondialRelayId [required] Use /supply/mondialRelay entry point to specify a relay point and ignore shipping address information entry.
	 * @param types [required] Number type. Set several types for each line per phone
	 * @param offers [required] The line offers. Set several offers for each line per phone (Deprecated, use offer method instead)
	 * @param quantity [required] Quantity of request repetition in this configuration
	 * @param retractation [required] Retractation rights if set
	 * @param displayUniversalDirectories [required] Publish owner contact informations on universal directories or not
	 * @param ownerContactIds [required] Owner contact information id from /me entry point for each line
	 * @param shippingContactId [required] Shipping contact information id from /me entry point
	 * @param extraSimultaneousLines [required] Additional simultaneous numbers. Set several simultaneous lines for each line per phone
	 * @param brand [required] Phone brands wanted with the offer. Set null for NO phone
	 * @param zones [required] Geographic zones. Let empty for nogeographic type. Set several zones for each line per phone
	 * @param billingAccount [required] The name of your billingAccount
	 */
	public OvhOrder telephony_billingAccount_line_GET(String billingAccount, String brand, Boolean[] displayUniversalDirectories, Long[] extraSimultaneousLines, String mondialRelayId, String[] offers, Long[] ownerContactIds, Long quantity, Boolean retractation, Long shippingContactId, OvhLineTypeEnum[] types, String[] zones) throws IOException {
		String qPath = "/order/telephony/{billingAccount}/line";
		StringBuilder sb = path(qPath, billingAccount);
		query(sb, "brand", brand);
		query(sb, "displayUniversalDirectories", displayUniversalDirectories);
		query(sb, "extraSimultaneousLines", extraSimultaneousLines);
		query(sb, "mondialRelayId", mondialRelayId);
		query(sb, "offers", offers);
		query(sb, "ownerContactIds", ownerContactIds);
		query(sb, "quantity", quantity);
		query(sb, "retractation", retractation);
		query(sb, "shippingContactId", shippingContactId);
		query(sb, "types", types);
		query(sb, "zones", zones);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/telephony/{billingAccount}/line
	 * @param mondialRelayId [required] Use /supply/mondialRelay entry point to specify a relay point and ignore shipping address information entry.
	 * @param types [required] Number type. Set several types for each line per phone
	 * @param offers [required] The line offers. Set several offers for each line per phone (Deprecated, use offer method instead)
	 * @param quantity [required] Quantity of request repetition in this configuration
	 * @param retractation [required] Retractation rights if set
	 * @param displayUniversalDirectories [required] Publish owner contact informations on universal directories or not
	 * @param ownerContactIds [required] Owner contact information id from /me entry point for each line
	 * @param shippingContactId [required] Shipping contact information id from /me entry point
	 * @param extraSimultaneousLines [required] Additional simultaneous numbers. Set several simultaneous lines for each line per phone
	 * @param brand [required] Phone brands wanted with the offer. Set null for NO phone
	 * @param zones [required] Geographic zones. Let empty for nogeographic type. Set several zones for each line per phone
	 * @param billingAccount [required] The name of your billingAccount
	 */
	public OvhOrder telephony_billingAccount_line_POST(String billingAccount, String brand, Boolean[] displayUniversalDirectories, Long[] extraSimultaneousLines, String mondialRelayId, String[] offers, Long[] ownerContactIds, Long quantity, Boolean retractation, Long shippingContactId, OvhLineTypeEnum[] types, String[] zones) throws IOException {
		String qPath = "/order/telephony/{billingAccount}/line";
		StringBuilder sb = path(qPath, billingAccount);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "brand", brand);
		addBody(o, "displayUniversalDirectories", displayUniversalDirectories);
		addBody(o, "extraSimultaneousLines", extraSimultaneousLines);
		addBody(o, "mondialRelayId", mondialRelayId);
		addBody(o, "offers", offers);
		addBody(o, "ownerContactIds", ownerContactIds);
		addBody(o, "quantity", quantity);
		addBody(o, "retractation", retractation);
		addBody(o, "shippingContactId", shippingContactId);
		addBody(o, "types", types);
		addBody(o, "zones", zones);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/telephony/spare/new
	 * @param quantity [required] Number of phone quantity
	 * @param brand [required] Spare phone brand model
	 * @param shippingContactId [required] Shipping contact information id from /me entry point
	 * @param mondialRelayId [required] Use /supply/mondialRelay entry point to specify a relay point and ignore shipping contact address information entry.
	 */
	public OvhOrder telephony_spare_new_GET(String brand, String mondialRelayId, Long quantity, Long shippingContactId) throws IOException {
		String qPath = "/order/telephony/spare/new";
		StringBuilder sb = path(qPath);
		query(sb, "brand", brand);
		query(sb, "mondialRelayId", mondialRelayId);
		query(sb, "quantity", quantity);
		query(sb, "shippingContactId", shippingContactId);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/telephony/spare/new
	 * @param quantity [required] Number of phone quantity
	 * @param brand [required] Spare phone brand model
	 * @param shippingContactId [required] Shipping contact information id from /me entry point
	 * @param mondialRelayId [required] Use /supply/mondialRelay entry point to specify a relay point and ignore shipping contact address information entry.
	 */
	public OvhOrder telephony_spare_new_POST(String brand, String mondialRelayId, Long quantity, Long shippingContactId) throws IOException {
		String qPath = "/order/telephony/spare/new";
		StringBuilder sb = path(qPath);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "brand", brand);
		addBody(o, "mondialRelayId", mondialRelayId);
		addBody(o, "quantity", quantity);
		addBody(o, "shippingContactId", shippingContactId);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/telephony/new
	 */
	public OvhOrder telephony_new_GET() throws IOException {
		String qPath = "/order/telephony/new";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/telephony/new
	 */
	public OvhOrder telephony_new_POST() throws IOException {
		String qPath = "/order/telephony/new";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "POST", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/telephony/trunks/{serviceName}/hardware
	 * @param mondialRelayId [required] Use /supply/mondialRelay entry point to specify a relay point and ignore shipping contact address information entry.
	 * @param retractation [required] Retractation rights if set
	 * @param shippingContactId [required] Shipping contact information id from /me entry point
	 * @param hardware [required] The hardware you want to order for this specific line
	 * @param serviceName [required] Your trunk number
	 */
	public OvhOrder telephony_trunks_serviceName_hardware_GET(String serviceName, String hardware, String mondialRelayId, Boolean retractation, String shippingContactId) throws IOException {
		String qPath = "/order/telephony/trunks/{serviceName}/hardware";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "hardware", hardware);
		query(sb, "mondialRelayId", mondialRelayId);
		query(sb, "retractation", retractation);
		query(sb, "shippingContactId", shippingContactId);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/telephony/trunks/{serviceName}/hardware
	 * @param mondialRelayId [required] Use /supply/mondialRelay entry point to specify a relay point and ignore shipping contact address information entry.
	 * @param retractation [required] Retractation rights if set
	 * @param shippingContactId [required] Shipping contact information id from /me entry point
	 * @param hardware [required] The hardware you want to order for this specific line
	 * @param serviceName [required] Your trunk number
	 */
	public OvhOrder telephony_trunks_serviceName_hardware_POST(String serviceName, String hardware, String mondialRelayId, Boolean retractation, String shippingContactId) throws IOException {
		String qPath = "/order/telephony/trunks/{serviceName}/hardware";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "hardware", hardware);
		addBody(o, "mondialRelayId", mondialRelayId);
		addBody(o, "retractation", retractation);
		addBody(o, "shippingContactId", shippingContactId);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/telephony/trunks/{serviceName}/updateSimultaneousChannels
	 * @param quantity [required] The quantity of total simultaneous channels requested
	 * @param serviceName [required] Your trunk number
	 */
	public OvhOrder telephony_trunks_serviceName_updateSimultaneousChannels_GET(String serviceName, Long quantity) throws IOException {
		String qPath = "/order/telephony/trunks/{serviceName}/updateSimultaneousChannels";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/telephony/trunks/{serviceName}/updateSimultaneousChannels
	 * @param quantity [required] The quantity of total simultaneous channels requested
	 * @param serviceName [required] Your trunk number
	 */
	public OvhOrder telephony_trunks_serviceName_updateSimultaneousChannels_POST(String serviceName, Long quantity) throws IOException {
		String qPath = "/order/telephony/trunks/{serviceName}/updateSimultaneousChannels";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/telephony/trunks/{serviceName}
	 * @param serviceName [required] Your trunk number
	 */
	public ArrayList<String> telephony_trunks_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/telephony/trunks/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/telephony/trunks/{serviceName}/addSimultaneousLines
	 * @param quantity [required] The quantity of extra simultaneous lines to add
	 * @param billingAccount [required] The name of your billingAccount
	 * @param serviceName [required] Your trunk number
	 * @deprecated
	 */
	public OvhOrder telephony_trunks_serviceName_addSimultaneousLines_GET(String serviceName, String billingAccount, Long quantity) throws IOException {
		String qPath = "/order/telephony/trunks/{serviceName}/addSimultaneousLines";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "billingAccount", billingAccount);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/telephony/trunks/{serviceName}/addSimultaneousLines
	 * @param quantity [required] The quantity of extra simultaneous lines to add
	 * @param billingAccount [required] The name of your billingAccount
	 * @param serviceName [required] Your trunk number
	 * @deprecated
	 */
	public OvhOrder telephony_trunks_serviceName_addSimultaneousLines_POST(String serviceName, String billingAccount, Long quantity) throws IOException {
		String qPath = "/order/telephony/trunks/{serviceName}/addSimultaneousLines";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "billingAccount", billingAccount);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/telephony/trunks
	 */
	public ArrayList<String> telephony_trunks_GET() throws IOException {
		String qPath = "/order/telephony/trunks";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/vps/{serviceName}/upgrade/{duration}
	 * @param model [required] Model
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 */
	public OvhOrder vps_serviceName_upgrade_duration_GET(String serviceName, String duration, String model) throws IOException {
		String qPath = "/order/vps/{serviceName}/upgrade/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "model", model);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/vps/{serviceName}/upgrade/{duration}
	 * @param model [required] Model
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 */
	public OvhOrder vps_serviceName_upgrade_duration_POST(String serviceName, String duration, String model) throws IOException {
		String qPath = "/order/vps/{serviceName}/upgrade/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "model", model);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'upgrade' option
	 *
	 * REST: GET /order/vps/{serviceName}/upgrade
	 * @param model [required] Model
	 * @param serviceName [required] The internal name of your VPS offer
	 */
	public ArrayList<String> vps_serviceName_upgrade_GET(String serviceName, String model) throws IOException {
		String qPath = "/order/vps/{serviceName}/upgrade";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "model", model);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/vps/{serviceName}/ftpbackup/{duration}
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 */
	public OvhOrder vps_serviceName_ftpbackup_duration_GET(String serviceName, String duration) throws IOException {
		String qPath = "/order/vps/{serviceName}/ftpbackup/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/vps/{serviceName}/ftpbackup/{duration}
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 */
	public OvhOrder vps_serviceName_ftpbackup_duration_POST(String serviceName, String duration) throws IOException {
		String qPath = "/order/vps/{serviceName}/ftpbackup/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "POST", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'ftpbackup' option
	 *
	 * REST: GET /order/vps/{serviceName}/ftpbackup
	 * @param serviceName [required] The internal name of your VPS offer
	 */
	public ArrayList<String> vps_serviceName_ftpbackup_GET(String serviceName) throws IOException {
		String qPath = "/order/vps/{serviceName}/ftpbackup";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'windows' option
	 *
	 * REST: GET /order/vps/{serviceName}/windows
	 * @param serviceName [required] The internal name of your VPS offer
	 */
	public ArrayList<String> vps_serviceName_windows_GET(String serviceName) throws IOException {
		String qPath = "/order/vps/{serviceName}/windows";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/vps/{serviceName}/windows/{duration}
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 */
	public OvhOrder vps_serviceName_windows_duration_GET(String serviceName, String duration) throws IOException {
		String qPath = "/order/vps/{serviceName}/windows/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/vps/{serviceName}/windows/{duration}
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 */
	public OvhOrder vps_serviceName_windows_duration_POST(String serviceName, String duration) throws IOException {
		String qPath = "/order/vps/{serviceName}/windows/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "POST", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/vps/{serviceName}
	 * @param serviceName [required] The internal name of your VPS offer
	 */
	public ArrayList<String> vps_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/vps/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/vps/{serviceName}/automatedBackup/{duration}
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 */
	public OvhOrder vps_serviceName_automatedBackup_duration_GET(String serviceName, String duration) throws IOException {
		String qPath = "/order/vps/{serviceName}/automatedBackup/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/vps/{serviceName}/automatedBackup/{duration}
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 */
	public OvhOrder vps_serviceName_automatedBackup_duration_POST(String serviceName, String duration) throws IOException {
		String qPath = "/order/vps/{serviceName}/automatedBackup/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "POST", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'automatedBackup' option
	 *
	 * REST: GET /order/vps/{serviceName}/automatedBackup
	 * @param serviceName [required] The internal name of your VPS offer
	 */
	public ArrayList<String> vps_serviceName_automatedBackup_GET(String serviceName) throws IOException {
		String qPath = "/order/vps/{serviceName}/automatedBackup";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'snapshot' option
	 *
	 * REST: GET /order/vps/{serviceName}/snapshot
	 * @param serviceName [required] The internal name of your VPS offer
	 */
	public ArrayList<String> vps_serviceName_snapshot_GET(String serviceName) throws IOException {
		String qPath = "/order/vps/{serviceName}/snapshot";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/vps/{serviceName}/snapshot/{duration}
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 */
	public OvhOrder vps_serviceName_snapshot_duration_GET(String serviceName, String duration) throws IOException {
		String qPath = "/order/vps/{serviceName}/snapshot/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/vps/{serviceName}/snapshot/{duration}
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 */
	public OvhOrder vps_serviceName_snapshot_duration_POST(String serviceName, String duration) throws IOException {
		String qPath = "/order/vps/{serviceName}/snapshot/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "POST", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/vps/{serviceName}/additionalDisk/{duration}
	 * @param additionalDiskSize [required] Size of the additional disk
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 */
	public OvhOrder vps_serviceName_additionalDisk_duration_GET(String serviceName, String duration, OvhAdditionalDiskSizeEnum additionalDiskSize) throws IOException {
		String qPath = "/order/vps/{serviceName}/additionalDisk/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "additionalDiskSize", additionalDiskSize);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/vps/{serviceName}/additionalDisk/{duration}
	 * @param additionalDiskSize [required] Size of the additional disk
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 */
	public OvhOrder vps_serviceName_additionalDisk_duration_POST(String serviceName, String duration, OvhAdditionalDiskSizeEnum additionalDiskSize) throws IOException {
		String qPath = "/order/vps/{serviceName}/additionalDisk/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "additionalDiskSize", additionalDiskSize);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'additionalDisk' option
	 *
	 * REST: GET /order/vps/{serviceName}/additionalDisk
	 * @param additionalDiskSize [required] Size of the additional disk
	 * @param serviceName [required] The internal name of your VPS offer
	 */
	public ArrayList<String> vps_serviceName_additionalDisk_GET(String serviceName, OvhAdditionalDiskSizeEnum additionalDiskSize) throws IOException {
		String qPath = "/order/vps/{serviceName}/additionalDisk";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "additionalDiskSize", additionalDiskSize);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/vps/{serviceName}/veeam/{duration}
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 * @deprecated
	 */
	public OvhOrder vps_serviceName_veeam_duration_GET(String serviceName, String duration) throws IOException {
		String qPath = "/order/vps/{serviceName}/veeam/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/vps/{serviceName}/veeam/{duration}
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 * @deprecated
	 */
	public OvhOrder vps_serviceName_veeam_duration_POST(String serviceName, String duration) throws IOException {
		String qPath = "/order/vps/{serviceName}/veeam/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "POST", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'veeam' option
	 *
	 * REST: GET /order/vps/{serviceName}/veeam
	 * @param serviceName [required] The internal name of your VPS offer
	 * @deprecated
	 */
	public ArrayList<String> vps_serviceName_veeam_GET(String serviceName) throws IOException {
		String qPath = "/order/vps/{serviceName}/veeam";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/vps/{serviceName}/cpanel/{duration}
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 * @deprecated
	 */
	public OvhOrder vps_serviceName_cpanel_duration_GET(String serviceName, String duration) throws IOException {
		String qPath = "/order/vps/{serviceName}/cpanel/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/vps/{serviceName}/cpanel/{duration}
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 * @deprecated
	 */
	public OvhOrder vps_serviceName_cpanel_duration_POST(String serviceName, String duration) throws IOException {
		String qPath = "/order/vps/{serviceName}/cpanel/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "POST", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'cpanel' option
	 *
	 * REST: GET /order/vps/{serviceName}/cpanel
	 * @param serviceName [required] The internal name of your VPS offer
	 * @deprecated
	 */
	public ArrayList<String> vps_serviceName_cpanel_GET(String serviceName) throws IOException {
		String qPath = "/order/vps/{serviceName}/cpanel";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'plesk' option
	 *
	 * REST: GET /order/vps/{serviceName}/plesk
	 * @param domainNumber [required] Domain number you want to order a licence for
	 * @param serviceName [required] The internal name of your VPS offer
	 * @deprecated
	 */
	public ArrayList<String> vps_serviceName_plesk_GET(String serviceName, OvhPleskLicenseDomainNumberEnum domainNumber) throws IOException {
		String qPath = "/order/vps/{serviceName}/plesk";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "domainNumber", domainNumber);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/vps/{serviceName}/plesk/{duration}
	 * @param domainNumber [required] Domain number you want to order a licence for
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 * @deprecated
	 */
	public OvhOrder vps_serviceName_plesk_duration_GET(String serviceName, String duration, OvhPleskLicenseDomainNumberEnum domainNumber) throws IOException {
		String qPath = "/order/vps/{serviceName}/plesk/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "domainNumber", domainNumber);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/vps/{serviceName}/plesk/{duration}
	 * @param domainNumber [required] Domain number you want to order a licence for
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 * @deprecated
	 */
	public OvhOrder vps_serviceName_plesk_duration_POST(String serviceName, String duration, OvhPleskLicenseDomainNumberEnum domainNumber) throws IOException {
		String qPath = "/order/vps/{serviceName}/plesk/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "domainNumber", domainNumber);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'ip' option
	 *
	 * REST: GET /order/vps/{serviceName}/ip
	 * @param country [required] Choose a geolocation for your IP Address
	 * @param number [required] Number of IPs to order
	 * @param serviceName [required] The internal name of your VPS offer
	 */
	public ArrayList<String> vps_serviceName_ip_GET(String serviceName, OvhGeolocationEnum country, Long number) throws IOException {
		String qPath = "/order/vps/{serviceName}/ip";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "country", country);
		query(sb, "number", number);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/vps/{serviceName}/ip/{duration}
	 * @param country [required] Choose a geolocation for your IP Address
	 * @param number [required] Number of IPs to order
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 */
	public OvhOrder vps_serviceName_ip_duration_GET(String serviceName, String duration, OvhGeolocationEnum country, Long number) throws IOException {
		String qPath = "/order/vps/{serviceName}/ip/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "country", country);
		query(sb, "number", number);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/vps/{serviceName}/ip/{duration}
	 * @param country [required] Choose a geolocation for your IP Address
	 * @param number [required] Number of IPs to order
	 * @param serviceName [required] The internal name of your VPS offer
	 * @param duration [required] Duration
	 */
	public OvhOrder vps_serviceName_ip_duration_POST(String serviceName, String duration, OvhGeolocationEnum country, Long number) throws IOException {
		String qPath = "/order/vps/{serviceName}/ip/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "country", country);
		addBody(o, "number", number);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/vps
	 */
	public ArrayList<String> vps_GET() throws IOException {
		String qPath = "/order/vps";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/hosting/web/new/{duration}
	 * @param dnsZone [required] Dns zone modification possibilities ( by default : RESET_ALL )
	 * @param offer [required] Offer for your new hosting account
	 * @param domain [required] Domain name which will be linked to this hosting account
	 * @param module [required] Module installation ready to use
	 * @param waiveRetractationPeriod [required] Indicates that order will be processed with waiving retractation period
	 * @param duration [required] Duration
	 */
	public OvhOrder hosting_web_new_duration_GET(String duration, OvhDnsZoneEnum dnsZone, String domain, OvhOrderableNameEnum module, OvhOfferEnum offer, Boolean waiveRetractationPeriod) throws IOException {
		String qPath = "/order/hosting/web/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		query(sb, "dnsZone", dnsZone);
		query(sb, "domain", domain);
		query(sb, "module", module);
		query(sb, "offer", offer);
		query(sb, "waiveRetractationPeriod", waiveRetractationPeriod);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/hosting/web/new/{duration}
	 * @param dnsZone [required] Dns zone modification possibilities ( by default : RESET_ALL )
	 * @param offer [required] Offer for your new hosting account
	 * @param domain [required] Domain name which will be linked to this hosting account
	 * @param module [required] Module installation ready to use
	 * @param waiveRetractationPeriod [required] Indicates that order will be processed with waiving retractation period
	 * @param duration [required] Duration
	 */
	public OvhOrder hosting_web_new_duration_POST(String duration, OvhDnsZoneEnum dnsZone, String domain, OvhOrderableNameEnum module, OvhOfferEnum offer, Boolean waiveRetractationPeriod) throws IOException {
		String qPath = "/order/hosting/web/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "dnsZone", dnsZone);
		addBody(o, "domain", domain);
		addBody(o, "module", module);
		addBody(o, "offer", offer);
		addBody(o, "waiveRetractationPeriod", waiveRetractationPeriod);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'new' option
	 *
	 * REST: GET /order/hosting/web/new
	 * @param dnsZone [required] Dns zone modification possibilities ( by default : RESET_ALL )
	 * @param offer [required] Offer for your new hosting account
	 * @param domain [required] Domain name which will be linked to this hosting account
	 * @param module [required] Module installation ready to use
	 * @param waiveRetractationPeriod [required] Indicates that order will be processed with waiving retractation period
	 */
	public ArrayList<String> hosting_web_new_GET(OvhDnsZoneEnum dnsZone, String domain, OvhOrderableNameEnum module, OvhOfferEnum offer, Boolean waiveRetractationPeriod) throws IOException {
		String qPath = "/order/hosting/web/new";
		StringBuilder sb = path(qPath);
		query(sb, "dnsZone", dnsZone);
		query(sb, "domain", domain);
		query(sb, "module", module);
		query(sb, "offer", offer);
		query(sb, "waiveRetractationPeriod", waiveRetractationPeriod);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/hosting/web/{serviceName}/extraSqlPerso/{duration}
	 * @param offer [required] Offers you can add to your hosting
	 * @param serviceName [required] The internal name of your hosting
	 * @param duration [required] Duration
	 */
	public OvhOrder hosting_web_serviceName_extraSqlPerso_duration_GET(String serviceName, String duration, OvhSqlPersoOfferEnum offer) throws IOException {
		String qPath = "/order/hosting/web/{serviceName}/extraSqlPerso/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "offer", offer);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/hosting/web/{serviceName}/extraSqlPerso/{duration}
	 * @param offer [required] Offers you can add to your hosting
	 * @param serviceName [required] The internal name of your hosting
	 * @param duration [required] Duration
	 */
	public OvhOrder hosting_web_serviceName_extraSqlPerso_duration_POST(String serviceName, String duration, OvhSqlPersoOfferEnum offer) throws IOException {
		String qPath = "/order/hosting/web/{serviceName}/extraSqlPerso/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "offer", offer);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'extraSqlPerso' option
	 *
	 * REST: GET /order/hosting/web/{serviceName}/extraSqlPerso
	 * @param offer [required] Offers you can add to your hosting
	 * @param serviceName [required] The internal name of your hosting
	 */
	public ArrayList<String> hosting_web_serviceName_extraSqlPerso_GET(String serviceName, OvhSqlPersoOfferEnum offer) throws IOException {
		String qPath = "/order/hosting/web/{serviceName}/extraSqlPerso";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "offer", offer);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/hosting/web/{serviceName}
	 * @param serviceName [required] The internal name of your hosting
	 */
	public ArrayList<String> hosting_web_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/hosting/web/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'ssl' option
	 *
	 * REST: GET /order/hosting/web/{serviceName}/ssl
	 * @param serviceName [required] The internal name of your hosting
	 */
	public ArrayList<String> hosting_web_serviceName_ssl_GET(String serviceName) throws IOException {
		String qPath = "/order/hosting/web/{serviceName}/ssl";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/hosting/web/{serviceName}/ssl/{duration}
	 * @param serviceName [required] The internal name of your hosting
	 * @param duration [required] Duration
	 */
	public OvhOrder hosting_web_serviceName_ssl_duration_GET(String serviceName, String duration) throws IOException {
		String qPath = "/order/hosting/web/{serviceName}/ssl/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/hosting/web/{serviceName}/ssl/{duration}
	 * @param serviceName [required] The internal name of your hosting
	 * @param duration [required] Duration
	 */
	public OvhOrder hosting_web_serviceName_ssl_duration_POST(String serviceName, String duration) throws IOException {
		String qPath = "/order/hosting/web/{serviceName}/ssl/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "POST", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/hosting/web/{serviceName}/upgrade/{duration}
	 * @param waiveRetractationPeriod [required] Indicates that order will be processed with waiving retractation period
	 * @param offer [required] New offers for your hosting account
	 * @param serviceName [required] The internal name of your hosting
	 * @param duration [required] Duration
	 */
	public OvhOrder hosting_web_serviceName_upgrade_duration_GET(String serviceName, String duration, OvhOfferEnum offer, Boolean waiveRetractationPeriod) throws IOException {
		String qPath = "/order/hosting/web/{serviceName}/upgrade/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "offer", offer);
		query(sb, "waiveRetractationPeriod", waiveRetractationPeriod);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/hosting/web/{serviceName}/upgrade/{duration}
	 * @param waiveRetractationPeriod [required] Indicates that order will be processed with waiving retractation period
	 * @param offer [required] New offers for your hosting account
	 * @param serviceName [required] The internal name of your hosting
	 * @param duration [required] Duration
	 */
	public OvhOrder hosting_web_serviceName_upgrade_duration_POST(String serviceName, String duration, OvhOfferEnum offer, Boolean waiveRetractationPeriod) throws IOException {
		String qPath = "/order/hosting/web/{serviceName}/upgrade/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "offer", offer);
		addBody(o, "waiveRetractationPeriod", waiveRetractationPeriod);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'upgrade' option
	 *
	 * REST: GET /order/hosting/web/{serviceName}/upgrade
	 * @param waiveRetractationPeriod [required] Indicates that order will be processed with waiving retractation period
	 * @param offer [required] New offers for your hosting account
	 * @param serviceName [required] The internal name of your hosting
	 */
	public ArrayList<String> hosting_web_serviceName_upgrade_GET(String serviceName, OvhOfferEnum offer, Boolean waiveRetractationPeriod) throws IOException {
		String qPath = "/order/hosting/web/{serviceName}/upgrade";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "offer", offer);
		query(sb, "waiveRetractationPeriod", waiveRetractationPeriod);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/hosting/web/{serviceName}/cdn/{duration}
	 * @param offer [required] Cdn offers you can add to your hosting
	 * @param serviceName [required] The internal name of your hosting
	 * @param duration [required] Duration
	 */
	public OvhOrder hosting_web_serviceName_cdn_duration_GET(String serviceName, String duration, OvhCdnOfferEnum offer) throws IOException {
		String qPath = "/order/hosting/web/{serviceName}/cdn/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "offer", offer);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/hosting/web/{serviceName}/cdn/{duration}
	 * @param offer [required] Cdn offers you can add to your hosting
	 * @param serviceName [required] The internal name of your hosting
	 * @param duration [required] Duration
	 */
	public OvhOrder hosting_web_serviceName_cdn_duration_POST(String serviceName, String duration, OvhCdnOfferEnum offer) throws IOException {
		String qPath = "/order/hosting/web/{serviceName}/cdn/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "offer", offer);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'cdn' option
	 *
	 * REST: GET /order/hosting/web/{serviceName}/cdn
	 * @param offer [required] Cdn offers you can add to your hosting
	 * @param serviceName [required] The internal name of your hosting
	 */
	public ArrayList<String> hosting_web_serviceName_cdn_GET(String serviceName, OvhCdnOfferEnum offer) throws IOException {
		String qPath = "/order/hosting/web/{serviceName}/cdn";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "offer", offer);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/hosting/web/{serviceName}/bandwidth/{duration}
	 * @param traffic [required] Available offers to increase bandwidth quota (unit: GB)
	 * @param serviceName [required] The internal name of your hosting
	 * @param duration [required] Duration
	 */
	public OvhOrder hosting_web_serviceName_bandwidth_duration_GET(String serviceName, String duration, OvhBandwidthOfferEnum traffic) throws IOException {
		String qPath = "/order/hosting/web/{serviceName}/bandwidth/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "traffic", traffic);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/hosting/web/{serviceName}/bandwidth/{duration}
	 * @param traffic [required] Available offers to increase bandwidth quota (unit: GB)
	 * @param serviceName [required] The internal name of your hosting
	 * @param duration [required] Duration
	 */
	public OvhOrder hosting_web_serviceName_bandwidth_duration_POST(String serviceName, String duration, OvhBandwidthOfferEnum traffic) throws IOException {
		String qPath = "/order/hosting/web/{serviceName}/bandwidth/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "traffic", traffic);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'bandwidth' option
	 *
	 * REST: GET /order/hosting/web/{serviceName}/bandwidth
	 * @param traffic [required] Available offers to increase bandwidth quota (unit: GB)
	 * @param serviceName [required] The internal name of your hosting
	 */
	public ArrayList<String> hosting_web_serviceName_bandwidth_GET(String serviceName, OvhBandwidthOfferEnum traffic) throws IOException {
		String qPath = "/order/hosting/web/{serviceName}/bandwidth";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "traffic", traffic);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/hosting/web/{serviceName}/changeMainDomain/{duration}
	 * @param mxplan [required] MX plan linked to the odl main domain
	 * @param domain [required] New domain for change the main domain
	 * @param serviceName [required] The internal name of your hosting
	 * @param duration [required] Duration
	 */
	public OvhOrder hosting_web_serviceName_changeMainDomain_duration_GET(String serviceName, String duration, String domain, OvhMxPlanEnum mxplan) throws IOException {
		String qPath = "/order/hosting/web/{serviceName}/changeMainDomain/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "domain", domain);
		query(sb, "mxplan", mxplan);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/hosting/web/{serviceName}/changeMainDomain/{duration}
	 * @param mxplan [required] MX plan linked to the odl main domain
	 * @param domain [required] New domain for change the main domain
	 * @param serviceName [required] The internal name of your hosting
	 * @param duration [required] Duration
	 */
	public OvhOrder hosting_web_serviceName_changeMainDomain_duration_POST(String serviceName, String duration, String domain, OvhMxPlanEnum mxplan) throws IOException {
		String qPath = "/order/hosting/web/{serviceName}/changeMainDomain/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "domain", domain);
		addBody(o, "mxplan", mxplan);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'changeMainDomain' option
	 *
	 * REST: GET /order/hosting/web/{serviceName}/changeMainDomain
	 * @param mxplan [required] MX plan linked to the odl main domain
	 * @param domain [required] New domain for change the main domain
	 * @param serviceName [required] The internal name of your hosting
	 */
	public ArrayList<String> hosting_web_serviceName_changeMainDomain_GET(String serviceName, String domain, OvhMxPlanEnum mxplan) throws IOException {
		String qPath = "/order/hosting/web/{serviceName}/changeMainDomain";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "domain", domain);
		query(sb, "mxplan", mxplan);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/hosting/web
	 */
	public ArrayList<String> hosting_web_GET() throws IOException {
		String qPath = "/order/hosting/web";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/hosting/privateDatabase/new/{duration}
	 * @param ram [required] Private database ram size
	 * @param version [required] Private database available versions
	 * @param offer [required] Type of offer to deploy this new private database
	 * @param datacenter [required] Datacenter to deploy this new private database
	 * @param duration [required] Duration
	 */
	public OvhOrder hosting_privateDatabase_new_duration_GET(String duration, OvhDatacenterEnum datacenter, net.minidev.ovh.api.hosting.privatedatabase.OvhOfferEnum offer, OvhAvailableRamSizeEnum ram, OvhOrderableVersionEnum version) throws IOException {
		String qPath = "/order/hosting/privateDatabase/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		query(sb, "datacenter", datacenter);
		query(sb, "offer", offer);
		query(sb, "ram", ram);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/hosting/privateDatabase/new/{duration}
	 * @param ram [required] Private database ram size
	 * @param version [required] Private database available versions
	 * @param offer [required] Type of offer to deploy this new private database
	 * @param datacenter [required] Datacenter to deploy this new private database
	 * @param duration [required] Duration
	 */
	public OvhOrder hosting_privateDatabase_new_duration_POST(String duration, OvhDatacenterEnum datacenter, net.minidev.ovh.api.hosting.privatedatabase.OvhOfferEnum offer, OvhAvailableRamSizeEnum ram, OvhOrderableVersionEnum version) throws IOException {
		String qPath = "/order/hosting/privateDatabase/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "datacenter", datacenter);
		addBody(o, "offer", offer);
		addBody(o, "ram", ram);
		addBody(o, "version", version);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'new' option
	 *
	 * REST: GET /order/hosting/privateDatabase/new
	 * @param ram [required] Private database ram size
	 * @param version [required] Private database available versions
	 * @param offer [required] Type of offer to deploy this new private database
	 * @param datacenter [required] Datacenter to deploy this new private database
	 */
	public ArrayList<String> hosting_privateDatabase_new_GET(OvhDatacenterEnum datacenter, net.minidev.ovh.api.hosting.privatedatabase.OvhOfferEnum offer, OvhAvailableRamSizeEnum ram, OvhOrderableVersionEnum version) throws IOException {
		String qPath = "/order/hosting/privateDatabase/new";
		StringBuilder sb = path(qPath);
		query(sb, "datacenter", datacenter);
		query(sb, "offer", offer);
		query(sb, "ram", ram);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/hosting/privateDatabase
	 */
	public ArrayList<String> hosting_privateDatabase_GET() throws IOException {
		String qPath = "/order/hosting/privateDatabase";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/hosting/privateDatabase/{serviceName}
	 * @param serviceName [required] The internal name of your private database
	 */
	public ArrayList<String> hosting_privateDatabase_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/hosting/privateDatabase/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'ram' option
	 *
	 * REST: GET /order/hosting/privateDatabase/{serviceName}/ram
	 * @param ram [required] Private database ram size
	 * @param serviceName [required] The internal name of your private database
	 */
	public ArrayList<String> hosting_privateDatabase_serviceName_ram_GET(String serviceName, OvhAvailableRamSizeEnum ram) throws IOException {
		String qPath = "/order/hosting/privateDatabase/{serviceName}/ram";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "ram", ram);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/hosting/privateDatabase/{serviceName}/ram/{duration}
	 * @param ram [required] Private database ram size
	 * @param serviceName [required] The internal name of your private database
	 * @param duration [required] Duration
	 */
	public OvhOrder hosting_privateDatabase_serviceName_ram_duration_GET(String serviceName, String duration, OvhAvailableRamSizeEnum ram) throws IOException {
		String qPath = "/order/hosting/privateDatabase/{serviceName}/ram/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "ram", ram);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/hosting/privateDatabase/{serviceName}/ram/{duration}
	 * @param ram [required] Private database ram size
	 * @param serviceName [required] The internal name of your private database
	 * @param duration [required] Duration
	 */
	public OvhOrder hosting_privateDatabase_serviceName_ram_duration_POST(String serviceName, String duration, OvhAvailableRamSizeEnum ram) throws IOException {
		String qPath = "/order/hosting/privateDatabase/{serviceName}/ram/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "ram", ram);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/overTheBox/{serviceName}/migrate
	 * @param offer [required] Offer name to migrate to
	 * @param shippingRelayID [required] Relay ID to deliver to. Needed if shipping is mondialRelay
	 * @param hardware [required] If you want to migrate with a new hardware
	 * @param shippingContactID [required] Contact ID to deliver to
	 * @param shippingMethod [required] How do you want your shipment shipped
	 * @param serviceName [required] The internal name of your overTheBox offer
	 *
	 * API beta
	 */
	public OvhOrder overTheBox_serviceName_migrate_GET(String serviceName, Boolean hardware, String offer, String shippingContactID, OvhShippingMethodEnum shippingMethod, Long shippingRelayID) throws IOException {
		String qPath = "/order/overTheBox/{serviceName}/migrate";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "hardware", hardware);
		query(sb, "offer", offer);
		query(sb, "shippingContactID", shippingContactID);
		query(sb, "shippingMethod", shippingMethod);
		query(sb, "shippingRelayID", shippingRelayID);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/overTheBox/{serviceName}/migrate
	 * @param offer [required] Offer name to migrate to
	 * @param shippingRelayID [required] Relay ID to deliver to. Needed if shipping is mondialRelay
	 * @param hardware [required] If you want to migrate with a new hardware
	 * @param shippingContactID [required] Contact ID to deliver to
	 * @param shippingMethod [required] How do you want your shipment shipped
	 * @param serviceName [required] The internal name of your overTheBox offer
	 *
	 * API beta
	 */
	public OvhOrder overTheBox_serviceName_migrate_POST(String serviceName, Boolean hardware, String offer, String shippingContactID, OvhShippingMethodEnum shippingMethod, Long shippingRelayID) throws IOException {
		String qPath = "/order/overTheBox/{serviceName}/migrate";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "hardware", hardware);
		addBody(o, "offer", offer);
		addBody(o, "shippingContactID", shippingContactID);
		addBody(o, "shippingMethod", shippingMethod);
		addBody(o, "shippingRelayID", shippingRelayID);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/overTheBox/{serviceName}
	 * @param serviceName [required] The internal name of your overTheBox offer
	 */
	public ArrayList<String> overTheBox_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/overTheBox/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/overTheBox
	 */
	public ArrayList<String> overTheBox_GET() throws IOException {
		String qPath = "/order/overTheBox";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'new' option
	 *
	 * REST: GET /order/overTheBox/new
	 * @param deviceId [required] The id of the device
	 * @param offer [required] Offer name
	 * @param voucher [required] An optional voucher
	 */
	public ArrayList<String> overTheBox_new_GET(String deviceId, String offer, String voucher) throws IOException {
		String qPath = "/order/overTheBox/new";
		StringBuilder sb = path(qPath);
		query(sb, "deviceId", deviceId);
		query(sb, "offer", offer);
		query(sb, "voucher", voucher);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/overTheBox/new/{duration}
	 * @param deviceId [required] The id of the device
	 * @param offer [required] Offer name
	 * @param voucher [required] An optional voucher
	 * @param duration [required] Duration
	 */
	public OvhOrder overTheBox_new_duration_GET(String duration, String deviceId, String offer, String voucher) throws IOException {
		String qPath = "/order/overTheBox/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		query(sb, "deviceId", deviceId);
		query(sb, "offer", offer);
		query(sb, "voucher", voucher);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/overTheBox/new/{duration}
	 * @param deviceId [required] The id of the device
	 * @param offer [required] Offer name
	 * @param voucher [required] An optional voucher
	 * @param duration [required] Duration
	 */
	public OvhOrder overTheBox_new_duration_POST(String duration, String deviceId, String offer, String voucher) throws IOException {
		String qPath = "/order/overTheBox/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "deviceId", deviceId);
		addBody(o, "offer", offer);
		addBody(o, "voucher", voucher);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/vrack/new
	 * @param quantity [required] Number of vrack you want to order
	 * @deprecated
	 */
	public OvhOrder vrack_new_GET(Long quantity) throws IOException {
		String qPath = "/order/vrack/new";
		StringBuilder sb = path(qPath);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/vrack/new
	 * @param quantity [required] Number of vrack you want to order
	 * @deprecated
	 */
	public OvhOrder vrack_new_POST(Long quantity) throws IOException {
		String qPath = "/order/vrack/new";
		StringBuilder sb = path(qPath);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/vrack/{serviceName}
	 * @param serviceName [required] The internal name of your vrack
	 * @deprecated
	 */
	public ArrayList<String> vrack_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/vrack/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/vrack
	 * @deprecated
	 */
	public ArrayList<String> vrack_GET() throws IOException {
		String qPath = "/order/vrack";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicatedCloud/{serviceName}/vdi
	 * @param datacenterId [required] Datacenter where the VDI option will be enabled
	 * @param firstPublicIpAddress [required] An avaiable ip from one of your Private Cloud public IP blocks
	 * @param secondPublicIpAddress [required] Another avaiable ip from one of your Private Cloud public IP blocks
	 * @param serviceName [required]
	 * @deprecated
	 */
	public OvhOrder dedicatedCloud_serviceName_vdi_GET(String serviceName, Long datacenterId, String firstPublicIpAddress, String secondPublicIpAddress) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}/vdi";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "datacenterId", datacenterId);
		query(sb, "firstPublicIpAddress", firstPublicIpAddress);
		query(sb, "secondPublicIpAddress", secondPublicIpAddress);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicatedCloud/{serviceName}/vdi
	 * @param datacenterId [required] Datacenter where the VDI option will be enabled
	 * @param firstPublicIpAddress [required] An avaiable ip from one of your Private Cloud public IP blocks
	 * @param secondPublicIpAddress [required] Another avaiable ip from one of your Private Cloud public IP blocks
	 * @param serviceName [required]
	 * @deprecated
	 */
	public OvhOrder dedicatedCloud_serviceName_vdi_POST(String serviceName, Long datacenterId, String firstPublicIpAddress, String secondPublicIpAddress) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}/vdi";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "datacenterId", datacenterId);
		addBody(o, "firstPublicIpAddress", firstPublicIpAddress);
		addBody(o, "secondPublicIpAddress", secondPublicIpAddress);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'filer' option
	 *
	 * REST: GET /order/dedicatedCloud/{serviceName}/filer
	 * @param name [required] Filer profile you want to order ("name" field in a profile returned by /dedicatedCloud/{serviceName}/datacenter/{datacenterId}/orderableFilerProfiles)
	 * @param datacenterId [required] Datacenter where the filer will be mounted (if not precised, will be mounted in each Datacenter of this Private Cloud)
	 * @param quantity [required] Quantity of filer you want to order (default 1)
	 * @param serviceName [required]
	 * @deprecated
	 */
	public ArrayList<String> dedicatedCloud_serviceName_filer_GET(String serviceName, Long datacenterId, String name, Long quantity) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}/filer";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "datacenterId", datacenterId);
		query(sb, "name", name);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicatedCloud/{serviceName}/filer/{duration}
	 * @param name [required] Filer profile you want to order ("name" field in a profile returned by /dedicatedCloud/{serviceName}/datacenter/{datacenterId}/orderableFilerProfiles)
	 * @param datacenterId [required] Datacenter where the filer will be mounted (if not precised, will be mounted in each Datacenter of this Private Cloud)
	 * @param quantity [required] Quantity of filer you want to order (default 1)
	 * @param serviceName [required]
	 * @param duration [required] Duration
	 * @deprecated
	 */
	public OvhOrder dedicatedCloud_serviceName_filer_duration_GET(String serviceName, String duration, Long datacenterId, String name, Long quantity) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}/filer/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "datacenterId", datacenterId);
		query(sb, "name", name);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicatedCloud/{serviceName}/filer/{duration}
	 * @param name [required] Filer profile you want to order ("name" field in a profile returned by /dedicatedCloud/{serviceName}/datacenter/{datacenterId}/orderableFilerProfiles)
	 * @param datacenterId [required] Datacenter where the filer will be mounted (if not precised, will be mounted in each Datacenter of this Private Cloud)
	 * @param quantity [required] Quantity of filer you want to order (default 1)
	 * @param serviceName [required]
	 * @param duration [required] Duration
	 * @deprecated
	 */
	public OvhOrder dedicatedCloud_serviceName_filer_duration_POST(String serviceName, String duration, Long datacenterId, String name, Long quantity) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}/filer/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "datacenterId", datacenterId);
		addBody(o, "name", name);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicatedCloud/{serviceName}/upgradeRessource/{duration}
	 * @param upgradedRessourceId [required] The id of a particular ressource you want to upgrade in your Private Cloud (useless for "all" UpgradeRessourceTypeEnum)
	 * @param upgradedRessourceType [required] The type of ressource you want to upgrade.
	 * @param upgradeType [required] The type of upgrade you want to process on the ressource(s)
	 * @param serviceName [required]
	 * @param duration [required] Duration
	 * @deprecated
	 */
	public OvhOrder dedicatedCloud_serviceName_upgradeRessource_duration_GET(String serviceName, String duration, OvhUpgradeTypeEnum upgradeType, Long upgradedRessourceId, OvhUpgradeRessourceTypeEnum upgradedRessourceType) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}/upgradeRessource/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "upgradeType", upgradeType);
		query(sb, "upgradedRessourceId", upgradedRessourceId);
		query(sb, "upgradedRessourceType", upgradedRessourceType);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicatedCloud/{serviceName}/upgradeRessource/{duration}
	 * @param upgradedRessourceId [required] The id of a particular ressource you want to upgrade in your Private Cloud (useless for "all" UpgradeRessourceTypeEnum)
	 * @param upgradedRessourceType [required] The type of ressource you want to upgrade.
	 * @param upgradeType [required] The type of upgrade you want to process on the ressource(s)
	 * @param serviceName [required]
	 * @param duration [required] Duration
	 * @deprecated
	 */
	public OvhOrder dedicatedCloud_serviceName_upgradeRessource_duration_POST(String serviceName, String duration, OvhUpgradeTypeEnum upgradeType, Long upgradedRessourceId, OvhUpgradeRessourceTypeEnum upgradedRessourceType) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}/upgradeRessource/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "upgradeType", upgradeType);
		addBody(o, "upgradedRessourceId", upgradedRessourceId);
		addBody(o, "upgradedRessourceType", upgradedRessourceType);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'upgradeRessource' option
	 *
	 * REST: GET /order/dedicatedCloud/{serviceName}/upgradeRessource
	 * @param upgradedRessourceId [required] The id of a particular ressource you want to upgrade in your Private Cloud (useless for "all" UpgradeRessourceTypeEnum)
	 * @param upgradedRessourceType [required] The type of ressource you want to upgrade.
	 * @param upgradeType [required] The type of upgrade you want to process on the ressource(s)
	 * @param serviceName [required]
	 * @deprecated
	 */
	public ArrayList<String> dedicatedCloud_serviceName_upgradeRessource_GET(String serviceName, OvhUpgradeTypeEnum upgradeType, Long upgradedRessourceId, OvhUpgradeRessourceTypeEnum upgradedRessourceType) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}/upgradeRessource";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "upgradeType", upgradeType);
		query(sb, "upgradedRessourceId", upgradedRessourceId);
		query(sb, "upgradedRessourceType", upgradedRessourceType);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/dedicatedCloud/{serviceName}
	 * @param serviceName [required]
	 * @deprecated
	 */
	public ArrayList<String> dedicatedCloud_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicatedCloud/{serviceName}/additionalBandwidth/{duration}
	 * @param bandwidth [required] How much additional bandwidth do you want ?
	 * @param serviceName [required]
	 * @param duration [required] Duration
	 * @deprecated
	 */
	public OvhOrder dedicatedCloud_serviceName_additionalBandwidth_duration_GET(String serviceName, String duration, OvhAdditionalBandwidthEnum bandwidth) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}/additionalBandwidth/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "bandwidth", bandwidth);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicatedCloud/{serviceName}/additionalBandwidth/{duration}
	 * @param bandwidth [required] How much additional bandwidth do you want ?
	 * @param serviceName [required]
	 * @param duration [required] Duration
	 * @deprecated
	 */
	public OvhOrder dedicatedCloud_serviceName_additionalBandwidth_duration_POST(String serviceName, String duration, OvhAdditionalBandwidthEnum bandwidth) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}/additionalBandwidth/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "bandwidth", bandwidth);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'additionalBandwidth' option
	 *
	 * REST: GET /order/dedicatedCloud/{serviceName}/additionalBandwidth
	 * @param bandwidth [required] How much additional bandwidth do you want ?
	 * @param serviceName [required]
	 * @deprecated
	 */
	public ArrayList<String> dedicatedCloud_serviceName_additionalBandwidth_GET(String serviceName, OvhAdditionalBandwidthEnum bandwidth) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}/additionalBandwidth";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "bandwidth", bandwidth);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicatedCloud/{serviceName}/ip/{duration}
	 * @param networkName [required] Information visible on whois (between 2 and maximum 20 alphanumeric characters)
	 * @param description [required] Information visible on whois (minimum 3 and maximum 250 alphanumeric characters)
	 * @param estimatedClientsNumber [required] How much clients would be hosted on those ips ?
	 * @param usage [required] Basic information of how will this bloc be used (as "web","ssl","cloud" or other things)
	 * @param size [required] The network ranges orderable
	 * @param country [required] This Ip block country
	 * @param serviceName [required]
	 * @param duration [required] Duration
	 * @deprecated
	 */
	public OvhOrder dedicatedCloud_serviceName_ip_duration_GET(String serviceName, String duration, OvhIpCountriesEnum country, String description, Long estimatedClientsNumber, String networkName, OvhOrderableIpBlockRangeEnum size, String usage) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}/ip/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "country", country);
		query(sb, "description", description);
		query(sb, "estimatedClientsNumber", estimatedClientsNumber);
		query(sb, "networkName", networkName);
		query(sb, "size", size);
		query(sb, "usage", usage);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicatedCloud/{serviceName}/ip/{duration}
	 * @param networkName [required] Information visible on whois (between 2 and maximum 20 alphanumeric characters)
	 * @param description [required] Information visible on whois (minimum 3 and maximum 250 alphanumeric characters)
	 * @param estimatedClientsNumber [required] How much clients would be hosted on those ips ?
	 * @param usage [required] Basic information of how will this bloc be used (as "web","ssl","cloud" or other things)
	 * @param size [required] The network ranges orderable
	 * @param country [required] This Ip block country
	 * @param serviceName [required]
	 * @param duration [required] Duration
	 * @deprecated
	 */
	public OvhOrder dedicatedCloud_serviceName_ip_duration_POST(String serviceName, String duration, OvhIpCountriesEnum country, String description, Long estimatedClientsNumber, String networkName, OvhOrderableIpBlockRangeEnum size, String usage) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}/ip/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "country", country);
		addBody(o, "description", description);
		addBody(o, "estimatedClientsNumber", estimatedClientsNumber);
		addBody(o, "networkName", networkName);
		addBody(o, "size", size);
		addBody(o, "usage", usage);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'ip' option
	 *
	 * REST: GET /order/dedicatedCloud/{serviceName}/ip
	 * @param networkName [required] Information visible on whois (between 2 and maximum 20 alphanumeric characters)
	 * @param description [required] Information visible on whois (minimum 3 and maximum 250 alphanumeric characters)
	 * @param estimatedClientsNumber [required] How much clients would be hosted on those ips ?
	 * @param usage [required] Basic information of how will this bloc be used (as "web","ssl","cloud" or other things)
	 * @param size [required] The network ranges orderable
	 * @param country [required] This Ip block country
	 * @param serviceName [required]
	 * @deprecated
	 */
	public ArrayList<String> dedicatedCloud_serviceName_ip_GET(String serviceName, OvhIpCountriesEnum country, String description, Long estimatedClientsNumber, String networkName, OvhOrderableIpBlockRangeEnum size, String usage) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}/ip";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "country", country);
		query(sb, "description", description);
		query(sb, "estimatedClientsNumber", estimatedClientsNumber);
		query(sb, "networkName", networkName);
		query(sb, "size", size);
		query(sb, "usage", usage);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicatedCloud/{serviceName}/host/{duration}
	 * @param quantity [required] Quantity of hosts you want to order (default 1)
	 * @param name [required] Host profile you want to order ("name" field of a Profile returned by /dedicatedCloud/{serviceName}/datacenter/{datacenterId}/orderableHostProfiles)
	 * @param datacenterId [required] Datacenter where the Host will be added
	 * @param serviceName [required]
	 * @param duration [required] Duration
	 * @deprecated
	 */
	public OvhOrder dedicatedCloud_serviceName_host_duration_GET(String serviceName, String duration, Long datacenterId, String name, Long quantity) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}/host/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "datacenterId", datacenterId);
		query(sb, "name", name);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicatedCloud/{serviceName}/host/{duration}
	 * @param quantity [required] Quantity of hosts you want to order (default 1)
	 * @param name [required] Host profile you want to order ("name" field of a Profile returned by /dedicatedCloud/{serviceName}/datacenter/{datacenterId}/orderableHostProfiles)
	 * @param datacenterId [required] Datacenter where the Host will be added
	 * @param serviceName [required]
	 * @param duration [required] Duration
	 * @deprecated
	 */
	public OvhOrder dedicatedCloud_serviceName_host_duration_POST(String serviceName, String duration, Long datacenterId, String name, Long quantity) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}/host/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "datacenterId", datacenterId);
		addBody(o, "name", name);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'host' option
	 *
	 * REST: GET /order/dedicatedCloud/{serviceName}/host
	 * @param quantity [required] Quantity of hosts you want to order (default 1)
	 * @param name [required] Host profile you want to order ("name" field of a Profile returned by /dedicatedCloud/{serviceName}/datacenter/{datacenterId}/orderableHostProfiles)
	 * @param datacenterId [required] Datacenter where the Host will be added
	 * @param serviceName [required]
	 * @deprecated
	 */
	public ArrayList<String> dedicatedCloud_serviceName_host_GET(String serviceName, Long datacenterId, String name, Long quantity) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}/host";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "datacenterId", datacenterId);
		query(sb, "name", name);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicatedCloud/{serviceName}/spla
	 * @param serviceName [required]
	 * @deprecated
	 */
	public OvhOrder dedicatedCloud_serviceName_spla_GET(String serviceName) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}/spla";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicatedCloud/{serviceName}/spla
	 * @param serviceName [required]
	 * @deprecated
	 */
	public OvhOrder dedicatedCloud_serviceName_spla_POST(String serviceName) throws IOException {
		String qPath = "/order/dedicatedCloud/{serviceName}/spla";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "POST", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/dedicatedCloud
	 * @deprecated
	 */
	public ArrayList<String> dedicatedCloud_GET() throws IOException {
		String qPath = "/order/dedicatedCloud";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/email/pro/{service}/account/{duration}
	 * @param number [required] Number of Accounts to order
	 * @param service [required] The internal name of your pro organization
	 * @param duration [required] Duration
	 */
	public OvhOrder email_pro_service_account_duration_GET(String service, String duration, Long number) throws IOException {
		String qPath = "/order/email/pro/{service}/account/{duration}";
		StringBuilder sb = path(qPath, service, duration);
		query(sb, "number", number);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/email/pro/{service}/account/{duration}
	 * @param number [required] Number of Accounts to order
	 * @param service [required] The internal name of your pro organization
	 * @param duration [required] Duration
	 */
	public OvhOrder email_pro_service_account_duration_POST(String service, String duration, Long number) throws IOException {
		String qPath = "/order/email/pro/{service}/account/{duration}";
		StringBuilder sb = path(qPath, service, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "number", number);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'account' option
	 *
	 * REST: GET /order/email/pro/{service}/account
	 * @param number [required] Number of Accounts to order
	 * @param service [required] The internal name of your pro organization
	 */
	public ArrayList<String> email_pro_service_account_GET(String service, Long number) throws IOException {
		String qPath = "/order/email/pro/{service}/account";
		StringBuilder sb = path(qPath, service);
		query(sb, "number", number);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/email/pro/{service}
	 * @param service [required] The internal name of your pro organization
	 */
	public ArrayList<String> email_pro_service_GET(String service) throws IOException {
		String qPath = "/order/email/pro/{service}";
		StringBuilder sb = path(qPath, service);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/email/pro
	 */
	public ArrayList<String> email_pro_GET() throws IOException {
		String qPath = "/order/email/pro";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/email/domain
	 */
	public ArrayList<String> email_domain_GET() throws IOException {
		String qPath = "/order/email/domain";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'new' option
	 *
	 * REST: GET /order/email/domain/new
	 * @param offer [required] Offer for your new mx account
	 * @param domain [required] Domain name which will be linked to this mx account
	 * @deprecated
	 */
	public ArrayList<String> email_domain_new_GET(String domain, net.minidev.ovh.api.email.domain.OvhOfferEnum offer) throws IOException {
		String qPath = "/order/email/domain/new";
		StringBuilder sb = path(qPath);
		query(sb, "domain", domain);
		query(sb, "offer", offer);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/email/domain/new/{duration}
	 * @param offer [required] Offer for your new mx account
	 * @param domain [required] Domain name which will be linked to this mx account
	 * @param duration [required] Duration
	 * @deprecated
	 */
	public OvhOrder email_domain_new_duration_GET(String duration, String domain, net.minidev.ovh.api.email.domain.OvhOfferEnum offer) throws IOException {
		String qPath = "/order/email/domain/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		query(sb, "domain", domain);
		query(sb, "offer", offer);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/email/domain/new/{duration}
	 * @param offer [required] Offer for your new mx account
	 * @param domain [required] Domain name which will be linked to this mx account
	 * @param duration [required] Duration
	 * @deprecated
	 */
	public OvhOrder email_domain_new_duration_POST(String duration, String domain, net.minidev.ovh.api.email.domain.OvhOfferEnum offer) throws IOException {
		String qPath = "/order/email/domain/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "domain", domain);
		addBody(o, "offer", offer);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/email/exchange/{organizationName}/service
	 * @param organizationName [required] The internal name of your exchange organization
	 */
	public ArrayList<String> email_exchange_organizationName_service_GET(String organizationName) throws IOException {
		String qPath = "/order/email/exchange/{organizationName}/service";
		StringBuilder sb = path(qPath, organizationName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/email/exchange/{organizationName}/service/{exchangeService}/upgrade
	 * @param organizationName [required] The internal name of your exchange organization
	 * @param exchangeService [required] The internal name of your exchange service
	 */
	public OvhOrder email_exchange_organizationName_service_exchangeService_upgrade_GET(String organizationName, String exchangeService) throws IOException {
		String qPath = "/order/email/exchange/{organizationName}/service/{exchangeService}/upgrade";
		StringBuilder sb = path(qPath, organizationName, exchangeService);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/email/exchange/{organizationName}/service/{exchangeService}/upgrade
	 * @param organizationName [required] The internal name of your exchange organization
	 * @param exchangeService [required] The internal name of your exchange service
	 */
	public OvhOrder email_exchange_organizationName_service_exchangeService_upgrade_POST(String organizationName, String exchangeService) throws IOException {
		String qPath = "/order/email/exchange/{organizationName}/service/{exchangeService}/upgrade";
		StringBuilder sb = path(qPath, organizationName, exchangeService);
		String resp = exec(qPath, "POST", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'outlook' option
	 *
	 * REST: GET /order/email/exchange/{organizationName}/service/{exchangeService}/outlook
	 * @param primaryEmailAddress [required] Primary email address for account which You want to buy an outlook
	 * @param licence [required] Outlook version
	 * @param organizationName [required] The internal name of your exchange organization
	 * @param exchangeService [required] The internal name of your exchange service
	 */
	public ArrayList<String> email_exchange_organizationName_service_exchangeService_outlook_GET(String organizationName, String exchangeService, OvhOutlookVersionEnum licence, String primaryEmailAddress) throws IOException {
		String qPath = "/order/email/exchange/{organizationName}/service/{exchangeService}/outlook";
		StringBuilder sb = path(qPath, organizationName, exchangeService);
		query(sb, "licence", licence);
		query(sb, "primaryEmailAddress", primaryEmailAddress);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/email/exchange/{organizationName}/service/{exchangeService}/outlook/{duration}
	 * @param primaryEmailAddress [required] Primary email address for account which You want to buy an outlook
	 * @param licence [required] Outlook version
	 * @param organizationName [required] The internal name of your exchange organization
	 * @param exchangeService [required] The internal name of your exchange service
	 * @param duration [required] Duration
	 */
	public OvhOrder email_exchange_organizationName_service_exchangeService_outlook_duration_GET(String organizationName, String exchangeService, String duration, OvhOutlookVersionEnum licence, String primaryEmailAddress) throws IOException {
		String qPath = "/order/email/exchange/{organizationName}/service/{exchangeService}/outlook/{duration}";
		StringBuilder sb = path(qPath, organizationName, exchangeService, duration);
		query(sb, "licence", licence);
		query(sb, "primaryEmailAddress", primaryEmailAddress);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/email/exchange/{organizationName}/service/{exchangeService}/outlook/{duration}
	 * @param primaryEmailAddress [required] Primary email address for account which You want to buy an outlook
	 * @param licence [required] Outlook version
	 * @param organizationName [required] The internal name of your exchange organization
	 * @param exchangeService [required] The internal name of your exchange service
	 * @param duration [required] Duration
	 */
	public OvhOrder email_exchange_organizationName_service_exchangeService_outlook_duration_POST(String organizationName, String exchangeService, String duration, OvhOutlookVersionEnum licence, String primaryEmailAddress) throws IOException {
		String qPath = "/order/email/exchange/{organizationName}/service/{exchangeService}/outlook/{duration}";
		StringBuilder sb = path(qPath, organizationName, exchangeService, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "licence", licence);
		addBody(o, "primaryEmailAddress", primaryEmailAddress);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/email/exchange/{organizationName}/service/{exchangeService}/accountUpgrade/{duration}
	 * @param primaryEmailAddress [required] The account you wish to upgrade
	 * @param newQuota [required] New storage quota for that account
	 * @param organizationName [required] The internal name of your exchange organization
	 * @param exchangeService [required] The internal name of your exchange service
	 * @param duration [required] Duration
	 */
	public OvhOrder email_exchange_organizationName_service_exchangeService_accountUpgrade_duration_GET(String organizationName, String exchangeService, String duration, OvhAccountQuotaEnum newQuota, String primaryEmailAddress) throws IOException {
		String qPath = "/order/email/exchange/{organizationName}/service/{exchangeService}/accountUpgrade/{duration}";
		StringBuilder sb = path(qPath, organizationName, exchangeService, duration);
		query(sb, "newQuota", newQuota);
		query(sb, "primaryEmailAddress", primaryEmailAddress);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/email/exchange/{organizationName}/service/{exchangeService}/accountUpgrade/{duration}
	 * @param primaryEmailAddress [required] The account you wish to upgrade
	 * @param newQuota [required] New storage quota for that account
	 * @param organizationName [required] The internal name of your exchange organization
	 * @param exchangeService [required] The internal name of your exchange service
	 * @param duration [required] Duration
	 */
	public OvhOrder email_exchange_organizationName_service_exchangeService_accountUpgrade_duration_POST(String organizationName, String exchangeService, String duration, OvhAccountQuotaEnum newQuota, String primaryEmailAddress) throws IOException {
		String qPath = "/order/email/exchange/{organizationName}/service/{exchangeService}/accountUpgrade/{duration}";
		StringBuilder sb = path(qPath, organizationName, exchangeService, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "newQuota", newQuota);
		addBody(o, "primaryEmailAddress", primaryEmailAddress);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'accountUpgrade' option
	 *
	 * REST: GET /order/email/exchange/{organizationName}/service/{exchangeService}/accountUpgrade
	 * @param primaryEmailAddress [required] The account you wish to upgrade
	 * @param newQuota [required] New storage quota for that account
	 * @param organizationName [required] The internal name of your exchange organization
	 * @param exchangeService [required] The internal name of your exchange service
	 */
	public ArrayList<String> email_exchange_organizationName_service_exchangeService_accountUpgrade_GET(String organizationName, String exchangeService, OvhAccountQuotaEnum newQuota, String primaryEmailAddress) throws IOException {
		String qPath = "/order/email/exchange/{organizationName}/service/{exchangeService}/accountUpgrade";
		StringBuilder sb = path(qPath, organizationName, exchangeService);
		query(sb, "newQuota", newQuota);
		query(sb, "primaryEmailAddress", primaryEmailAddress);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'account' option
	 *
	 * REST: GET /order/email/exchange/{organizationName}/service/{exchangeService}/account
	 * @param number [required] Number of Accounts to order
	 * @param storageQuota [required] The storage quota for the account(s) in GB (default = 50)
	 * @param licence [required] Licence type for the account
	 * @param organizationName [required] The internal name of your exchange organization
	 * @param exchangeService [required] The internal name of your exchange service
	 */
	public ArrayList<String> email_exchange_organizationName_service_exchangeService_account_GET(String organizationName, String exchangeService, OvhOvhLicenceEnum licence, Long number, OvhAccountQuotaEnum storageQuota) throws IOException {
		String qPath = "/order/email/exchange/{organizationName}/service/{exchangeService}/account";
		StringBuilder sb = path(qPath, organizationName, exchangeService);
		query(sb, "licence", licence);
		query(sb, "number", number);
		query(sb, "storageQuota", storageQuota);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/email/exchange/{organizationName}/service/{exchangeService}/account/{duration}
	 * @param number [required] Number of Accounts to order
	 * @param storageQuota [required] The storage quota for the account(s) in GB (default = 50)
	 * @param licence [required] Licence type for the account
	 * @param organizationName [required] The internal name of your exchange organization
	 * @param exchangeService [required] The internal name of your exchange service
	 * @param duration [required] Duration
	 */
	public OvhOrder email_exchange_organizationName_service_exchangeService_account_duration_GET(String organizationName, String exchangeService, String duration, OvhOvhLicenceEnum licence, Long number, OvhAccountQuotaEnum storageQuota) throws IOException {
		String qPath = "/order/email/exchange/{organizationName}/service/{exchangeService}/account/{duration}";
		StringBuilder sb = path(qPath, organizationName, exchangeService, duration);
		query(sb, "licence", licence);
		query(sb, "number", number);
		query(sb, "storageQuota", storageQuota);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/email/exchange/{organizationName}/service/{exchangeService}/account/{duration}
	 * @param number [required] Number of Accounts to order
	 * @param storageQuota [required] The storage quota for the account(s) in GB (default = 50)
	 * @param licence [required] Licence type for the account
	 * @param organizationName [required] The internal name of your exchange organization
	 * @param exchangeService [required] The internal name of your exchange service
	 * @param duration [required] Duration
	 */
	public OvhOrder email_exchange_organizationName_service_exchangeService_account_duration_POST(String organizationName, String exchangeService, String duration, OvhOvhLicenceEnum licence, Long number, OvhAccountQuotaEnum storageQuota) throws IOException {
		String qPath = "/order/email/exchange/{organizationName}/service/{exchangeService}/account/{duration}";
		StringBuilder sb = path(qPath, organizationName, exchangeService, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "licence", licence);
		addBody(o, "number", number);
		addBody(o, "storageQuota", storageQuota);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/email/exchange/{organizationName}/service/{exchangeService}
	 * @param organizationName [required] The internal name of your exchange organization
	 * @param exchangeService [required] The internal name of your exchange service
	 */
	public ArrayList<String> email_exchange_organizationName_service_exchangeService_GET(String organizationName, String exchangeService) throws IOException {
		String qPath = "/order/email/exchange/{organizationName}/service/{exchangeService}";
		StringBuilder sb = path(qPath, organizationName, exchangeService);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/email/exchange/{organizationName}/service/{exchangeService}/diskSpace
	 * @param organizationName [required] The internal name of your exchange organization
	 * @param exchangeService [required] The internal name of your exchange service
	 */
	public OvhOrder email_exchange_organizationName_service_exchangeService_diskSpace_GET(String organizationName, String exchangeService) throws IOException {
		String qPath = "/order/email/exchange/{organizationName}/service/{exchangeService}/diskSpace";
		StringBuilder sb = path(qPath, organizationName, exchangeService);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/email/exchange/{organizationName}/service/{exchangeService}/diskSpace
	 * @param organizationName [required] The internal name of your exchange organization
	 * @param exchangeService [required] The internal name of your exchange service
	 */
	public OvhOrder email_exchange_organizationName_service_exchangeService_diskSpace_POST(String organizationName, String exchangeService) throws IOException {
		String qPath = "/order/email/exchange/{organizationName}/service/{exchangeService}/diskSpace";
		StringBuilder sb = path(qPath, organizationName, exchangeService);
		String resp = exec(qPath, "POST", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/email/exchange
	 */
	public ArrayList<String> email_exchange_GET() throws IOException {
		String qPath = "/order/email/exchange";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'new' option
	 *
	 * REST: GET /order/cdn/dedicated/new
	 */
	public ArrayList<String> cdn_dedicated_new_GET() throws IOException {
		String qPath = "/order/cdn/dedicated/new";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/cdn/dedicated/new/{duration}
	 * @param duration [required] Duration
	 */
	public OvhOrder cdn_dedicated_new_duration_GET(String duration) throws IOException {
		String qPath = "/order/cdn/dedicated/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/cdn/dedicated/new/{duration}
	 * @param duration [required] Duration
	 */
	public OvhOrder cdn_dedicated_new_duration_POST(String duration) throws IOException {
		String qPath = "/order/cdn/dedicated/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		String resp = exec(qPath, "POST", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/cdn/dedicated
	 */
	public ArrayList<String> cdn_dedicated_GET() throws IOException {
		String qPath = "/order/cdn/dedicated";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'backend' option
	 *
	 * REST: GET /order/cdn/dedicated/{serviceName}/backend
	 * @param backend [required] Backend number that will be ordered
	 * @param serviceName [required] The internal name of your CDN offer
	 */
	public ArrayList<String> cdn_dedicated_serviceName_backend_GET(String serviceName, Long backend) throws IOException {
		String qPath = "/order/cdn/dedicated/{serviceName}/backend";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "backend", backend);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/cdn/dedicated/{serviceName}/backend/{duration}
	 * @param backend [required] Backend number that will be ordered
	 * @param serviceName [required] The internal name of your CDN offer
	 * @param duration [required] Duration
	 */
	public OvhOrder cdn_dedicated_serviceName_backend_duration_GET(String serviceName, String duration, Long backend) throws IOException {
		String qPath = "/order/cdn/dedicated/{serviceName}/backend/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "backend", backend);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/cdn/dedicated/{serviceName}/backend/{duration}
	 * @param backend [required] Backend number that will be ordered
	 * @param serviceName [required] The internal name of your CDN offer
	 * @param duration [required] Duration
	 */
	public OvhOrder cdn_dedicated_serviceName_backend_duration_POST(String serviceName, String duration, Long backend) throws IOException {
		String qPath = "/order/cdn/dedicated/{serviceName}/backend/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "backend", backend);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'cacheRule' option
	 *
	 * REST: GET /order/cdn/dedicated/{serviceName}/cacheRule
	 * @param cacheRule [required] cache rule upgrade option to 100 or 1000
	 * @param serviceName [required] The internal name of your CDN offer
	 */
	public ArrayList<String> cdn_dedicated_serviceName_cacheRule_GET(String serviceName, OvhOrderCacheRuleEnum cacheRule) throws IOException {
		String qPath = "/order/cdn/dedicated/{serviceName}/cacheRule";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "cacheRule", cacheRule);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/cdn/dedicated/{serviceName}/cacheRule/{duration}
	 * @param cacheRule [required] cache rule upgrade option to 100 or 1000
	 * @param serviceName [required] The internal name of your CDN offer
	 * @param duration [required] Duration
	 */
	public OvhOrder cdn_dedicated_serviceName_cacheRule_duration_GET(String serviceName, String duration, OvhOrderCacheRuleEnum cacheRule) throws IOException {
		String qPath = "/order/cdn/dedicated/{serviceName}/cacheRule/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "cacheRule", cacheRule);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/cdn/dedicated/{serviceName}/cacheRule/{duration}
	 * @param cacheRule [required] cache rule upgrade option to 100 or 1000
	 * @param serviceName [required] The internal name of your CDN offer
	 * @param duration [required] Duration
	 */
	public OvhOrder cdn_dedicated_serviceName_cacheRule_duration_POST(String serviceName, String duration, OvhOrderCacheRuleEnum cacheRule) throws IOException {
		String qPath = "/order/cdn/dedicated/{serviceName}/cacheRule/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "cacheRule", cacheRule);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/cdn/dedicated/{serviceName}
	 * @param serviceName [required] The internal name of your CDN offer
	 */
	public ArrayList<String> cdn_dedicated_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/cdn/dedicated/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/cdn/dedicated/{serviceName}/quota/{duration}
	 * @param quota [required] quota number in TB that will be added to the CDN service
	 * @param serviceName [required] The internal name of your CDN offer
	 * @param duration [required] Duration
	 */
	public OvhOrder cdn_dedicated_serviceName_quota_duration_GET(String serviceName, String duration, OvhOrderQuotaEnum quota) throws IOException {
		String qPath = "/order/cdn/dedicated/{serviceName}/quota/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "quota", quota);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/cdn/dedicated/{serviceName}/quota/{duration}
	 * @param quota [required] quota number in TB that will be added to the CDN service
	 * @param serviceName [required] The internal name of your CDN offer
	 * @param duration [required] Duration
	 */
	public OvhOrder cdn_dedicated_serviceName_quota_duration_POST(String serviceName, String duration, OvhOrderQuotaEnum quota) throws IOException {
		String qPath = "/order/cdn/dedicated/{serviceName}/quota/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "quota", quota);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'quota' option
	 *
	 * REST: GET /order/cdn/dedicated/{serviceName}/quota
	 * @param quota [required] quota number in TB that will be added to the CDN service
	 * @param serviceName [required] The internal name of your CDN offer
	 */
	public ArrayList<String> cdn_dedicated_serviceName_quota_GET(String serviceName, OvhOrderQuotaEnum quota) throws IOException {
		String qPath = "/order/cdn/dedicated/{serviceName}/quota";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "quota", quota);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'storage' option
	 *
	 * REST: GET /order/cdn/webstorage/{serviceName}/storage
	 * @param storage [required] Storage option that will be ordered
	 * @param serviceName [required] The internal name of your CDN Static offer
	 */
	public ArrayList<String> cdn_webstorage_serviceName_storage_GET(String serviceName, OvhOrderStorageEnum storage) throws IOException {
		String qPath = "/order/cdn/webstorage/{serviceName}/storage";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "storage", storage);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/cdn/webstorage/{serviceName}/storage/{duration}
	 * @param storage [required] Storage option that will be ordered
	 * @param serviceName [required] The internal name of your CDN Static offer
	 * @param duration [required] Duration
	 */
	public OvhOrder cdn_webstorage_serviceName_storage_duration_GET(String serviceName, String duration, OvhOrderStorageEnum storage) throws IOException {
		String qPath = "/order/cdn/webstorage/{serviceName}/storage/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "storage", storage);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/cdn/webstorage/{serviceName}/storage/{duration}
	 * @param storage [required] Storage option that will be ordered
	 * @param serviceName [required] The internal name of your CDN Static offer
	 * @param duration [required] Duration
	 */
	public OvhOrder cdn_webstorage_serviceName_storage_duration_POST(String serviceName, String duration, OvhOrderStorageEnum storage) throws IOException {
		String qPath = "/order/cdn/webstorage/{serviceName}/storage/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "storage", storage);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/cdn/webstorage/{serviceName}
	 * @param serviceName [required] The internal name of your CDN Static offer
	 */
	public ArrayList<String> cdn_webstorage_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/cdn/webstorage/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/cdn/webstorage/{serviceName}/traffic
	 * @param bandwidth [required] Traffic in TB that will be added to the cdn.webstorage service
	 * @param serviceName [required] The internal name of your CDN Static offer
	 */
	public OvhOrder cdn_webstorage_serviceName_traffic_GET(String serviceName, OvhOrderTrafficEnum bandwidth) throws IOException {
		String qPath = "/order/cdn/webstorage/{serviceName}/traffic";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "bandwidth", bandwidth);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/cdn/webstorage/{serviceName}/traffic
	 * @param bandwidth [required] Traffic in TB that will be added to the cdn.webstorage service
	 * @param serviceName [required] The internal name of your CDN Static offer
	 */
	public OvhOrder cdn_webstorage_serviceName_traffic_POST(String serviceName, OvhOrderTrafficEnum bandwidth) throws IOException {
		String qPath = "/order/cdn/webstorage/{serviceName}/traffic";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "bandwidth", bandwidth);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/cdn/webstorage
	 */
	public ArrayList<String> cdn_webstorage_GET() throws IOException {
		String qPath = "/order/cdn/webstorage";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/cartServiceOption/sharepoint
	 */
	public ArrayList<String> cartServiceOption_sharepoint_GET() throws IOException {
		String qPath = "/order/cartServiceOption/sharepoint";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get informations about additional Sharepoint offer for your service
	 *
	 * REST: GET /order/cartServiceOption/sharepoint/{serviceName}
	 * @param serviceName [required] The internal ID of Sharepoint service
	 */
	public ArrayList<OvhGenericOptionDefinition> cartServiceOption_sharepoint_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/cartServiceOption/sharepoint/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}
	private static TypeReference<ArrayList<OvhGenericOptionDefinition>> t2 = new TypeReference<ArrayList<OvhGenericOptionDefinition>>() {};

	/**
	 * Post an additional Sharepoint option in your cart
	 *
	 * REST: POST /order/cartServiceOption/sharepoint/{serviceName}
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the additional Sharepoint offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 * @param serviceName [required] The internal ID of Sharepoint service
	 */
	public OvhItem cartServiceOption_sharepoint_serviceName_POST(String serviceName, String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cartServiceOption/sharepoint/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "cartId", cartId);
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/cartServiceOption/webHosting
	 */
	public ArrayList<String> cartServiceOption_webHosting_GET() throws IOException {
		String qPath = "/order/cartServiceOption/webHosting";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get informations about additional Web Hosting offer for your service
	 *
	 * REST: GET /order/cartServiceOption/webHosting/{serviceName}
	 * @param serviceName [required] The internal ID of Web Hosting service
	 */
	public ArrayList<OvhGenericOptionDefinition> cartServiceOption_webHosting_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/cartServiceOption/webHosting/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post an additional Web Hosting option in your cart
	 *
	 * REST: POST /order/cartServiceOption/webHosting/{serviceName}
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the additional Web Hosting offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 * @param serviceName [required] The internal ID of Web Hosting service
	 */
	public OvhItem cartServiceOption_webHosting_serviceName_POST(String serviceName, String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cartServiceOption/webHosting/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "cartId", cartId);
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about additional EmailPro offer for your service
	 *
	 * REST: GET /order/cartServiceOption/emailpro/{serviceName}
	 * @param serviceName [required] The internal ID of EmailPro service
	 */
	public ArrayList<OvhGenericOptionDefinition> cartServiceOption_emailpro_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/cartServiceOption/emailpro/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post an additional EmailPro option in your cart
	 *
	 * REST: POST /order/cartServiceOption/emailpro/{serviceName}
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the additional EmailPro offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 * @param serviceName [required] The internal ID of EmailPro service
	 */
	public OvhItem cartServiceOption_emailpro_serviceName_POST(String serviceName, String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cartServiceOption/emailpro/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "cartId", cartId);
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/cartServiceOption/emailpro
	 */
	public ArrayList<String> cartServiceOption_emailpro_GET() throws IOException {
		String qPath = "/order/cartServiceOption/emailpro";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get informations about additional Microsoft offer for your service
	 *
	 * REST: GET /order/cartServiceOption/microsoftExchange/{serviceName}
	 * @param serviceName [required] The internal ID of Microsoft Exchange service
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericOptionDefinition> cartServiceOption_microsoftExchange_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/cartServiceOption/microsoftExchange/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post an additional Microsoft option in your cart
	 *
	 * REST: POST /order/cartServiceOption/microsoftExchange/{serviceName}
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the additional Microsoft offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 * @param serviceName [required] The internal ID of Microsoft Exchange service
	 *
	 * API beta
	 */
	public OvhItem cartServiceOption_microsoftExchange_serviceName_POST(String serviceName, String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cartServiceOption/microsoftExchange/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "cartId", cartId);
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/cartServiceOption/microsoftExchange
	 *
	 * API beta
	 */
	public ArrayList<String> cartServiceOption_microsoftExchange_GET() throws IOException {
		String qPath = "/order/cartServiceOption/microsoftExchange";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get informations about additional Logs offer for your service
	 *
	 * REST: GET /order/cartServiceOption/logs/{serviceName}
	 * @param serviceName [required] The internal ID of Logs service
	 */
	public ArrayList<OvhGenericOptionDefinition> cartServiceOption_logs_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/cartServiceOption/logs/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post an additional Logs option in your cart
	 *
	 * REST: POST /order/cartServiceOption/logs/{serviceName}
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the additional Logs offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 * @param serviceName [required] The internal ID of Logs service
	 */
	public OvhItem cartServiceOption_logs_serviceName_POST(String serviceName, String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cartServiceOption/logs/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "cartId", cartId);
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/cartServiceOption/logs
	 */
	public ArrayList<String> cartServiceOption_logs_GET() throws IOException {
		String qPath = "/order/cartServiceOption/logs";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/cartServiceOption/dedicated
	 */
	public ArrayList<String> cartServiceOption_dedicated_GET() throws IOException {
		String qPath = "/order/cartServiceOption/dedicated";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get informations about additional dedicated offer for your service
	 *
	 * REST: GET /order/cartServiceOption/dedicated/{serviceName}
	 * @param serviceName [required] The internal ID of Dedicated service
	 */
	public ArrayList<OvhGenericOptionDefinition> cartServiceOption_dedicated_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/cartServiceOption/dedicated/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post an additional dedicated option in your cart
	 *
	 * REST: POST /order/cartServiceOption/dedicated/{serviceName}
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the additional dedicated offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 * @param serviceName [required] The internal ID of Dedicated service
	 */
	public OvhItem cartServiceOption_dedicated_serviceName_POST(String serviceName, String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cartServiceOption/dedicated/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "cartId", cartId);
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about additional Cloud offer for your service
	 *
	 * REST: GET /order/cartServiceOption/cloud/{serviceName}
	 * @param serviceName [required] The internal ID of Cloud Project
	 */
	public ArrayList<OvhGenericOptionDefinition> cartServiceOption_cloud_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/cartServiceOption/cloud/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post an additional Cloud option in your cart
	 *
	 * REST: POST /order/cartServiceOption/cloud/{serviceName}
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the additional Cloud offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 * @param serviceName [required] The internal ID of Cloud Project
	 */
	public OvhItem cartServiceOption_cloud_serviceName_POST(String serviceName, String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cartServiceOption/cloud/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "cartId", cartId);
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/cartServiceOption/cloud
	 */
	public ArrayList<String> cartServiceOption_cloud_GET() throws IOException {
		String qPath = "/order/cartServiceOption/cloud";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get informations about additional IP Load-Balancing offer for your service
	 *
	 * REST: GET /order/cartServiceOption/ipLoadbalancing/{serviceName}
	 * @param serviceName [required] The internal ID of IP Load-Balancing service
	 */
	public ArrayList<OvhGenericOptionDefinition> cartServiceOption_ipLoadbalancing_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/cartServiceOption/ipLoadbalancing/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post an additional IP Load-Balancing option in your cart
	 *
	 * REST: POST /order/cartServiceOption/ipLoadbalancing/{serviceName}
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the additional IP Load-Balancing offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 * @param serviceName [required] The internal ID of IP Load-Balancing service
	 */
	public OvhItem cartServiceOption_ipLoadbalancing_serviceName_POST(String serviceName, String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cartServiceOption/ipLoadbalancing/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "cartId", cartId);
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/cartServiceOption/ipLoadbalancing
	 */
	public ArrayList<String> cartServiceOption_ipLoadbalancing_GET() throws IOException {
		String qPath = "/order/cartServiceOption/ipLoadbalancing";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get informations about additional Microsoft offer for your service
	 *
	 * REST: GET /order/cartServiceOption/microsoft/{serviceName}
	 * @param serviceName [required] The internal ID of Microsoft service
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericOptionDefinition> cartServiceOption_microsoft_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/cartServiceOption/microsoft/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post an additional Microsoft option in your cart
	 *
	 * REST: POST /order/cartServiceOption/microsoft/{serviceName}
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the additional Microsoft offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 * @param serviceName [required] The internal ID of Microsoft service
	 *
	 * API beta
	 */
	public OvhItem cartServiceOption_microsoft_serviceName_POST(String serviceName, String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cartServiceOption/microsoft/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "cartId", cartId);
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/cartServiceOption/microsoft
	 *
	 * API beta
	 */
	public ArrayList<String> cartServiceOption_microsoft_GET() throws IOException {
		String qPath = "/order/cartServiceOption/microsoft";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get informations about additional Domain offer for your service
	 *
	 * REST: GET /order/cartServiceOption/domain/{serviceName}
	 * @param serviceName [required] The internal ID of Domain service
	 */
	public ArrayList<OvhGenericOptionDefinition> cartServiceOption_domain_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/cartServiceOption/domain/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post an additional Domain option in your cart
	 *
	 * REST: POST /order/cartServiceOption/domain/{serviceName}
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the additional Domain offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 * @param serviceName [required] The internal ID of Domain service
	 */
	public OvhItem cartServiceOption_domain_serviceName_POST(String serviceName, String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cartServiceOption/domain/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "cartId", cartId);
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/cartServiceOption/domain
	 * @param whoisOwner [required] Filter the value of whoisOwner property (=)
	 */
	public ArrayList<String> cartServiceOption_domain_GET(String whoisOwner) throws IOException {
		String qPath = "/order/cartServiceOption/domain";
		StringBuilder sb = path(qPath);
		query(sb, "whoisOwner", whoisOwner);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get informations about additional Office offer for your service
	 *
	 * REST: GET /order/cartServiceOption/office365Prepaid/{serviceName}
	 * @param serviceName [required] The internal ID of Office service
	 */
	public ArrayList<OvhGenericOptionDefinition> cartServiceOption_office365Prepaid_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/cartServiceOption/office365Prepaid/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post an additional Office option in your cart
	 *
	 * REST: POST /order/cartServiceOption/office365Prepaid/{serviceName}
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the additional Office offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 * @param serviceName [required] The internal ID of Office service
	 */
	public OvhItem cartServiceOption_office365Prepaid_serviceName_POST(String serviceName, String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cartServiceOption/office365Prepaid/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "cartId", cartId);
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/cartServiceOption/office365Prepaid
	 */
	public ArrayList<String> cartServiceOption_office365Prepaid_GET() throws IOException {
		String qPath = "/order/cartServiceOption/office365Prepaid";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/cartServiceOption/privateCloud
	 */
	public ArrayList<String> cartServiceOption_privateCloud_GET() throws IOException {
		String qPath = "/order/cartServiceOption/privateCloud";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get informations about additional Private Cloud offer for your service
	 *
	 * REST: GET /order/cartServiceOption/privateCloud/{serviceName}
	 * @param serviceName [required] The private cloud service name
	 */
	public ArrayList<OvhGenericOptionDefinition> cartServiceOption_privateCloud_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/cartServiceOption/privateCloud/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post an additional Private Cloud option in your cart
	 *
	 * REST: POST /order/cartServiceOption/privateCloud/{serviceName}
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the additional private cloud offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 * @param serviceName [required] The private cloud service name
	 */
	public OvhItem cartServiceOption_privateCloud_serviceName_POST(String serviceName, String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cartServiceOption/privateCloud/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "cartId", cartId);
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about additional Horizon View offer for your service
	 *
	 * REST: GET /order/cartServiceOption/vdi/{serviceName}
	 * @param serviceName [required] The internal ID of Horizon View service
	 */
	public ArrayList<OvhGenericOptionDefinition> cartServiceOption_vdi_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/cartServiceOption/vdi/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post an additional Horizon View option in your cart
	 *
	 * REST: POST /order/cartServiceOption/vdi/{serviceName}
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the additional Horizon View offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 * @param serviceName [required] The internal ID of Horizon View service
	 */
	public OvhItem cartServiceOption_vdi_serviceName_POST(String serviceName, String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cartServiceOption/vdi/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "cartId", cartId);
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/cartServiceOption/vdi
	 */
	public ArrayList<String> cartServiceOption_vdi_GET() throws IOException {
		String qPath = "/order/cartServiceOption/vdi";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/cartServiceOption/sslGateway
	 */
	public ArrayList<String> cartServiceOption_sslGateway_GET() throws IOException {
		String qPath = "/order/cartServiceOption/sslGateway";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get informations about additional SSL Gateway offer for your service
	 *
	 * REST: GET /order/cartServiceOption/sslGateway/{serviceName}
	 * @param serviceName [required] The internal ID of SSL Gateway service
	 */
	public ArrayList<OvhGenericOptionDefinition> cartServiceOption_sslGateway_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/cartServiceOption/sslGateway/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post an additional SSL Gateway option in your cart
	 *
	 * REST: POST /order/cartServiceOption/sslGateway/{serviceName}
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the additional SSL Gateway offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 * @param serviceName [required] The internal ID of SSL Gateway service
	 */
	public OvhItem cartServiceOption_sslGateway_serviceName_POST(String serviceName, String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cartServiceOption/sslGateway/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "cartId", cartId);
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/cartServiceOption/privateCloudResellerEnterprise
	 */
	public ArrayList<String> cartServiceOption_privateCloudResellerEnterprise_GET() throws IOException {
		String qPath = "/order/cartServiceOption/privateCloudResellerEnterprise";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get informations about additional Private Cloud Enterprise offer for your service
	 *
	 * REST: GET /order/cartServiceOption/privateCloudResellerEnterprise/{serviceName}
	 * @param serviceName [required] The private cloud service name
	 */
	public ArrayList<OvhGenericOptionDefinition> cartServiceOption_privateCloudResellerEnterprise_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/cartServiceOption/privateCloudResellerEnterprise/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post an additional Private Cloud Enterprise option in your cart
	 *
	 * REST: POST /order/cartServiceOption/privateCloudResellerEnterprise/{serviceName}
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the additional private cloud enterprise offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 * @param serviceName [required] The private cloud service name
	 */
	public OvhItem cartServiceOption_privateCloudResellerEnterprise_serviceName_POST(String serviceName, String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cartServiceOption/privateCloudResellerEnterprise/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "cartId", cartId);
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about additional Private Cloud offer for your service
	 *
	 * REST: GET /order/cartServiceOption/privateCloudReseller/{serviceName}
	 * @param serviceName [required] The private cloud service name
	 */
	public ArrayList<OvhGenericOptionDefinition> cartServiceOption_privateCloudReseller_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/cartServiceOption/privateCloudReseller/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post an additional Private Cloud option in your cart
	 *
	 * REST: POST /order/cartServiceOption/privateCloudReseller/{serviceName}
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the additional private cloud offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 * @param serviceName [required] The private cloud service name
	 */
	public OvhItem cartServiceOption_privateCloudReseller_serviceName_POST(String serviceName, String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cartServiceOption/privateCloudReseller/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "cartId", cartId);
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/cartServiceOption/privateCloudReseller
	 */
	public ArrayList<String> cartServiceOption_privateCloudReseller_GET() throws IOException {
		String qPath = "/order/cartServiceOption/privateCloudReseller";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/license/worklight
	 */
	public ArrayList<String> license_worklight_GET() throws IOException {
		String qPath = "/order/license/worklight";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/license/worklight/{serviceName}
	 * @param serviceName [required] The name of your WorkLight license
	 */
	public ArrayList<String> license_worklight_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/license/worklight/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'upgrade' option
	 *
	 * REST: GET /order/license/worklight/{serviceName}/upgrade
	 * @param version [required] This license version
	 * @param serviceName [required] The name of your WorkLight license
	 */
	public ArrayList<String> license_worklight_serviceName_upgrade_GET(String serviceName, OvhWorkLightVersionEnum version) throws IOException {
		String qPath = "/order/license/worklight/{serviceName}/upgrade";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/license/worklight/{serviceName}/upgrade/{duration}
	 * @param version [required] This license version
	 * @param serviceName [required] The name of your WorkLight license
	 * @param duration [required] Duration
	 */
	public OvhOrder license_worklight_serviceName_upgrade_duration_GET(String serviceName, String duration, OvhWorkLightVersionEnum version) throws IOException {
		String qPath = "/order/license/worklight/{serviceName}/upgrade/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/license/worklight/{serviceName}/upgrade/{duration}
	 * @param version [required] This license version
	 * @param serviceName [required] The name of your WorkLight license
	 * @param duration [required] Duration
	 */
	public OvhOrder license_worklight_serviceName_upgrade_duration_POST(String serviceName, String duration, OvhWorkLightVersionEnum version) throws IOException {
		String qPath = "/order/license/worklight/{serviceName}/upgrade/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "version", version);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/license/worklight/new/{duration}
	 * @param lessThan1000Users [required] Does your company have less than 1000 potential users
	 * @param version [required] This license version
	 * @param ip [required] Ip on which this license would be installed (for dedicated your main server Ip)
	 * @param duration [required] Duration
	 */
	public OvhOrder license_worklight_new_duration_GET(String duration, String ip, Boolean lessThan1000Users, OvhWorkLightVersionEnum version) throws IOException {
		String qPath = "/order/license/worklight/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		query(sb, "ip", ip);
		query(sb, "lessThan1000Users", lessThan1000Users);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/license/worklight/new/{duration}
	 * @param lessThan1000Users [required] Does your company have less than 1000 potential users
	 * @param version [required] This license version
	 * @param ip [required] Ip on which this license would be installed (for dedicated your main server Ip)
	 * @param duration [required] Duration
	 */
	public OvhOrder license_worklight_new_duration_POST(String duration, String ip, Boolean lessThan1000Users, OvhWorkLightVersionEnum version) throws IOException {
		String qPath = "/order/license/worklight/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "ip", ip);
		addBody(o, "lessThan1000Users", lessThan1000Users);
		addBody(o, "version", version);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'new' option
	 *
	 * REST: GET /order/license/worklight/new
	 * @param lessThan1000Users [required] Does your company have less than 1000 potential users
	 * @param version [required] This license version
	 * @param ip [required] Ip on which this license would be installed (for dedicated your main server Ip)
	 */
	public ArrayList<String> license_worklight_new_GET(String ip, Boolean lessThan1000Users, OvhWorkLightVersionEnum version) throws IOException {
		String qPath = "/order/license/worklight/new";
		StringBuilder sb = path(qPath);
		query(sb, "ip", ip);
		query(sb, "lessThan1000Users", lessThan1000Users);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/license/virtuozzo/{serviceName}/upgrade/{duration}
	 * @param containerNumber [required] How much container is this license able to manage ...
	 * @param serviceName [required] The name of your Virtuozzo license
	 * @param duration [required] Duration
	 */
	public OvhOrder license_virtuozzo_serviceName_upgrade_duration_GET(String serviceName, String duration, OvhOrderableVirtuozzoContainerNumberEnum containerNumber) throws IOException {
		String qPath = "/order/license/virtuozzo/{serviceName}/upgrade/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "containerNumber", containerNumber);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/license/virtuozzo/{serviceName}/upgrade/{duration}
	 * @param containerNumber [required] How much container is this license able to manage ...
	 * @param serviceName [required] The name of your Virtuozzo license
	 * @param duration [required] Duration
	 */
	public OvhOrder license_virtuozzo_serviceName_upgrade_duration_POST(String serviceName, String duration, OvhOrderableVirtuozzoContainerNumberEnum containerNumber) throws IOException {
		String qPath = "/order/license/virtuozzo/{serviceName}/upgrade/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "containerNumber", containerNumber);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'upgrade' option
	 *
	 * REST: GET /order/license/virtuozzo/{serviceName}/upgrade
	 * @param containerNumber [required] How much container is this license able to manage ...
	 * @param serviceName [required] The name of your Virtuozzo license
	 */
	public ArrayList<String> license_virtuozzo_serviceName_upgrade_GET(String serviceName, OvhOrderableVirtuozzoContainerNumberEnum containerNumber) throws IOException {
		String qPath = "/order/license/virtuozzo/{serviceName}/upgrade";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "containerNumber", containerNumber);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/license/virtuozzo/{serviceName}
	 * @param serviceName [required] The name of your Virtuozzo license
	 */
	public ArrayList<String> license_virtuozzo_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/license/virtuozzo/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/license/virtuozzo
	 */
	public ArrayList<String> license_virtuozzo_GET() throws IOException {
		String qPath = "/order/license/virtuozzo";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'new' option
	 *
	 * REST: GET /order/license/virtuozzo/new
	 * @param serviceType [required] # DEPRECATED # The kind of service on which this license will be used # Will not be used, keeped only for compatibility #
	 * @param version [required] This license version
	 * @param containerNumber [required] How much container is this license able to manage ...
	 * @param ip [required] Ip on which this license would be installed
	 */
	public ArrayList<String> license_virtuozzo_new_GET(OvhOrderableVirtuozzoContainerNumberEnum containerNumber, String ip, OvhLicenseTypeEnum serviceType, OvhOrderableVirtuozzoVersionEnum version) throws IOException {
		String qPath = "/order/license/virtuozzo/new";
		StringBuilder sb = path(qPath);
		query(sb, "containerNumber", containerNumber);
		query(sb, "ip", ip);
		query(sb, "serviceType", serviceType);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/license/virtuozzo/new/{duration}
	 * @param serviceType [required] # DEPRECATED # The kind of service on which this license will be used # Will not be used, keeped only for compatibility #
	 * @param version [required] This license version
	 * @param containerNumber [required] How much container is this license able to manage ...
	 * @param ip [required] Ip on which this license would be installed
	 * @param duration [required] Duration
	 */
	public OvhOrder license_virtuozzo_new_duration_GET(String duration, OvhOrderableVirtuozzoContainerNumberEnum containerNumber, String ip, OvhLicenseTypeEnum serviceType, OvhOrderableVirtuozzoVersionEnum version) throws IOException {
		String qPath = "/order/license/virtuozzo/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		query(sb, "containerNumber", containerNumber);
		query(sb, "ip", ip);
		query(sb, "serviceType", serviceType);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/license/virtuozzo/new/{duration}
	 * @param serviceType [required] # DEPRECATED # The kind of service on which this license will be used # Will not be used, keeped only for compatibility #
	 * @param version [required] This license version
	 * @param containerNumber [required] How much container is this license able to manage ...
	 * @param ip [required] Ip on which this license would be installed
	 * @param duration [required] Duration
	 */
	public OvhOrder license_virtuozzo_new_duration_POST(String duration, OvhOrderableVirtuozzoContainerNumberEnum containerNumber, String ip, OvhLicenseTypeEnum serviceType, OvhOrderableVirtuozzoVersionEnum version) throws IOException {
		String qPath = "/order/license/virtuozzo/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "containerNumber", containerNumber);
		addBody(o, "ip", ip);
		addBody(o, "serviceType", serviceType);
		addBody(o, "version", version);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/license/directadmin/new/{duration}
	 * @param ip [required] Ip on which this license would be installed
	 * @param version [required] This license version
	 * @param serviceType [required] # DEPRECATED # The kind of service on which this license will be used # Will not be used, keeped only for compatibility #
	 * @param duration [required] Duration
	 */
	public OvhOrder license_directadmin_new_duration_GET(String duration, String ip, OvhLicenseTypeEnum serviceType, OvhOrderableDirectAdminVersionEnum version) throws IOException {
		String qPath = "/order/license/directadmin/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		query(sb, "ip", ip);
		query(sb, "serviceType", serviceType);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/license/directadmin/new/{duration}
	 * @param ip [required] Ip on which this license would be installed
	 * @param version [required] This license version
	 * @param serviceType [required] # DEPRECATED # The kind of service on which this license will be used # Will not be used, keeped only for compatibility #
	 * @param duration [required] Duration
	 */
	public OvhOrder license_directadmin_new_duration_POST(String duration, String ip, OvhLicenseTypeEnum serviceType, OvhOrderableDirectAdminVersionEnum version) throws IOException {
		String qPath = "/order/license/directadmin/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "ip", ip);
		addBody(o, "serviceType", serviceType);
		addBody(o, "version", version);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'new' option
	 *
	 * REST: GET /order/license/directadmin/new
	 * @param ip [required] Ip on which this license would be installed
	 * @param version [required] This license version
	 * @param serviceType [required] # DEPRECATED # The kind of service on which this license will be used # Will not be used, keeped only for compatibility #
	 */
	public ArrayList<String> license_directadmin_new_GET(String ip, OvhLicenseTypeEnum serviceType, OvhOrderableDirectAdminVersionEnum version) throws IOException {
		String qPath = "/order/license/directadmin/new";
		StringBuilder sb = path(qPath);
		query(sb, "ip", ip);
		query(sb, "serviceType", serviceType);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/license/windows/new/{duration}
	 * @param sqlVersion [required] The SQL Server version to enable on this license Windows license
	 * @param ip [required] Ip on which this license would be installed (for dedicated your main server Ip)
	 * @param version [required] This license version
	 * @param serviceType [required] # DEPRECATED # The kind of service on which this license will be used # Will not be used, keeped only for compatibility #
	 * @param duration [required] Duration
	 */
	public OvhOrder license_windows_new_duration_GET(String duration, String ip, OvhLicenseTypeEnum serviceType, OvhWindowsSqlVersionEnum sqlVersion, OvhWindowsOsVersionEnum version) throws IOException {
		String qPath = "/order/license/windows/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		query(sb, "ip", ip);
		query(sb, "serviceType", serviceType);
		query(sb, "sqlVersion", sqlVersion);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/license/windows/new/{duration}
	 * @param sqlVersion [required] The SQL Server version to enable on this license Windows license
	 * @param ip [required] Ip on which this license would be installed (for dedicated your main server Ip)
	 * @param version [required] This license version
	 * @param serviceType [required] # DEPRECATED # The kind of service on which this license will be used # Will not be used, keeped only for compatibility #
	 * @param duration [required] Duration
	 */
	public OvhOrder license_windows_new_duration_POST(String duration, String ip, OvhLicenseTypeEnum serviceType, OvhWindowsSqlVersionEnum sqlVersion, OvhWindowsOsVersionEnum version) throws IOException {
		String qPath = "/order/license/windows/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "ip", ip);
		addBody(o, "serviceType", serviceType);
		addBody(o, "sqlVersion", sqlVersion);
		addBody(o, "version", version);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'new' option
	 *
	 * REST: GET /order/license/windows/new
	 * @param sqlVersion [required] The SQL Server version to enable on this license Windows license
	 * @param ip [required] Ip on which this license would be installed (for dedicated your main server Ip)
	 * @param version [required] This license version
	 * @param serviceType [required] # DEPRECATED # The kind of service on which this license will be used # Will not be used, keeped only for compatibility #
	 */
	public ArrayList<String> license_windows_new_GET(String ip, OvhLicenseTypeEnum serviceType, OvhWindowsSqlVersionEnum sqlVersion, OvhWindowsOsVersionEnum version) throws IOException {
		String qPath = "/order/license/windows/new";
		StringBuilder sb = path(qPath);
		query(sb, "ip", ip);
		query(sb, "serviceType", serviceType);
		query(sb, "sqlVersion", sqlVersion);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'upgrade' option
	 *
	 * REST: GET /order/license/windows/{serviceName}/upgrade
	 * @param sqlVersion [required] The SQL Server version to enable on this license Windows license
	 * @param version [required] The windows version you want to enable on your windows license
	 * @param serviceName [required] The name of your Windows license
	 */
	public ArrayList<String> license_windows_serviceName_upgrade_GET(String serviceName, OvhWindowsSqlVersionEnum sqlVersion, OvhWindowsOsVersionEnum version) throws IOException {
		String qPath = "/order/license/windows/{serviceName}/upgrade";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "sqlVersion", sqlVersion);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/license/windows/{serviceName}/upgrade/{duration}
	 * @param sqlVersion [required] The SQL Server version to enable on this license Windows license
	 * @param version [required] The windows version you want to enable on your windows license
	 * @param serviceName [required] The name of your Windows license
	 * @param duration [required] Duration
	 */
	public OvhOrder license_windows_serviceName_upgrade_duration_GET(String serviceName, String duration, OvhWindowsSqlVersionEnum sqlVersion, OvhWindowsOsVersionEnum version) throws IOException {
		String qPath = "/order/license/windows/{serviceName}/upgrade/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "sqlVersion", sqlVersion);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/license/windows/{serviceName}/upgrade/{duration}
	 * @param sqlVersion [required] The SQL Server version to enable on this license Windows license
	 * @param version [required] The windows version you want to enable on your windows license
	 * @param serviceName [required] The name of your Windows license
	 * @param duration [required] Duration
	 */
	public OvhOrder license_windows_serviceName_upgrade_duration_POST(String serviceName, String duration, OvhWindowsSqlVersionEnum sqlVersion, OvhWindowsOsVersionEnum version) throws IOException {
		String qPath = "/order/license/windows/{serviceName}/upgrade/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "sqlVersion", sqlVersion);
		addBody(o, "version", version);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/license/windows/{serviceName}
	 * @param serviceName [required] The name of your Windows license
	 */
	public ArrayList<String> license_windows_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/license/windows/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/license/windows
	 */
	public ArrayList<String> license_windows_GET() throws IOException {
		String qPath = "/order/license/windows";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/license/plesk/new/{duration}
	 * @param languagePackNumber [required] The amount of language pack numbers to include in this licences
	 * @param applicationSet [required] Wanted application set
	 * @param serviceType [required] # DEPRECATED # The kind of service on which this license will be used # Will not be used, keeped only for compatibility #
	 * @param resellerManagement [required] Reseller management option activation
	 * @param powerpack [required] powerpack current activation state on your license
	 * @param domainNumber [required] This license domain number
	 * @param ip [required] Ip on which this license would be installed
	 * @param version [required] This license version
	 * @param antivirus [required] The antivirus to enable on this Plesk license
	 * @param wordpressToolkit [required] WordpressToolkit option activation
	 * @param duration [required] Duration
	 */
	public OvhOrder license_plesk_new_duration_GET(String duration, OvhOrderableAntivirusEnum antivirus, OvhPleskApplicationSetEnum applicationSet, OvhOrderablePleskDomainNumberEnum domainNumber, String ip, OvhOrderablePleskLanguagePackEnum languagePackNumber, Boolean powerpack, Boolean resellerManagement, OvhLicenseTypeEnum serviceType, OvhPleskVersionEnum version, Boolean wordpressToolkit) throws IOException {
		String qPath = "/order/license/plesk/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		query(sb, "antivirus", antivirus);
		query(sb, "applicationSet", applicationSet);
		query(sb, "domainNumber", domainNumber);
		query(sb, "ip", ip);
		query(sb, "languagePackNumber", languagePackNumber);
		query(sb, "powerpack", powerpack);
		query(sb, "resellerManagement", resellerManagement);
		query(sb, "serviceType", serviceType);
		query(sb, "version", version);
		query(sb, "wordpressToolkit", wordpressToolkit);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/license/plesk/new/{duration}
	 * @param languagePackNumber [required] The amount of language pack numbers to include in this licences
	 * @param applicationSet [required] Wanted application set
	 * @param serviceType [required] # DEPRECATED # The kind of service on which this license will be used # Will not be used, keeped only for compatibility #
	 * @param resellerManagement [required] Reseller management option activation
	 * @param powerpack [required] powerpack current activation state on your license
	 * @param domainNumber [required] This license domain number
	 * @param ip [required] Ip on which this license would be installed
	 * @param version [required] This license version
	 * @param antivirus [required] The antivirus to enable on this Plesk license
	 * @param wordpressToolkit [required] WordpressToolkit option activation
	 * @param duration [required] Duration
	 */
	public OvhOrder license_plesk_new_duration_POST(String duration, OvhOrderableAntivirusEnum antivirus, OvhPleskApplicationSetEnum applicationSet, OvhOrderablePleskDomainNumberEnum domainNumber, String ip, OvhOrderablePleskLanguagePackEnum languagePackNumber, Boolean powerpack, Boolean resellerManagement, OvhLicenseTypeEnum serviceType, OvhPleskVersionEnum version, Boolean wordpressToolkit) throws IOException {
		String qPath = "/order/license/plesk/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "antivirus", antivirus);
		addBody(o, "applicationSet", applicationSet);
		addBody(o, "domainNumber", domainNumber);
		addBody(o, "ip", ip);
		addBody(o, "languagePackNumber", languagePackNumber);
		addBody(o, "powerpack", powerpack);
		addBody(o, "resellerManagement", resellerManagement);
		addBody(o, "serviceType", serviceType);
		addBody(o, "version", version);
		addBody(o, "wordpressToolkit", wordpressToolkit);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'new' option
	 *
	 * REST: GET /order/license/plesk/new
	 * @param languagePackNumber [required] The amount of language pack numbers to include in this licences
	 * @param applicationSet [required] Wanted application set
	 * @param serviceType [required] # DEPRECATED # The kind of service on which this license will be used # Will not be used, keeped only for compatibility #
	 * @param resellerManagement [required] Reseller management option activation
	 * @param powerpack [required] powerpack current activation state on your license
	 * @param domainNumber [required] This license domain number
	 * @param ip [required] Ip on which this license would be installed
	 * @param version [required] This license version
	 * @param antivirus [required] The antivirus to enable on this Plesk license
	 * @param wordpressToolkit [required] WordpressToolkit option activation
	 */
	public ArrayList<String> license_plesk_new_GET(OvhOrderableAntivirusEnum antivirus, OvhPleskApplicationSetEnum applicationSet, OvhOrderablePleskDomainNumberEnum domainNumber, String ip, OvhOrderablePleskLanguagePackEnum languagePackNumber, Boolean powerpack, Boolean resellerManagement, OvhLicenseTypeEnum serviceType, OvhPleskVersionEnum version, Boolean wordpressToolkit) throws IOException {
		String qPath = "/order/license/plesk/new";
		StringBuilder sb = path(qPath);
		query(sb, "antivirus", antivirus);
		query(sb, "applicationSet", applicationSet);
		query(sb, "domainNumber", domainNumber);
		query(sb, "ip", ip);
		query(sb, "languagePackNumber", languagePackNumber);
		query(sb, "powerpack", powerpack);
		query(sb, "resellerManagement", resellerManagement);
		query(sb, "serviceType", serviceType);
		query(sb, "version", version);
		query(sb, "wordpressToolkit", wordpressToolkit);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/license/plesk
	 */
	public ArrayList<String> license_plesk_GET() throws IOException {
		String qPath = "/order/license/plesk";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/license/plesk/{serviceName}
	 * @param serviceName [required] The name of your Plesk license
	 */
	public ArrayList<String> license_plesk_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/license/plesk/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/license/plesk/{serviceName}/upgrade/{duration}
	 * @param languagePackNumber [required] The amount (between 0 and 5) of language pack numbers to include in this licences
	 * @param applicationSet [required] Wanted application set
	 * @param resellerManagement [required] Reseller management option activation
	 * @param antispam [required] The antispam currently enabled on this Plesk License
	 * @param powerpack [required] powerpack current activation state on your license
	 * @param domainNumber [required] This license domain number
	 * @param version [required] This license version
	 * @param antivirus [required] The antivirus to enable on this Plesk license
	 * @param wordpressToolkit [required] WordpressToolkit option activation
	 * @param serviceName [required] The name of your Plesk license
	 * @param duration [required] Duration
	 */
	public OvhOrder license_plesk_serviceName_upgrade_duration_GET(String serviceName, String duration, OvhOrderableAntispamEnum antispam, OvhOrderableAntivirusEnum antivirus, OvhPleskApplicationSetEnum applicationSet, OvhOrderablePleskDomainNumberEnum domainNumber, OvhOrderablePleskLanguagePackEnum languagePackNumber, Boolean powerpack, Boolean resellerManagement, OvhPleskVersionEnum version, Boolean wordpressToolkit) throws IOException {
		String qPath = "/order/license/plesk/{serviceName}/upgrade/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "antispam", antispam);
		query(sb, "antivirus", antivirus);
		query(sb, "applicationSet", applicationSet);
		query(sb, "domainNumber", domainNumber);
		query(sb, "languagePackNumber", languagePackNumber);
		query(sb, "powerpack", powerpack);
		query(sb, "resellerManagement", resellerManagement);
		query(sb, "version", version);
		query(sb, "wordpressToolkit", wordpressToolkit);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/license/plesk/{serviceName}/upgrade/{duration}
	 * @param languagePackNumber [required] The amount (between 0 and 5) of language pack numbers to include in this licences
	 * @param applicationSet [required] Wanted application set
	 * @param resellerManagement [required] Reseller management option activation
	 * @param antispam [required] The antispam currently enabled on this Plesk License
	 * @param powerpack [required] powerpack current activation state on your license
	 * @param domainNumber [required] This license domain number
	 * @param version [required] This license version
	 * @param antivirus [required] The antivirus to enable on this Plesk license
	 * @param wordpressToolkit [required] WordpressToolkit option activation
	 * @param serviceName [required] The name of your Plesk license
	 * @param duration [required] Duration
	 */
	public OvhOrder license_plesk_serviceName_upgrade_duration_POST(String serviceName, String duration, OvhOrderableAntispamEnum antispam, OvhOrderableAntivirusEnum antivirus, OvhPleskApplicationSetEnum applicationSet, OvhOrderablePleskDomainNumberEnum domainNumber, OvhOrderablePleskLanguagePackEnum languagePackNumber, Boolean powerpack, Boolean resellerManagement, OvhPleskVersionEnum version, Boolean wordpressToolkit) throws IOException {
		String qPath = "/order/license/plesk/{serviceName}/upgrade/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "antispam", antispam);
		addBody(o, "antivirus", antivirus);
		addBody(o, "applicationSet", applicationSet);
		addBody(o, "domainNumber", domainNumber);
		addBody(o, "languagePackNumber", languagePackNumber);
		addBody(o, "powerpack", powerpack);
		addBody(o, "resellerManagement", resellerManagement);
		addBody(o, "version", version);
		addBody(o, "wordpressToolkit", wordpressToolkit);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'upgrade' option
	 *
	 * REST: GET /order/license/plesk/{serviceName}/upgrade
	 * @param languagePackNumber [required] The amount (between 0 and 5) of language pack numbers to include in this licences
	 * @param applicationSet [required] Wanted application set
	 * @param resellerManagement [required] Reseller management option activation
	 * @param antispam [required] The antispam currently enabled on this Plesk License
	 * @param powerpack [required] powerpack current activation state on your license
	 * @param domainNumber [required] This license domain number
	 * @param version [required] This license version
	 * @param antivirus [required] The antivirus to enable on this Plesk license
	 * @param wordpressToolkit [required] WordpressToolkit option activation
	 * @param serviceName [required] The name of your Plesk license
	 */
	public ArrayList<String> license_plesk_serviceName_upgrade_GET(String serviceName, OvhOrderableAntispamEnum antispam, OvhOrderableAntivirusEnum antivirus, OvhPleskApplicationSetEnum applicationSet, OvhOrderablePleskDomainNumberEnum domainNumber, OvhOrderablePleskLanguagePackEnum languagePackNumber, Boolean powerpack, Boolean resellerManagement, OvhPleskVersionEnum version, Boolean wordpressToolkit) throws IOException {
		String qPath = "/order/license/plesk/{serviceName}/upgrade";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "antispam", antispam);
		query(sb, "antivirus", antivirus);
		query(sb, "applicationSet", applicationSet);
		query(sb, "domainNumber", domainNumber);
		query(sb, "languagePackNumber", languagePackNumber);
		query(sb, "powerpack", powerpack);
		query(sb, "resellerManagement", resellerManagement);
		query(sb, "version", version);
		query(sb, "wordpressToolkit", wordpressToolkit);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'new' option
	 *
	 * REST: GET /order/license/cpanel/new
	 * @param version [required] This license version
	 * @param ip [required] Ip on which this license would be installed
	 * @param serviceType [required] # DEPRECATED # The kind of service on which this license will be used # Will not be used, keeped only for compatibility #
	 */
	public ArrayList<String> license_cpanel_new_GET(String ip, OvhLicenseTypeEnum serviceType, OvhOrderableCpanelVersionEnum version) throws IOException {
		String qPath = "/order/license/cpanel/new";
		StringBuilder sb = path(qPath);
		query(sb, "ip", ip);
		query(sb, "serviceType", serviceType);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/license/cpanel/new/{duration}
	 * @param version [required] This license version
	 * @param ip [required] Ip on which this license would be installed
	 * @param serviceType [required] # DEPRECATED # The kind of service on which this license will be used # Will not be used, keeped only for compatibility #
	 * @param duration [required] Duration
	 */
	public OvhOrder license_cpanel_new_duration_GET(String duration, String ip, OvhLicenseTypeEnum serviceType, OvhOrderableCpanelVersionEnum version) throws IOException {
		String qPath = "/order/license/cpanel/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		query(sb, "ip", ip);
		query(sb, "serviceType", serviceType);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/license/cpanel/new/{duration}
	 * @param version [required] This license version
	 * @param ip [required] Ip on which this license would be installed
	 * @param serviceType [required] # DEPRECATED # The kind of service on which this license will be used # Will not be used, keeped only for compatibility #
	 * @param duration [required] Duration
	 */
	public OvhOrder license_cpanel_new_duration_POST(String duration, String ip, OvhLicenseTypeEnum serviceType, OvhOrderableCpanelVersionEnum version) throws IOException {
		String qPath = "/order/license/cpanel/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "ip", ip);
		addBody(o, "serviceType", serviceType);
		addBody(o, "version", version);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'new' option
	 *
	 * REST: GET /order/license/office/new
	 * @param officeProPlusQuantity [required] Number of prepaid office pro plus license
	 * @param giftCode [required] Gift code for office license
	 * @param officeBusinessQuantity [required] Number of prepaid office business license
	 */
	public ArrayList<String> license_office_new_GET(String giftCode, Long officeBusinessQuantity, Long officeProPlusQuantity) throws IOException {
		String qPath = "/order/license/office/new";
		StringBuilder sb = path(qPath);
		query(sb, "giftCode", giftCode);
		query(sb, "officeBusinessQuantity", officeBusinessQuantity);
		query(sb, "officeProPlusQuantity", officeProPlusQuantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/license/office/new/{duration}
	 * @param officeProPlusQuantity [required] Number of prepaid office pro plus license
	 * @param giftCode [required] Gift code for office license
	 * @param officeBusinessQuantity [required] Number of prepaid office business license
	 * @param duration [required] Duration
	 */
	public OvhOrder license_office_new_duration_GET(String duration, String giftCode, Long officeBusinessQuantity, Long officeProPlusQuantity) throws IOException {
		String qPath = "/order/license/office/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		query(sb, "giftCode", giftCode);
		query(sb, "officeBusinessQuantity", officeBusinessQuantity);
		query(sb, "officeProPlusQuantity", officeProPlusQuantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/license/office/new/{duration}
	 * @param officeProPlusQuantity [required] Number of prepaid office pro plus license
	 * @param giftCode [required] Gift code for office license
	 * @param officeBusinessQuantity [required] Number of prepaid office business license
	 * @param duration [required] Duration
	 */
	public OvhOrder license_office_new_duration_POST(String duration, String giftCode, Long officeBusinessQuantity, Long officeProPlusQuantity) throws IOException {
		String qPath = "/order/license/office/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "giftCode", giftCode);
		addBody(o, "officeBusinessQuantity", officeBusinessQuantity);
		addBody(o, "officeProPlusQuantity", officeProPlusQuantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'new' option
	 *
	 * REST: GET /order/license/cloudLinux/new
	 * @param ip [required] Ip on which this license would be installed (for dedicated your main server Ip)
	 * @param version [required] This license version
	 */
	public ArrayList<String> license_cloudLinux_new_GET(String ip, OvhCloudLinuxVersionEnum version) throws IOException {
		String qPath = "/order/license/cloudLinux/new";
		StringBuilder sb = path(qPath);
		query(sb, "ip", ip);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/license/cloudLinux/new/{duration}
	 * @param ip [required] Ip on which this license would be installed (for dedicated your main server Ip)
	 * @param version [required] This license version
	 * @param duration [required] Duration
	 */
	public OvhOrder license_cloudLinux_new_duration_GET(String duration, String ip, OvhCloudLinuxVersionEnum version) throws IOException {
		String qPath = "/order/license/cloudLinux/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		query(sb, "ip", ip);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/license/cloudLinux/new/{duration}
	 * @param ip [required] Ip on which this license would be installed (for dedicated your main server Ip)
	 * @param version [required] This license version
	 * @param duration [required] Duration
	 */
	public OvhOrder license_cloudLinux_new_duration_POST(String duration, String ip, OvhCloudLinuxVersionEnum version) throws IOException {
		String qPath = "/order/license/cloudLinux/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "ip", ip);
		addBody(o, "version", version);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/license/sqlserver/new/{duration}
	 * @param ip [required] Ip on which this license would be installed (for dedicated your main server Ip)
	 * @param version [required] This license version
	 * @param duration [required] Duration
	 */
	public OvhOrder license_sqlserver_new_duration_GET(String duration, String ip, OvhSqlServerVersionEnum version) throws IOException {
		String qPath = "/order/license/sqlserver/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		query(sb, "ip", ip);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/license/sqlserver/new/{duration}
	 * @param ip [required] Ip on which this license would be installed (for dedicated your main server Ip)
	 * @param version [required] This license version
	 * @param duration [required] Duration
	 */
	public OvhOrder license_sqlserver_new_duration_POST(String duration, String ip, OvhSqlServerVersionEnum version) throws IOException {
		String qPath = "/order/license/sqlserver/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "ip", ip);
		addBody(o, "version", version);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'new' option
	 *
	 * REST: GET /order/license/sqlserver/new
	 * @param ip [required] Ip on which this license would be installed (for dedicated your main server Ip)
	 * @param version [required] This license version
	 */
	public ArrayList<String> license_sqlserver_new_GET(String ip, OvhSqlServerVersionEnum version) throws IOException {
		String qPath = "/order/license/sqlserver/new";
		StringBuilder sb = path(qPath);
		query(sb, "ip", ip);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/license/sqlserver/{serviceName}
	 * @param serviceName [required] The name of your SQL Server license
	 */
	public ArrayList<String> license_sqlserver_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/license/sqlserver/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/license/sqlserver/{serviceName}/upgrade/{duration}
	 * @param version [required] This license version
	 * @param serviceName [required] The name of your SQL Server license
	 * @param duration [required] Duration
	 */
	public OvhOrder license_sqlserver_serviceName_upgrade_duration_GET(String serviceName, String duration, OvhSqlServerVersionEnum version) throws IOException {
		String qPath = "/order/license/sqlserver/{serviceName}/upgrade/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/license/sqlserver/{serviceName}/upgrade/{duration}
	 * @param version [required] This license version
	 * @param serviceName [required] The name of your SQL Server license
	 * @param duration [required] Duration
	 */
	public OvhOrder license_sqlserver_serviceName_upgrade_duration_POST(String serviceName, String duration, OvhSqlServerVersionEnum version) throws IOException {
		String qPath = "/order/license/sqlserver/{serviceName}/upgrade/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "version", version);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'upgrade' option
	 *
	 * REST: GET /order/license/sqlserver/{serviceName}/upgrade
	 * @param version [required] This license version
	 * @param serviceName [required] The name of your SQL Server license
	 */
	public ArrayList<String> license_sqlserver_serviceName_upgrade_GET(String serviceName, OvhSqlServerVersionEnum version) throws IOException {
		String qPath = "/order/license/sqlserver/{serviceName}/upgrade";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "version", version);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/license/sqlserver
	 */
	public ArrayList<String> license_sqlserver_GET() throws IOException {
		String qPath = "/order/license/sqlserver";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/router/new/{duration}
	 * @param vrack [required] The name of your vrack
	 * @param duration [required] Duration
	 */
	public OvhOrder router_new_duration_GET(String duration, String vrack) throws IOException {
		String qPath = "/order/router/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		query(sb, "vrack", vrack);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/router/new/{duration}
	 * @param vrack [required] The name of your vrack
	 * @param duration [required] Duration
	 */
	public OvhOrder router_new_duration_POST(String duration, String vrack) throws IOException {
		String qPath = "/order/router/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "vrack", vrack);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'new' option
	 *
	 * REST: GET /order/router/new
	 * @param vrack [required] The name of your vrack
	 */
	public ArrayList<String> router_new_GET(String vrack) throws IOException {
		String qPath = "/order/router/new";
		StringBuilder sb = path(qPath);
		query(sb, "vrack", vrack);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/domain/zone
	 */
	public ArrayList<String> domain_zone_GET() throws IOException {
		String qPath = "/order/domain/zone";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/domain/zone/{zoneName}/dnsAnycast/{duration}
	 * @param zoneName [required] The internal name of your zone
	 * @param duration [required] Duration
	 */
	public OvhOrder domain_zone_zoneName_dnsAnycast_duration_GET(String zoneName, String duration) throws IOException {
		String qPath = "/order/domain/zone/{zoneName}/dnsAnycast/{duration}";
		StringBuilder sb = path(qPath, zoneName, duration);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/domain/zone/{zoneName}/dnsAnycast/{duration}
	 * @param zoneName [required] The internal name of your zone
	 * @param duration [required] Duration
	 */
	public OvhOrder domain_zone_zoneName_dnsAnycast_duration_POST(String zoneName, String duration) throws IOException {
		String qPath = "/order/domain/zone/{zoneName}/dnsAnycast/{duration}";
		StringBuilder sb = path(qPath, zoneName, duration);
		String resp = exec(qPath, "POST", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'dnsAnycast' option
	 *
	 * REST: GET /order/domain/zone/{zoneName}/dnsAnycast
	 * @param zoneName [required] The internal name of your zone
	 */
	public ArrayList<String> domain_zone_zoneName_dnsAnycast_GET(String zoneName) throws IOException {
		String qPath = "/order/domain/zone/{zoneName}/dnsAnycast";
		StringBuilder sb = path(qPath, zoneName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/domain/zone/{zoneName}
	 * @param zoneName [required] The internal name of your zone
	 */
	public ArrayList<String> domain_zone_zoneName_GET(String zoneName) throws IOException {
		String qPath = "/order/domain/zone/{zoneName}";
		StringBuilder sb = path(qPath, zoneName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/domain/zone/new
	 * @param minimized [required] Create only mandatory records
	 * @param zoneName [required] Name of the zone to create
	 */
	public OvhOrder domain_zone_new_GET(Boolean minimized, String zoneName) throws IOException {
		String qPath = "/order/domain/zone/new";
		StringBuilder sb = path(qPath);
		query(sb, "minimized", minimized);
		query(sb, "zoneName", zoneName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/domain/zone/new
	 * @param minimized [required] Create only mandatory records
	 * @param zoneName [required] Name of the zone to create
	 */
	public OvhOrder domain_zone_new_POST(Boolean minimized, String zoneName) throws IOException {
		String qPath = "/order/domain/zone/new";
		StringBuilder sb = path(qPath);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "minimized", minimized);
		addBody(o, "zoneName", zoneName);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get informations about Private Cloud Dedicated Cloud offers
	 *
	 * REST: GET /order/cart/{cartId}/privateCloudDC
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_privateCloudDC_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudDC";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}
	private static TypeReference<ArrayList<OvhGenericProductDefinition>> t3 = new TypeReference<ArrayList<OvhGenericProductDefinition>>() {};

	/**
	 * Post a new Private Cloud Dedicated Cloud item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/privateCloudDC
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Private Cloud Dedicated Cloud offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_privateCloudDC_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudDC";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Private Cloud Dedicated Cloud options
	 *
	 * REST: GET /order/cart/{cartId}/privateCloudDC/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Private Cloud Dedicated Cloud you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_privateCloudDC_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudDC/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Private Cloud Dedicated Cloud option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/privateCloudDC/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Private Cloud Dedicated Cloud option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_privateCloudDC_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudDC/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Reseller offers
	 *
	 * REST: GET /order/cart/{cartId}/reseller
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_reseller_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/reseller";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Reseller offer item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/reseller
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of Reseller offer (planCode)
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_reseller_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/reseller";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Office 365 Prepaid licenses
	 *
	 * REST: GET /order/cart/{cartId}/office365Prepaid
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_office365Prepaid_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/office365Prepaid";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Office 365 Prepaid item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/office365Prepaid
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Office365 license
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_office365Prepaid_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/office365Prepaid";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Office 365 Prepaid options
	 *
	 * REST: GET /order/cart/{cartId}/office365Prepaid/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of a Office 365 Prepaid main offer
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_office365Prepaid_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/office365Prepaid/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Office 365 Prepaid option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/office365Prepaid/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Office 365 Prepaid offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_office365Prepaid_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/office365Prepaid/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about SqlServer licenses offers
	 *
	 * REST: GET /order/cart/{cartId}/licenseSqlServer
	 * @param cartId [required] Cart identifier
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_licenseSqlServer_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/licenseSqlServer";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new SqlServer license item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/licenseSqlServer
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the SqlServer license offer
	 * @param duration [required] Duration selected for the rental of the product
	 * @param pricingMode [required] Pricing mode selected for the rental of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_licenseSqlServer_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/licenseSqlServer";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about CDN offers
	 *
	 * REST: GET /order/cart/{cartId}/cdn
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_cdn_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/cdn";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new CDN item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/cdn
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the CDN offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_cdn_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/cdn";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about CDN options
	 *
	 * REST: GET /order/cart/{cartId}/cdn/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the CDN offer you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_cdn_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/cdn/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new CDN option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/cdn/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item offer parent of the option
	 * @param planCode [required] Identifier of a CDN option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_cdn_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/cdn/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Windows licenses offers
	 *
	 * REST: GET /order/cart/{cartId}/licenseWindows
	 * @param cartId [required] Cart identifier
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_licenseWindows_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/licenseWindows";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Windows license item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/licenseWindows
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Windows license offer
	 * @param duration [required] Duration selected for the rental of the product
	 * @param pricingMode [required] Pricing mode selected for the rental of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_licenseWindows_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/licenseWindows";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about a timeseries offer
	 *
	 * REST: GET /order/cart/{cartId}/dbaasTimeseries
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_dbaasTimeseries_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/dbaasTimeseries";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new timeseries offer item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/dbaasTimeseries
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the timeseries offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_dbaasTimeseries_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/dbaasTimeseries";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about IP addresses offers
	 *
	 * REST: GET /order/cart/{cartId}/ip
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_ip_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/ip";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new IP addresses item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/ip
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the IP addresses offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_ip_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/ip";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about IP addresses options
	 *
	 * REST: GET /order/cart/{cartId}/ip/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the IP addresses you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_ip_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/ip/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new IP addresses option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/ip/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a IP addresses option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_ip_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/ip/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Domain packs offers (AllDom)
	 *
	 * REST: GET /order/cart/{cartId}/domainPacks
	 * @param cartId [required] Cart identifier
	 * @param domain [required] Domain name requested
	 *
	 * API beta
	 */
	public ArrayList<OvhDomainPacksProductInformation> cart_cartId_domainPacks_GET(String cartId, String domain) throws IOException {
		String qPath = "/order/cart/{cartId}/domainPacks";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "domain", domain);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t4);
	}
	private static TypeReference<ArrayList<OvhDomainPacksProductInformation>> t4 = new TypeReference<ArrayList<OvhDomainPacksProductInformation>>() {};

	/**
	 * Post a new Domain Packs item (AllDom) in your cart
	 *
	 * REST: POST /order/cart/{cartId}/domainPacks
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Domain Packs offer (AllDom)
	 * @param domain [required] Domain name to order
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_domainPacks_POST(String cartId, String domain, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/domainPacks";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "domain", domain);
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Dedicated Discover server offers
	 *
	 * REST: GET /order/cart/{cartId}/discover
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_discover_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/discover";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Dedicated Discover server item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/discover
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Dedicated Discover server offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_discover_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/discover";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Dedicated Discover server options
	 *
	 * REST: GET /order/cart/{cartId}/discover/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Dedicated Discover server you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_discover_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/discover/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Dedicated Discover server option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/discover/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Dedicated Discover server option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_discover_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/discover/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Desk As A Service offers
	 *
	 * REST: GET /order/cart/{cartId}/deskaas
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_deskaas_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/deskaas";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Desk as a service item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/deskaas
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Desk as a Service offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_deskaas_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/deskaas";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about a dedicated server for US Reseller
	 *
	 * REST: GET /order/cart/{cartId}/dedicatedReseller
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Filter the value of planCode property (=)
	 * @param family [required] Filter the value of family property (=)
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_dedicatedReseller_GET(String cartId, String family, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/dedicatedReseller";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "family", family);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new dedicated server item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/dedicatedReseller
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of a dedicated server offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_dedicatedReseller_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/dedicatedReseller";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about dedicated server options
	 *
	 * REST: GET /order/cart/{cartId}/dedicatedReseller/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of a dedicated server offer
	 * @param family [required] Filter the value of family property (=)
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_dedicatedReseller_options_GET(String cartId, String family, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/dedicatedReseller/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "family", family);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new dedicated server option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/dedicatedReseller/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a dedicated server offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_dedicatedReseller_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/dedicatedReseller/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about SaaS CSP2 offers
	 *
	 * REST: GET /order/cart/{cartId}/csp2
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_csp2_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/csp2";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new SaaS CSP2 offer item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/csp2
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of SaaS CSP2 offer (planCode)
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_csp2_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/csp2";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about SaaS CSP2 options
	 *
	 * REST: GET /order/cart/{cartId}/csp2/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of a SaaS CSP2 main offer
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_csp2_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/csp2/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new SaaS CSP2 option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/csp2/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a SaaS CSP2 offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_csp2_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/csp2/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Directadmin licenses offers
	 *
	 * REST: GET /order/cart/{cartId}/licenseDirectadmin
	 * @param cartId [required] Cart identifier
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_licenseDirectadmin_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/licenseDirectadmin";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Directadmin license item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/licenseDirectadmin
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Directadmin license offer
	 * @param duration [required] Duration selected for the rental of the product
	 * @param pricingMode [required] Pricing mode selected for the rental of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_licenseDirectadmin_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/licenseDirectadmin";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about VoIP offers
	 *
	 * REST: GET /order/cart/{cartId}/telephony
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_telephony_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/telephony";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new VoIP item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/telephony
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the VoIP offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_telephony_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/telephony";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about VoIP options
	 *
	 * REST: GET /order/cart/{cartId}/telephony/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the VoIP you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_telephony_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/telephony/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new VoIP option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/telephony/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a VoIP option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_telephony_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/telephony/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about PaaS Monitoring offers
	 *
	 * REST: GET /order/cart/{cartId}/paasmon
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_paasmon_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/paasmon";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new PaaS Monitoring item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/paasmon
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the PaaS Monitoring offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_paasmon_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/paasmon";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about cPanel licenses offers
	 *
	 * REST: GET /order/cart/{cartId}/licensecPanel
	 * @param cartId [required] Cart identifier
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_licensecPanel_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/licensecPanel";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new cPanel license item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/licensecPanel
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the cPanel license offer
	 * @param duration [required] Duration selected for the rental of the product
	 * @param pricingMode [required] Pricing mode selected for the rental of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_licensecPanel_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/licensecPanel";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about webHosting offers
	 *
	 * REST: GET /order/cart/{cartId}/webHosting
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhWebHostingProductInformation> cart_cartId_webHosting_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/webHosting";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t5);
	}
	private static TypeReference<ArrayList<OvhWebHostingProductInformation>> t5 = new TypeReference<ArrayList<OvhWebHostingProductInformation>>() {};

	/**
	 * Post a new webHosting item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/webHosting
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the webHosting offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_webHosting_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/webHosting";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about webHosting options
	 *
	 * REST: GET /order/cart/{cartId}/webHosting/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the webHosting you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_webHosting_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/webHosting/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new webHosting option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/webHosting/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a webHosting option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_webHosting_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/webHosting/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about NAS HA options
	 *
	 * REST: GET /order/cart/{cartId}/nasha/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the NAS HA you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_nasha_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/nasha/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new NAS HA option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/nasha/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a NAS HA option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_nasha_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/nasha/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about NAS HA offers
	 *
	 * REST: GET /order/cart/{cartId}/nasha
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_nasha_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/nasha";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new NAS HA item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/nasha
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the NAS HA offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_nasha_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/nasha";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get a summary of your current order
	 *
	 * REST: GET /order/cart/{cartId}/summary
	 * @param cartId [required] Cart identifier
	 */
	public OvhOrder cart_cartId_summary_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/summary";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get informations about OVHcloud Connect offers
	 *
	 * REST: GET /order/cart/{cartId}/vco
	 * @param cartId [required] Cart identifier
	 * @deprecated
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_vco_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/vco";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new OVHcloud Connect item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/vco
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the OVHcloud Connect offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 * @deprecated
	 */
	public OvhItem cart_cartId_vco_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/vco";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Logs offers
	 *
	 * REST: GET /order/cart/{cartId}/logs
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_logs_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/logs";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Logs item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/logs
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Logs offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_logs_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/logs";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Logs options
	 *
	 * REST: GET /order/cart/{cartId}/logs/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Logs you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_logs_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/logs/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Logs option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/logs/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Logs option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_logs_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/logs/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about vRack offers
	 *
	 * REST: GET /order/cart/{cartId}/vrackReseller
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_vrackReseller_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/vrackReseller";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new vRack item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/vrackReseller
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the vRack offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_vrackReseller_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/vrackReseller";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Microsoft options
	 *
	 * REST: GET /order/cart/{cartId}/microsoft/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of a Microsoft main offer
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_microsoft_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/microsoft/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Microsoft option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/microsoft/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Microsoft offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_microsoft_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/microsoft/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Microsoft offers
	 *
	 * REST: GET /order/cart/{cartId}/microsoft
	 * @param cartId [required] Cart identifier
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_microsoft_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/microsoft";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Microsoft offer item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/microsoft
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of Microsoft offer (planCode)
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_microsoft_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/microsoft";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about OVHcloud Connect offers
	 *
	 * REST: GET /order/cart/{cartId}/ovhCloudConnect
	 * @param cartId [required] Cart identifier
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_ovhCloudConnect_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/ovhCloudConnect";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new OVHcloud Connect item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/ovhCloudConnect
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the OVHcloud Connect offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_ovhCloudConnect_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/ovhCloudConnect";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about a domain name
	 *
	 * REST: GET /order/cart/{cartId}/domain
	 * @param cartId [required] Cart identifier
	 * @param domain [required] Domain name requested
	 *
	 * API beta
	 */
	public ArrayList<OvhProductInformation> cart_cartId_domain_GET(String cartId, String domain) throws IOException {
		String qPath = "/order/cart/{cartId}/domain";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "domain", domain);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t6);
	}
	private static TypeReference<ArrayList<OvhProductInformation>> t6 = new TypeReference<ArrayList<OvhProductInformation>>() {};

	/**
	 * Post a new domain in your cart
	 *
	 * REST: POST /order/cart/{cartId}/domain
	 * @param cartId [required] Cart identifier
	 * @param domain [required] Domain name to order
	 * @param offerId [required] Offer unique identifier
	 * @param quantity [required] Quantity to order
	 * @param duration [required] Duration for the product
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_domain_POST(String cartId, String domain, String duration, String offerId, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/domain";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "domain", domain);
		addBody(o, "duration", duration);
		addBody(o, "offerId", offerId);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about domain names options
	 *
	 * REST: GET /order/cart/{cartId}/domain/options
	 * @param cartId [required] Cart identifier
	 * @param domain [required] Domain name linked to the option
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_domain_options_GET(String cartId, String domain) throws IOException {
		String qPath = "/order/cart/{cartId}/domain/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "domain", domain);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new domain name option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/domain/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a domain name option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_domain_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/domain/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about DNS zone offer
	 *
	 * REST: GET /order/cart/{cartId}/dns
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_dns_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/dns";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new DNS zone item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/dns
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of a DNS zone offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_dns_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/dns";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Domain Restore
	 *
	 * REST: GET /order/cart/{cartId}/domainRestore
	 * @param cartId [required] Cart identifier
	 * @param domain [required] Domain name requested
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_domainRestore_GET(String cartId, String domain) throws IOException {
		String qPath = "/order/cart/{cartId}/domainRestore";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "domain", domain);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Get informations about Horizon View options
	 *
	 * REST: GET /order/cart/{cartId}/vdi/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Horizon View you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_vdi_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/vdi/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Horizon View option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/vdi/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Horizon View option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_vdi_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/vdi/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Horizon View offers
	 *
	 * REST: GET /order/cart/{cartId}/vdi
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_vdi_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/vdi";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Horizon View item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/vdi
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Horizon View offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_vdi_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/vdi";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about CloudLinux licenses offers
	 *
	 * REST: GET /order/cart/{cartId}/licenseCloudLinux
	 * @param cartId [required] Cart identifier
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_licenseCloudLinux_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/licenseCloudLinux";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new CloudLinux license item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/licenseCloudLinux
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the CloudLinux license offer
	 * @param duration [required] Duration selected for the rental of the product
	 * @param pricingMode [required] Pricing mode selected for the rental of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_licenseCloudLinux_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/licenseCloudLinux";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Exchange Enterprise offers
	 *
	 * REST: GET /order/cart/{cartId}/exchangeEnterprise
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_exchangeEnterprise_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/exchangeEnterprise";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Exchange Enterprise item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/exchangeEnterprise
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Exchange Enterprise offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_exchangeEnterprise_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/exchangeEnterprise";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Exchange Enterprise options
	 *
	 * REST: GET /order/cart/{cartId}/exchangeEnterprise/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Exchange Enterprise offer you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_exchangeEnterprise_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/exchangeEnterprise/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Exchange Enterprise option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/exchangeEnterprise/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item offer parent of the option
	 * @param planCode [required] Identifier of a Exchange Enterprise option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_exchangeEnterprise_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/exchangeEnterprise/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Private Cloud Reseller Enterprise options
	 *
	 * REST: GET /order/cart/{cartId}/privateCloudResellerEnterprise/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Private Cloud Reseller Enterprise you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_privateCloudResellerEnterprise_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudResellerEnterprise/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Private Cloud Reseller Enterprise option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/privateCloudResellerEnterprise/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Private Cloud Reseller Enterprise option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_privateCloudResellerEnterprise_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudResellerEnterprise/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Private Cloud Reseller Enterprise offers
	 *
	 * REST: GET /order/cart/{cartId}/privateCloudResellerEnterprise
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_privateCloudResellerEnterprise_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudResellerEnterprise";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Private Cloud Reseller Enterprise item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/privateCloudResellerEnterprise
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Private Cloud Reseller Enterprise offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_privateCloudResellerEnterprise_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudResellerEnterprise";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Veeam Enterprise offers
	 *
	 * REST: GET /order/cart/{cartId}/veeamEnterprise
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_veeamEnterprise_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/veeamEnterprise";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Veeam Enterprise item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/veeamEnterprise
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Veeam Enterprise offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_veeamEnterprise_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/veeamEnterprise";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Veeam Enterprise options
	 *
	 * REST: GET /order/cart/{cartId}/veeamEnterprise/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Veeam Enterprise you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_veeamEnterprise_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/veeamEnterprise/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Veeam Enterprise option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/veeamEnterprise/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Veeam Enterprise option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_veeamEnterprise_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/veeamEnterprise/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Private Cloud CDI options
	 *
	 * REST: GET /order/cart/{cartId}/privateCloudCDI/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Private Cloud CDI you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_privateCloudCDI_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudCDI/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Private Cloud CDI option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/privateCloudCDI/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Private Cloud CDI option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_privateCloudCDI_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudCDI/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Private Cloud CDI offers
	 *
	 * REST: GET /order/cart/{cartId}/privateCloudCDI
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_privateCloudCDI_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudCDI";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Private Cloud CDI item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/privateCloudCDI
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Private Cloud CDI offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_privateCloudCDI_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudCDI";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about xdsl options
	 *
	 * REST: GET /order/cart/{cartId}/xdsl/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the xdsl you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_xdsl_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/xdsl/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new xdsl option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/xdsl/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a xdsl option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_xdsl_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/xdsl/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about xdsl offers
	 *
	 * REST: GET /order/cart/{cartId}/xdsl
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_xdsl_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/xdsl";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new xdsl item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/xdsl
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the xdsl offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_xdsl_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/xdsl";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Cloud Web offers
	 *
	 * REST: GET /order/cart/{cartId}/cloudweb
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_cloudweb_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/cloudweb";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Cloud Web item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/cloudweb
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Cloud Web offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_cloudweb_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/cloudweb";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Cloud Web options
	 *
	 * REST: GET /order/cart/{cartId}/cloudweb/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Cloud Web you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_cloudweb_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/cloudweb/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Cloud Web option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/cloudweb/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Cloud Web option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_cloudweb_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/cloudweb/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Managed Services options
	 *
	 * REST: GET /order/cart/{cartId}/managedServices/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Managed Services you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_managedServices_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/managedServices/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Managed Services option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/managedServices/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Managed Services option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_managedServices_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/managedServices/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Managed Services offers
	 *
	 * REST: GET /order/cart/{cartId}/managedServices
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_managedServices_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/managedServices";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Managed Services item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/managedServices
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Managed Services offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_managedServices_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/managedServices";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about SMS offers
	 *
	 * REST: GET /order/cart/{cartId}/sms
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_sms_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/sms";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new SMS item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/sms
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the SMS offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_sms_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/sms";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Exchange options
	 *
	 * REST: GET /order/cart/{cartId}/exchange/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Exchange you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_exchange_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/exchange/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Exchange option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/exchange/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Exchange option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_exchange_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/exchange/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Exchange offers
	 *
	 * REST: GET /order/cart/{cartId}/exchange
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_exchange_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/exchange";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Exchange item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/exchange
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Exchange offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_exchange_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/exchange";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Ceph as a Service options
	 *
	 * REST: GET /order/cart/{cartId}/cephaas/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Ceph as a Service you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_cephaas_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/cephaas/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Ceph as a Service option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/cephaas/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Ceph as a Service option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_cephaas_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/cephaas/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Ceph as a Service offers
	 *
	 * REST: GET /order/cart/{cartId}/cephaas
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_cephaas_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/cephaas";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Ceph as a Service item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/cephaas
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Ceph as a Service offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_cephaas_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/cephaas";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Metrics options
	 *
	 * REST: GET /order/cart/{cartId}/metrics/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Metrics you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_metrics_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/metrics/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Metrics option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/metrics/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Metrics option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_metrics_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/metrics/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Metrics offers
	 *
	 * REST: GET /order/cart/{cartId}/metrics
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_metrics_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/metrics";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Metrics item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/metrics
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Metrics offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_metrics_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/metrics";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Retrieve information about a specific cart
	 *
	 * REST: GET /order/cart/{cartId}
	 * @param cartId [required] Cart identifier
	 */
	public OvhCart cart_cartId_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhCart.class);
	}

	/**
	 * Modify information about a specific cart
	 *
	 * REST: PUT /order/cart/{cartId}
	 * @param cartId [required] Cart identifier
	 * @param description [required] Description of your cart
	 * @param expire [required] Time of expiration of the cart
	 */
	public OvhCart cart_cartId_PUT(String cartId, String description, Date expire) throws IOException {
		String qPath = "/order/cart/{cartId}";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "description", description);
		addBody(o, "expire", expire);
		String resp = execN(qPath, "PUT", sb.toString(), o);
		return convertTo(resp, OvhCart.class);
	}

	/**
	 * Delete a cart
	 *
	 * REST: DELETE /order/cart/{cartId}
	 * @param cartId [required] Cart identifier
	 */
	public void cart_cartId_DELETE(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}";
		StringBuilder sb = path(qPath, cartId);
		exec(qPath, "DELETE", sb.toString(), null);
	}

	/**
	 * Get informations about Private Cloud SDDC offers
	 *
	 * REST: GET /order/cart/{cartId}/privateCloudSDDC
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_privateCloudSDDC_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudSDDC";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Private Cloud SDDC item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/privateCloudSDDC
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Private Cloud SDDC offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_privateCloudSDDC_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudSDDC";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Private Cloud SDDC options
	 *
	 * REST: GET /order/cart/{cartId}/privateCloudSDDC/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Private Cloud SDDC you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_privateCloudSDDC_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudSDDC/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Private Cloud SDDC option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/privateCloudSDDC/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Private Cloud SDDC option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_privateCloudSDDC_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudSDDC/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about SSL Gateway options
	 *
	 * REST: GET /order/cart/{cartId}/sslGateway/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the SSL Gateway you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_sslGateway_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/sslGateway/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new SSL Gateway option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/sslGateway/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a SSL Gateway option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_sslGateway_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/sslGateway/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about SSL Gateway offers
	 *
	 * REST: GET /order/cart/{cartId}/sslGateway
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_sslGateway_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/sslGateway";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new SSL Gateway item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/sslGateway
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the SSL Gateway offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_sslGateway_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/sslGateway";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about vRack offers
	 *
	 * REST: GET /order/cart/{cartId}/vrack
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_vrack_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/vrack";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new vRack item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/vrack
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the vRack offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_vrack_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/vrack";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Private Cloud Reseller offers
	 *
	 * REST: GET /order/cart/{cartId}/privateCloudReseller
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_privateCloudReseller_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudReseller";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Private Cloud Reseller item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/privateCloudReseller
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Private Cloud Reseller offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_privateCloudReseller_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudReseller";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Private Cloud Reseller options
	 *
	 * REST: GET /order/cart/{cartId}/privateCloudReseller/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Private Cloud Reseller you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_privateCloudReseller_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudReseller/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Private Cloud Reseller option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/privateCloudReseller/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Private Cloud Reseller option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_privateCloudReseller_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/privateCloudReseller/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about VPS offers
	 *
	 * REST: GET /order/cart/{cartId}/vps
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_vps_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/vps";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new VPS item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/vps
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the VPS offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_vps_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/vps";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about VPS options
	 *
	 * REST: GET /order/cart/{cartId}/vps/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the VPS you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_vps_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/vps/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new VPS option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/vps/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a VPS option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_vps_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/vps/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about SSL Comodo offers
	 *
	 * REST: GET /order/cart/{cartId}/sslComodo
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_sslComodo_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/sslComodo";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new SSL Comodo item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/sslComodo
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the SSL Comodo offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_sslComodo_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/sslComodo";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about SSL Comodo options
	 *
	 * REST: GET /order/cart/{cartId}/sslComodo/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the SSL Comodo you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_sslComodo_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/sslComodo/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new SSL Comodo option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/sslComodo/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a SSL Comodo option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_sslComodo_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/sslComodo/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Sharepoint options
	 *
	 * REST: GET /order/cart/{cartId}/sharepoint/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of a Sharepoint main offer
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_sharepoint_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/sharepoint/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Sharepoint option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/sharepoint/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Sharepoint offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_sharepoint_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/sharepoint/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Sharepoint offers
	 *
	 * REST: GET /order/cart/{cartId}/sharepoint
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_sharepoint_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/sharepoint";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Sharepoint offer item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/sharepoint
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of Sharepoint offer (planCode)
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_sharepoint_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/sharepoint";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Retrieve coupons associated to cart
	 *
	 * REST: GET /order/cart/{cartId}/coupon
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<String> cart_cartId_coupon_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/coupon";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Add a new coupon to cart
	 *
	 * REST: POST /order/cart/{cartId}/coupon
	 * @param cartId [required] Cart identifier
	 * @param coupon [required] Coupon identifier
	 */
	public ArrayList<String> cart_cartId_coupon_POST(String cartId, String coupon) throws IOException {
		String qPath = "/order/cart/{cartId}/coupon";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "coupon", coupon);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, t1);
	}

	/**
	 * Delete a coupon from cart
	 *
	 * REST: DELETE /order/cart/{cartId}/coupon
	 * @param cartId [required] Cart identifier
	 * @param coupon [required] Coupon identifier
	 */
	public void cart_cartId_coupon_DELETE(String cartId, String coupon) throws IOException {
		String qPath = "/order/cart/{cartId}/coupon";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "coupon", coupon);
		execN(qPath, "DELETE", sb.toString(), null);
	}

	/**
	 * Get informations about Kubernetes options
	 *
	 * REST: GET /order/cart/{cartId}/kubernetes/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Kubernetes you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_kubernetes_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/kubernetes/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Kubernetes option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/kubernetes/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Kubernetes option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_kubernetes_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/kubernetes/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Kubernetes offers
	 *
	 * REST: GET /order/cart/{cartId}/kubernetes
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_kubernetes_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/kubernetes";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Kubernetes item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/kubernetes
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Kubernetes offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_kubernetes_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/kubernetes";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Retrieve all configuration item of the cart item
	 *
	 * REST: GET /order/cart/{cartId}/item/{itemId}/configuration
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Product item identifier
	 * @param label [required] Filter the value of label property (=)
	 */
	public ArrayList<Long> cart_cartId_item_itemId_configuration_GET(String cartId, Long itemId, String label) throws IOException {
		String qPath = "/order/cart/{cartId}/item/{itemId}/configuration";
		StringBuilder sb = path(qPath, cartId, itemId);
		query(sb, "label", label);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t7);
	}
	private static TypeReference<ArrayList<Long>> t7 = new TypeReference<ArrayList<Long>>() {};

	/**
	 * Setup configuration item for the product
	 *
	 * REST: POST /order/cart/{cartId}/item/{itemId}/configuration
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Product item identifier
	 * @param label [required] Label for your configuration item
	 * @param value [required] Value or resource URL on API.OVH.COM of your configuration item
	 */
	public OvhConfigurationItem cart_cartId_item_itemId_configuration_POST(String cartId, Long itemId, String label, String value) throws IOException {
		String qPath = "/order/cart/{cartId}/item/{itemId}/configuration";
		StringBuilder sb = path(qPath, cartId, itemId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "label", label);
		addBody(o, "value", value);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhConfigurationItem.class);
	}

	/**
	 * Retrieve configuration item
	 *
	 * REST: GET /order/cart/{cartId}/item/{itemId}/configuration/{configurationId}
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Product item identifier
	 * @param configurationId [required] Configuration item identifier
	 */
	public OvhConfigurationItem cart_cartId_item_itemId_configuration_configurationId_GET(String cartId, Long itemId, Long configurationId) throws IOException {
		String qPath = "/order/cart/{cartId}/item/{itemId}/configuration/{configurationId}";
		StringBuilder sb = path(qPath, cartId, itemId, configurationId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhConfigurationItem.class);
	}

	/**
	 * Delete configuration item
	 *
	 * REST: DELETE /order/cart/{cartId}/item/{itemId}/configuration/{configurationId}
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Product item identifier
	 * @param configurationId [required] Configuration item identifier
	 */
	public void cart_cartId_item_itemId_configuration_configurationId_DELETE(String cartId, Long itemId, Long configurationId) throws IOException {
		String qPath = "/order/cart/{cartId}/item/{itemId}/configuration/{configurationId}";
		StringBuilder sb = path(qPath, cartId, itemId, configurationId);
		execN(qPath, "DELETE", sb.toString(), null);
	}

	/**
	 * Retrieve information about a specific item of a cart
	 *
	 * REST: GET /order/cart/{cartId}/item/{itemId}
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Product item identifier
	 */
	public OvhItem cart_cartId_item_itemId_GET(String cartId, Long itemId) throws IOException {
		String qPath = "/order/cart/{cartId}/item/{itemId}";
		StringBuilder sb = path(qPath, cartId, itemId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Update some values on a cart item
	 *
	 * REST: PUT /order/cart/{cartId}/item/{itemId}
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Product item identifier
	 * @param quantity [required] New quantity for item
	 * @param duration [required] New duration for item
	 */
	public OvhItem cart_cartId_item_itemId_PUT(String cartId, Long itemId, String duration, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/item/{itemId}";
		StringBuilder sb = path(qPath, cartId, itemId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "PUT", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Delete an item from a cart
	 *
	 * REST: DELETE /order/cart/{cartId}/item/{itemId}
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Product item identifier
	 */
	public void cart_cartId_item_itemId_DELETE(String cartId, Long itemId) throws IOException {
		String qPath = "/order/cart/{cartId}/item/{itemId}";
		StringBuilder sb = path(qPath, cartId, itemId);
		execN(qPath, "DELETE", sb.toString(), null);
	}

	/**
	 * Retrieve all required configuration item of the cart item
	 *
	 * REST: GET /order/cart/{cartId}/item/{itemId}/requiredConfiguration
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Product item identifier
	 */
	public ArrayList<OvhConfigurationRequirements> cart_cartId_item_itemId_requiredConfiguration_GET(String cartId, Long itemId) throws IOException {
		String qPath = "/order/cart/{cartId}/item/{itemId}/requiredConfiguration";
		StringBuilder sb = path(qPath, cartId, itemId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t8);
	}
	private static TypeReference<ArrayList<OvhConfigurationRequirements>> t8 = new TypeReference<ArrayList<OvhConfigurationRequirements>>() {};

	/**
	 * List all the items of a cart
	 *
	 * REST: GET /order/cart/{cartId}/item
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<Long> cart_cartId_item_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/item";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t7);
	}

	/**
	 * Get informations about a dedicated server
	 *
	 * REST: GET /order/cart/{cartId}/dedicated
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Filter the value of planCode property (=)
	 * @param family [required] Filter the value of family property (=)
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_dedicated_GET(String cartId, String family, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/dedicated";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "family", family);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new dedicated server item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/dedicated
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of a dedicated server offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_dedicated_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/dedicated";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about dedicated server options
	 *
	 * REST: GET /order/cart/{cartId}/dedicated/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of a dedicated server offer
	 * @param family [required] Filter the value of family property (=)
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_dedicated_options_GET(String cartId, String family, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/dedicated/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "family", family);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new dedicated server option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/dedicated/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a dedicated server offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_dedicated_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/dedicated/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about IP Load-Balancing offers
	 *
	 * REST: GET /order/cart/{cartId}/ipLoadbalancing
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_ipLoadbalancing_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/ipLoadbalancing";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new IP Load-Balancing item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/ipLoadbalancing
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the IP Load-Balancing offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_ipLoadbalancing_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/ipLoadbalancing";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about IP Load-Balancing options
	 *
	 * REST: GET /order/cart/{cartId}/ipLoadbalancing/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the IP Load-Balancing you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_ipLoadbalancing_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/ipLoadbalancing/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new IP Load-Balancing option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/ipLoadbalancing/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a IP Load-Balancing option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_ipLoadbalancing_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/ipLoadbalancing/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Public Cloud offers
	 *
	 * REST: GET /order/cart/{cartId}/cloud
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_cloud_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/cloud";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Public Cloud item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/cloud
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Public Cloud offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_cloud_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/cloud";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Public Cloud options
	 *
	 * REST: GET /order/cart/{cartId}/cloud/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Public Cloud you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_cloud_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/cloud/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Public Cloud option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/cloud/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Public Cloud option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_cloud_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/cloud/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about a baremetal server
	 *
	 * REST: GET /order/cart/{cartId}/baremetalServers
	 * @param cartId [required] Cart identifier
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_baremetalServers_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/baremetalServers";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new baremetal server item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/baremetalServers
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of a baremetal server offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_baremetalServers_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/baremetalServers";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about baremetal server options
	 *
	 * REST: GET /order/cart/{cartId}/baremetalServers/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of a baremetal server offer
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_baremetalServers_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/baremetalServers/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new baremetal server option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/baremetalServers/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a baremetal server offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_baremetalServers_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/baremetalServers/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Over The Box options
	 *
	 * REST: GET /order/cart/{cartId}/otb/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Over The Box you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_otb_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/otb/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Over The Box option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/otb/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Over The Box option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_otb_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/otb/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Over The Box offers
	 *
	 * REST: GET /order/cart/{cartId}/otb
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_otb_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/otb";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Over The Box item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/otb
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Over The Box offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_otb_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/otb";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get prices and contracts information for your cart
	 *
	 * REST: GET /order/cart/{cartId}/checkout
	 * @param cartId [required] Cart identifier
	 */
	public OvhOrder cart_cartId_checkout_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/checkout";
		StringBuilder sb = path(qPath, cartId);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Validate your shopping and create order
	 *
	 * REST: POST /order/cart/{cartId}/checkout
	 * @param cartId [required] Cart identifier
	 * @param autoPayWithPreferredPaymentMethod [required] Indicates that order will be automatically paid with preferred payment method
	 * @param waiveRetractationPeriod [required] Indicates that order will be processed with waiving retractation period
	 */
	public OvhOrder cart_cartId_checkout_POST(String cartId, Boolean autoPayWithPreferredPaymentMethod, Boolean waiveRetractationPeriod) throws IOException {
		String qPath = "/order/cart/{cartId}/checkout";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "autoPayWithPreferredPaymentMethod", autoPayWithPreferredPaymentMethod);
		addBody(o, "waiveRetractationPeriod", waiveRetractationPeriod);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get informations about Veeam Cloud Connect offers
	 *
	 * REST: GET /order/cart/{cartId}/veeamcc
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_veeamcc_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/veeamcc";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Veeam Cloud Connect item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/veeamcc
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Veeam Cloud Connect offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_veeamcc_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/veeamcc";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Veeam Cloud Connect options
	 *
	 * REST: GET /order/cart/{cartId}/veeamcc/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Veeam Cloud Connect you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_veeamcc_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/veeamcc/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Veeam Cloud Connect option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/veeamcc/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Veeam Cloud Connect option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_veeamcc_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/veeamcc/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Assign a shopping cart to an loggedin client
	 *
	 * REST: POST /order/cart/{cartId}/assign
	 * @param cartId [required] Cart identifier
	 */
	public void cart_cartId_assign_POST(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/assign";
		StringBuilder sb = path(qPath, cartId);
		exec(qPath, "POST", sb.toString(), null);
	}

	/**
	 * Get informations about dedicated labs server options
	 *
	 * REST: GET /order/cart/{cartId}/dedicatedLabs/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of a dedicated labs server offer
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_dedicatedLabs_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/dedicatedLabs/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new dedicated labs server option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/dedicatedLabs/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a dedicated labs server offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_dedicatedLabs_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/dedicatedLabs/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about a dedicated labs server
	 *
	 * REST: GET /order/cart/{cartId}/dedicatedLabs
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Filter the value of planCode property (=)
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_dedicatedLabs_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/dedicatedLabs";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new dedicated labs server item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/dedicatedLabs
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of a dedicated labs server offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_dedicatedLabs_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/dedicatedLabs";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Worklight licenses offers
	 *
	 * REST: GET /order/cart/{cartId}/licenseWorklight
	 * @param cartId [required] Cart identifier
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_licenseWorklight_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/licenseWorklight";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Worklight license item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/licenseWorklight
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Worklight license offer
	 * @param duration [required] Duration selected for the rental of the product
	 * @param pricingMode [required] Pricing mode selected for the rental of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_licenseWorklight_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/licenseWorklight";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Office 365 licenses
	 *
	 * REST: GET /order/cart/{cartId}/office365
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_office365_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/office365";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Office 365 item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/office365
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Office365 license
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_office365_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/office365";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Office 365 options
	 *
	 * REST: GET /order/cart/{cartId}/office365/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of a Office 365 main offer
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_office365_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/office365/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Office 365 option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/office365/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Office 365 offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_office365_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/office365/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Plesk license options
	 *
	 * REST: GET /order/cart/{cartId}/licensePlesk/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Plesk license you want to consult options
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_licensePlesk_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/licensePlesk/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new Plesk license option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/licensePlesk/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a Plesk license option offer
	 * @param duration [required] Duration selected for the product
	 * @param pricingMode [required] Pricing mode selected for the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_licensePlesk_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/licensePlesk/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Plesk licenses offers
	 *
	 * REST: GET /order/cart/{cartId}/licensePlesk
	 * @param cartId [required] Cart identifier
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_licensePlesk_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/licensePlesk";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Plesk license item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/licensePlesk
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Plesk license offer
	 * @param duration [required] Duration selected for the rental of the product
	 * @param pricingMode [required] Pricing mode selected for the rental of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_licensePlesk_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/licensePlesk";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about domain names transfer options
	 *
	 * REST: GET /order/cart/{cartId}/domainTransfer/options
	 * @param cartId [required] Cart identifier
	 * @param domain [required] Domain name linked to the option
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_domainTransfer_options_GET(String cartId, String domain) throws IOException {
		String qPath = "/order/cart/{cartId}/domainTransfer/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "domain", domain);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new domain name transfer option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/domainTransfer/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a domain name option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_domainTransfer_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/domainTransfer/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about a domain name transfer
	 *
	 * REST: GET /order/cart/{cartId}/domainTransfer
	 * @param cartId [required] Cart identifier
	 * @param domain [required] Domain name requested
	 *
	 * API beta
	 */
	public ArrayList<OvhProductInformation> cart_cartId_domainTransfer_GET(String cartId, String domain) throws IOException {
		String qPath = "/order/cart/{cartId}/domainTransfer";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "domain", domain);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t6);
	}

	/**
	 * Post a new domain tranfer in your cart
	 *
	 * REST: POST /order/cart/{cartId}/domainTransfer
	 * @param cartId [required] Cart identifier
	 * @param domain [required] Domain name to order
	 * @param offerId [required] Offer unique identifier
	 * @param quantity [required] Quantity to order
	 * @param duration [required] Duration for the product
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_domainTransfer_POST(String cartId, String domain, String duration, String offerId, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/domainTransfer";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "domain", domain);
		addBody(o, "duration", duration);
		addBody(o, "offerId", offerId);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Hosting Reseller offers
	 *
	 * REST: GET /order/cart/{cartId}/hostingReseller
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_hostingReseller_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/hostingReseller";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Hosting Reseller item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/hostingReseller
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Hosting Reseller offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_hostingReseller_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/hostingReseller";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about EmailPro offers
	 *
	 * REST: GET /order/cart/{cartId}/emailpro
	 * @param cartId [required] Cart identifier
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_emailpro_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/emailpro";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new EmailPro item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/emailpro
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the EmailPro offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_emailpro_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/emailpro";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about EmailPro options
	 *
	 * REST: GET /order/cart/{cartId}/emailpro/options
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the EmailPro you want to consult options
	 */
	public ArrayList<OvhGenericOptionDefinition> cart_cartId_emailpro_options_GET(String cartId, String planCode) throws IOException {
		String qPath = "/order/cart/{cartId}/emailpro/options";
		StringBuilder sb = path(qPath, cartId);
		query(sb, "planCode", planCode);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Post a new EmailPro option in your cart
	 *
	 * REST: POST /order/cart/{cartId}/emailpro/options
	 * @param cartId [required] Cart identifier
	 * @param itemId [required] Cart item to be linked
	 * @param planCode [required] Identifier of a EmailPro option offer
	 * @param duration [required] Duration selected for the purchase of the product
	 * @param pricingMode [required] Pricing mode selected for the purchase of the product
	 * @param quantity [required] Quantity of product desired
	 */
	public OvhItem cart_cartId_emailpro_options_POST(String cartId, String duration, Long itemId, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/emailpro/options";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "itemId", itemId);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * Get informations about Virtuozzo licenses offers
	 *
	 * REST: GET /order/cart/{cartId}/licenseVirtuozzo
	 * @param cartId [required] Cart identifier
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> cart_cartId_licenseVirtuozzo_GET(String cartId) throws IOException {
		String qPath = "/order/cart/{cartId}/licenseVirtuozzo";
		StringBuilder sb = path(qPath, cartId);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Post a new Virtuozzo license item in your cart
	 *
	 * REST: POST /order/cart/{cartId}/licenseVirtuozzo
	 * @param cartId [required] Cart identifier
	 * @param planCode [required] Identifier of the Virtuozzo license offer
	 * @param duration [required] Duration selected for the rental of the product
	 * @param pricingMode [required] Pricing mode selected for the rental of the product
	 * @param quantity [required] Quantity of product desired
	 *
	 * API beta
	 */
	public OvhItem cart_cartId_licenseVirtuozzo_POST(String cartId, String duration, String planCode, String pricingMode, Long quantity) throws IOException {
		String qPath = "/order/cart/{cartId}/licenseVirtuozzo";
		StringBuilder sb = path(qPath, cartId);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "duration", duration);
		addBody(o, "planCode", planCode);
		addBody(o, "pricingMode", pricingMode);
		addBody(o, "quantity", quantity);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhItem.class);
	}

	/**
	 * List of your OVH order carts
	 *
	 * REST: GET /order/cart
	 * @param description [required] Filter the value of description property (=)
	 */
	public ArrayList<String> cart_GET(String description) throws IOException {
		String qPath = "/order/cart";
		StringBuilder sb = path(qPath);
		query(sb, "description", description);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Create a new OVH order cart
	 *
	 * REST: POST /order/cart
	 * @param description [required] Description of your cart
	 * @param expire [required] Time of expiration of the cart
	 * @param ovhSubsidiary [required] OVH Subsidiary where you want to order
	 */
	public OvhCart cart_POST(String description, Date expire, OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/cart";
		StringBuilder sb = path(qPath);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "description", description);
		addBody(o, "expire", expire);
		addBody(o, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhCart.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/cloud/project
	 */
	public ArrayList<String> cloud_project_GET() throws IOException {
		String qPath = "/order/cloud/project";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/cloud/project/{serviceName}/credit
	 * @param amount [required] Amount to add in your cloud credit
	 * @param serviceName [required] The project id
	 */
	public OvhOrder cloud_project_serviceName_credit_GET(String serviceName, Long amount) throws IOException {
		String qPath = "/order/cloud/project/{serviceName}/credit";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "amount", amount);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/cloud/project/{serviceName}/credit
	 * @param amount [required] Amount to add in your cloud credit
	 * @param serviceName [required] The project id
	 */
	public OvhOrder cloud_project_serviceName_credit_POST(String serviceName, Long amount) throws IOException {
		String qPath = "/order/cloud/project/{serviceName}/credit";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "amount", amount);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/cloud/project/{serviceName}
	 * @param serviceName [required] The project id
	 */
	public ArrayList<String> cloud_project_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/cloud/project/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/cloud/project/{serviceName}/ip
	 * @param quantity [required] Number of failover ip
	 * @param country [required] IP geolocation
	 * @param instanceId [required] Instance id where ip will be routed to
	 * @param serviceName [required] The project id
	 */
	public OvhOrder cloud_project_serviceName_ip_GET(String serviceName, OvhGeolocationEnum country, String instanceId, Long quantity) throws IOException {
		String qPath = "/order/cloud/project/{serviceName}/ip";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "country", country);
		query(sb, "instanceId", instanceId);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/cloud/project/{serviceName}/ip
	 * @param quantity [required] Number of failover ip
	 * @param country [required] IP geolocation
	 * @param instanceId [required] Instance id where ip will be routed to
	 * @param serviceName [required] The project id
	 */
	public OvhOrder cloud_project_serviceName_ip_POST(String serviceName, OvhGeolocationEnum country, String instanceId, Long quantity) throws IOException {
		String qPath = "/order/cloud/project/{serviceName}/ip";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "country", country);
		addBody(o, "instanceId", instanceId);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/sms
	 */
	public ArrayList<String> sms_GET() throws IOException {
		String qPath = "/order/sms";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/sms/{serviceName}/credits
	 * @param quantity [required] Sms credit quantity
	 * @param serviceName [required] The internal name of your SMS offer
	 */
	public OvhOrder sms_serviceName_credits_GET(String serviceName, Long quantity) throws IOException {
		String qPath = "/order/sms/{serviceName}/credits";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/sms/{serviceName}/credits
	 * @param quantity [required] Sms credit quantity
	 * @param serviceName [required] The internal name of your SMS offer
	 */
	public OvhOrder sms_serviceName_credits_POST(String serviceName, Long quantity) throws IOException {
		String qPath = "/order/sms/{serviceName}/credits";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/sms/{serviceName}
	 * @param serviceName [required] The internal name of your SMS offer
	 */
	public ArrayList<String> sms_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/sms/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/sms/new
	 * @param quantity [required] Sms credit quantity
	 */
	public OvhOrder sms_new_GET(Long quantity) throws IOException {
		String qPath = "/order/sms/new";
		StringBuilder sb = path(qPath);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/sms/new
	 * @param quantity [required] Sms credit quantity
	 */
	public OvhOrder sms_new_POST(Long quantity) throws IOException {
		String qPath = "/order/sms/new";
		StringBuilder sb = path(qPath);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/dedicated/housing
	 */
	public ArrayList<String> dedicated_housing_GET() throws IOException {
		String qPath = "/order/dedicated/housing";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'APC' option
	 *
	 * REST: GET /order/dedicated/housing/{serviceName}/APC
	 * @param serviceName [required] The internal name of your Housing bay
	 */
	public ArrayList<String> dedicated_housing_serviceName_APC_GET(String serviceName) throws IOException {
		String qPath = "/order/dedicated/housing/{serviceName}/APC";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicated/housing/{serviceName}/APC/{duration}
	 * @param serviceName [required] The internal name of your Housing bay
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_housing_serviceName_APC_duration_GET(String serviceName, String duration) throws IOException {
		String qPath = "/order/dedicated/housing/{serviceName}/APC/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicated/housing/{serviceName}/APC/{duration}
	 * @param serviceName [required] The internal name of your Housing bay
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_housing_serviceName_APC_duration_POST(String serviceName, String duration) throws IOException {
		String qPath = "/order/dedicated/housing/{serviceName}/APC/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "POST", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/dedicated/housing/{serviceName}
	 * @param serviceName [required] The internal name of your Housing bay
	 */
	public ArrayList<String> dedicated_housing_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/dedicated/housing/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicated/nasha/new/{duration}
	 * @param datacenter [required] Nas HA localization
	 * @param model [required] Capacity of Nas HA offer
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_nasha_new_duration_GET(String duration, OvhNasHAZoneEnum datacenter, OvhNasHAOfferEnum model) throws IOException {
		String qPath = "/order/dedicated/nasha/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		query(sb, "datacenter", datacenter);
		query(sb, "model", model);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicated/nasha/new/{duration}
	 * @param datacenter [required] Nas HA localization
	 * @param model [required] Capacity of Nas HA offer
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_nasha_new_duration_POST(String duration, OvhNasHAZoneEnum datacenter, OvhNasHAOfferEnum model) throws IOException {
		String qPath = "/order/dedicated/nasha/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "datacenter", datacenter);
		addBody(o, "model", model);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'new' option
	 *
	 * REST: GET /order/dedicated/nasha/new
	 * @param datacenter [required] Nas HA localization
	 * @param model [required] Capacity of Nas HA offer
	 */
	public ArrayList<String> dedicated_nasha_new_GET(OvhNasHAZoneEnum datacenter, OvhNasHAOfferEnum model) throws IOException {
		String qPath = "/order/dedicated/nasha/new";
		StringBuilder sb = path(qPath);
		query(sb, "datacenter", datacenter);
		query(sb, "model", model);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/dedicated/server
	 */
	public ArrayList<String> dedicated_server_GET() throws IOException {
		String qPath = "/order/dedicated/server";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/firewall/{duration}
	 * @param firewallModel [required] Firewall type
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_firewall_duration_GET(String serviceName, String duration, OvhFirewallModelEnum firewallModel) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/firewall/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "firewallModel", firewallModel);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicated/server/{serviceName}/firewall/{duration}
	 * @param firewallModel [required] Firewall type
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_firewall_duration_POST(String serviceName, String duration, OvhFirewallModelEnum firewallModel) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/firewall/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "firewallModel", firewallModel);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'firewall' option
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/firewall
	 * @param firewallModel [required] Firewall type
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> dedicated_server_serviceName_firewall_GET(String serviceName, OvhFirewallModelEnum firewallModel) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/firewall";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "firewallModel", firewallModel);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'usbKey' option
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/usbKey
	 * @param capacity [required] Capacity in gigabytes
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> dedicated_server_serviceName_usbKey_GET(String serviceName, OvhUsbKeyCapacityEnum capacity) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/usbKey";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "capacity", capacity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/usbKey/{duration}
	 * @param capacity [required] Capacity in gigabytes
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_usbKey_duration_GET(String serviceName, String duration, OvhUsbKeyCapacityEnum capacity) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/usbKey/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "capacity", capacity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicated/server/{serviceName}/usbKey/{duration}
	 * @param capacity [required] Capacity in gigabytes
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_usbKey_duration_POST(String serviceName, String duration, OvhUsbKeyCapacityEnum capacity) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/usbKey/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "capacity", capacity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/kvm/{duration}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_kvm_duration_GET(String serviceName, String duration) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/kvm/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicated/server/{serviceName}/kvm/{duration}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_kvm_duration_POST(String serviceName, String duration) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/kvm/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "POST", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'kvm' option
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/kvm
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> dedicated_server_serviceName_kvm_GET(String serviceName) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/kvm";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'traffic' option
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/traffic
	 * @param traffic [required] amount of traffic to allocate
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> dedicated_server_serviceName_traffic_GET(String serviceName, OvhTrafficOrderEnum traffic) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/traffic";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "traffic", traffic);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/traffic/{duration}
	 * @param traffic [required] amount of traffic to allocate
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_traffic_duration_GET(String serviceName, String duration, OvhTrafficOrderEnum traffic) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/traffic/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "traffic", traffic);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicated/server/{serviceName}/traffic/{duration}
	 * @param traffic [required] amount of traffic to allocate
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_traffic_duration_POST(String serviceName, String duration, OvhTrafficOrderEnum traffic) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/traffic/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "traffic", traffic);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'feature' option
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/feature
	 * @param feature [required] the feature
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> dedicated_server_serviceName_feature_GET(String serviceName, OvhOrderableSysFeatureEnum feature) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/feature";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "feature", feature);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/feature/{duration}
	 * @param feature [required] the feature
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_feature_duration_GET(String serviceName, String duration, OvhOrderableSysFeatureEnum feature) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/feature/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "feature", feature);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicated/server/{serviceName}/feature/{duration}
	 * @param feature [required] the feature
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_feature_duration_POST(String serviceName, String duration, OvhOrderableSysFeatureEnum feature) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/feature/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "feature", feature);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'kvmExpress' option
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/kvmExpress
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> dedicated_server_serviceName_kvmExpress_GET(String serviceName) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/kvmExpress";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/kvmExpress/{duration}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_kvmExpress_duration_GET(String serviceName, String duration) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/kvmExpress/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicated/server/{serviceName}/kvmExpress/{duration}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_kvmExpress_duration_POST(String serviceName, String duration) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/kvmExpress/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "POST", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'ipMigration' option
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/ipMigration
	 * @param ip [required] The IP to move to this server
	 * @param token [required] IP migration token
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> dedicated_server_serviceName_ipMigration_GET(String serviceName, String ip, String token) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/ipMigration";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "ip", ip);
		query(sb, "token", token);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/ipMigration/{duration}
	 * @param ip [required] The IP to move to this server
	 * @param token [required] IP migration token
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_ipMigration_duration_GET(String serviceName, String duration, String ip, String token) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/ipMigration/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "ip", ip);
		query(sb, "token", token);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicated/server/{serviceName}/ipMigration/{duration}
	 * @param ip [required] The IP to move to this server
	 * @param token [required] IP migration token
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_ipMigration_duration_POST(String serviceName, String duration, String ip, String token) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/ipMigration/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "ip", ip);
		addBody(o, "token", token);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'backupStorage' option
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/backupStorage
	 * @param capacity [required] The capacity in gigabytes of your backup storage
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> dedicated_server_serviceName_backupStorage_GET(String serviceName, OvhBackupStorageCapacityEnum capacity) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/backupStorage";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "capacity", capacity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/backupStorage/{duration}
	 * @param capacity [required] The capacity in gigabytes of your backup storage
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_backupStorage_duration_GET(String serviceName, String duration, OvhBackupStorageCapacityEnum capacity) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/backupStorage/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "capacity", capacity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicated/server/{serviceName}/backupStorage/{duration}
	 * @param capacity [required] The capacity in gigabytes of your backup storage
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_backupStorage_duration_POST(String serviceName, String duration, OvhBackupStorageCapacityEnum capacity) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/backupStorage/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "capacity", capacity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/ip/{duration}
	 * @param type [required] The type of IP
	 * @param organisationId [required] Your organisation id to add on block informations
	 * @param blockSize [required] IP block size
	 * @param country [required] IP localization
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_ip_duration_GET(String serviceName, String duration, OvhIpBlockSizeEnum blockSize, OvhIpCountryEnum country, String organisationId, OvhIpTypeOrderableEnum type) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/ip/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "blockSize", blockSize);
		query(sb, "country", country);
		query(sb, "organisationId", organisationId);
		query(sb, "type", type);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicated/server/{serviceName}/ip/{duration}
	 * @param type [required] The type of IP
	 * @param organisationId [required] Your organisation id to add on block informations
	 * @param blockSize [required] IP block size
	 * @param country [required] IP localization
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_ip_duration_POST(String serviceName, String duration, OvhIpBlockSizeEnum blockSize, OvhIpCountryEnum country, String organisationId, OvhIpTypeOrderableEnum type) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/ip/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "blockSize", blockSize);
		addBody(o, "country", country);
		addBody(o, "organisationId", organisationId);
		addBody(o, "type", type);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'ip' option
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/ip
	 * @param type [required] The type of IP
	 * @param organisationId [required] Your organisation id to add on block informations
	 * @param blockSize [required] IP block size
	 * @param country [required] IP localization
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> dedicated_server_serviceName_ip_GET(String serviceName, OvhIpBlockSizeEnum blockSize, OvhIpCountryEnum country, String organisationId, OvhIpTypeOrderableEnum type) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/ip";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "blockSize", blockSize);
		query(sb, "country", country);
		query(sb, "organisationId", organisationId);
		query(sb, "type", type);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/staticIP/{duration}
	 * @param country [required] Ip localization
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_staticIP_duration_GET(String serviceName, String duration, OvhIpStaticCountryEnum country) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/staticIP/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "country", country);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicated/server/{serviceName}/staticIP/{duration}
	 * @param country [required] Ip localization
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_staticIP_duration_POST(String serviceName, String duration, OvhIpStaticCountryEnum country) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/staticIP/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "country", country);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'staticIP' option
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/staticIP
	 * @param country [required] Ip localization
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> dedicated_server_serviceName_staticIP_GET(String serviceName, OvhIpStaticCountryEnum country) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/staticIP";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "country", country);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/failoverIP/{duration}
	 * @param country [required] Ip localization
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_failoverIP_duration_GET(String serviceName, String duration, OvhIpCountryEnum country) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/failoverIP/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "country", country);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicated/server/{serviceName}/failoverIP/{duration}
	 * @param country [required] Ip localization
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_failoverIP_duration_POST(String serviceName, String duration, OvhIpCountryEnum country) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/failoverIP/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "country", country);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'failoverIP' option
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/failoverIP
	 * @param country [required] Ip localization
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> dedicated_server_serviceName_failoverIP_GET(String serviceName, OvhIpCountryEnum country) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/failoverIP";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "country", country);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'professionalUse' option
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/professionalUse
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> dedicated_server_serviceName_professionalUse_GET(String serviceName) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/professionalUse";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/professionalUse/{duration}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_professionalUse_duration_GET(String serviceName, String duration) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/professionalUse/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicated/server/{serviceName}/professionalUse/{duration}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_professionalUse_duration_POST(String serviceName, String duration) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/professionalUse/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		String resp = exec(qPath, "POST", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/bandwidth/{duration}
	 * @param type [required] bandwidth type
	 * @param bandwidth [required] Bandwidth to allocate
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_bandwidth_duration_GET(String serviceName, String duration, OvhBandwidthOrderEnum bandwidth, OvhBandwidthOrderTypeEnum type) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/bandwidth/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "bandwidth", bandwidth);
		query(sb, "type", type);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicated/server/{serviceName}/bandwidth/{duration}
	 * @param type [required] bandwidth type
	 * @param bandwidth [required] Bandwidth to allocate
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_bandwidth_duration_POST(String serviceName, String duration, OvhBandwidthOrderEnum bandwidth, OvhBandwidthOrderTypeEnum type) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/bandwidth/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "bandwidth", bandwidth);
		addBody(o, "type", type);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'bandwidth' option
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/bandwidth
	 * @param type [required] bandwidth type
	 * @param bandwidth [required] Bandwidth to allocate
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> dedicated_server_serviceName_bandwidth_GET(String serviceName, OvhBandwidthOrderEnum bandwidth, OvhBandwidthOrderTypeEnum type) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/bandwidth";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "bandwidth", bandwidth);
		query(sb, "type", type);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'bandwidthvRack' option
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/bandwidthvRack
	 * @param bandwidth [required] vRack Bandwidth to allocate
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> dedicated_server_serviceName_bandwidthvRack_GET(String serviceName, OvhBandwidthvRackOrderEnum bandwidth) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/bandwidthvRack";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "bandwidth", bandwidth);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/dedicated/server/{serviceName}/bandwidthvRack/{duration}
	 * @param bandwidth [required] vRack Bandwidth to allocate
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_bandwidthvRack_duration_GET(String serviceName, String duration, OvhBandwidthvRackOrderEnum bandwidth) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/bandwidthvRack/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "bandwidth", bandwidth);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/dedicated/server/{serviceName}/bandwidthvRack/{duration}
	 * @param bandwidth [required] vRack Bandwidth to allocate
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param duration [required] Duration
	 */
	public OvhOrder dedicated_server_serviceName_bandwidthvRack_duration_POST(String serviceName, String duration, OvhBandwidthvRackOrderEnum bandwidth) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}/bandwidthvRack/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "bandwidth", bandwidth);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/dedicated/server/{serviceName}
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> dedicated_server_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/dedicated/server/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/xdsl/spare/new
	 * @param mondialRelayId [required] Use /supply/mondialRelay entry point to specify a relay point and ignore shipping contact address information entry.
	 * @param shippingContactId [required] Shipping contact information id from /me entry point
	 * @param quantity [required] Number of modem quantity
	 * @param brand [required] Spare modem brand model
	 */
	public OvhOrder xdsl_spare_new_GET(String brand, String mondialRelayId, Long quantity, Long shippingContactId) throws IOException {
		String qPath = "/order/xdsl/spare/new";
		StringBuilder sb = path(qPath);
		query(sb, "brand", brand);
		query(sb, "mondialRelayId", mondialRelayId);
		query(sb, "quantity", quantity);
		query(sb, "shippingContactId", shippingContactId);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/xdsl/spare/new
	 * @param mondialRelayId [required] Use /supply/mondialRelay entry point to specify a relay point and ignore shipping contact address information entry.
	 * @param shippingContactId [required] Shipping contact information id from /me entry point
	 * @param quantity [required] Number of modem quantity
	 * @param brand [required] Spare modem brand model
	 */
	public OvhOrder xdsl_spare_new_POST(String brand, String mondialRelayId, Long quantity, Long shippingContactId) throws IOException {
		String qPath = "/order/xdsl/spare/new";
		StringBuilder sb = path(qPath);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "brand", brand);
		addBody(o, "mondialRelayId", mondialRelayId);
		addBody(o, "quantity", quantity);
		addBody(o, "shippingContactId", shippingContactId);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/freefax
	 */
	public ArrayList<String> freefax_GET() throws IOException {
		String qPath = "/order/freefax";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/freefax/{serviceName}
	 * @param serviceName [required] Freefax number
	 */
	public ArrayList<String> freefax_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/freefax/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/freefax/{serviceName}/convertToVoicefax
	 * @param billingAccount [required] The /telephony billing account you want your service to be attached to
	 * @param serviceName [required] Freefax number
	 */
	public OvhOrder freefax_serviceName_convertToVoicefax_GET(String serviceName, String billingAccount) throws IOException {
		String qPath = "/order/freefax/{serviceName}/convertToVoicefax";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "billingAccount", billingAccount);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/freefax/{serviceName}/convertToVoicefax
	 * @param billingAccount [required] The /telephony billing account you want your service to be attached to
	 * @param serviceName [required] Freefax number
	 */
	public OvhOrder freefax_serviceName_convertToVoicefax_POST(String serviceName, String billingAccount) throws IOException {
		String qPath = "/order/freefax/{serviceName}/convertToVoicefax";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "billingAccount", billingAccount);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/freefax/new
	 * @param quantity [required] Fax quantity possibilities to purchase
	 */
	public OvhOrder freefax_new_GET(OvhQuantityEnum quantity) throws IOException {
		String qPath = "/order/freefax/new";
		StringBuilder sb = path(qPath);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/freefax/new
	 * @param quantity [required] Fax quantity possibilities to purchase
	 */
	public OvhOrder freefax_new_POST(OvhQuantityEnum quantity) throws IOException {
		String qPath = "/order/freefax/new";
		StringBuilder sb = path(qPath);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/upgrade/baremetalPublicBandwidth
	 *
	 * API beta
	 */
	public ArrayList<String> upgrade_baremetalPublicBandwidth_GET() throws IOException {
		String qPath = "/order/upgrade/baremetalPublicBandwidth";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get a provisional order for the selected upgrade of your service
	 *
	 * REST: GET /order/upgrade/baremetalPublicBandwidth/{serviceName}/{planCode}
	 * @param planCode [required] Plan code of the offer you want to upgrade to
	 * @param quantity [required] Quantity you want to upgrade to
	 * @param serviceName [required] The dedicated service name
	 *
	 * API beta
	 */
	public OvhOrderUpgradeOperationAndOrder upgrade_baremetalPublicBandwidth_serviceName_planCode_GET(String serviceName, String planCode, Long quantity) throws IOException {
		String qPath = "/order/upgrade/baremetalPublicBandwidth/{serviceName}/{planCode}";
		StringBuilder sb = path(qPath, serviceName, planCode);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrderUpgradeOperationAndOrder.class);
	}

	/**
	 * Perform the requested upgrade of your service
	 *
	 * REST: POST /order/upgrade/baremetalPublicBandwidth/{serviceName}/{planCode}
	 * @param planCode [required] Plan code of the offer you want to upgrade to
	 * @param autoPayWithPreferredPaymentMethod [required] Indicates that order will be automatically paid with preferred payment method
	 * @param quantity [required] Quantity you want to upgrade to
	 * @param serviceName [required] The dedicated service name
	 *
	 * API beta
	 */
	public OvhOrderUpgradeOperationAndOrder upgrade_baremetalPublicBandwidth_serviceName_planCode_POST(String serviceName, String planCode, Boolean autoPayWithPreferredPaymentMethod, Long quantity) throws IOException {
		String qPath = "/order/upgrade/baremetalPublicBandwidth/{serviceName}/{planCode}";
		StringBuilder sb = path(qPath, serviceName, planCode);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "autoPayWithPreferredPaymentMethod", autoPayWithPreferredPaymentMethod);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrderUpgradeOperationAndOrder.class);
	}

	/**
	 * Retrieve available offers to upgrade your service to
	 *
	 * REST: GET /order/upgrade/baremetalPublicBandwidth/{serviceName}
	 * @param serviceName [required] The dedicated service name
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> upgrade_baremetalPublicBandwidth_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/upgrade/baremetalPublicBandwidth/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Get a provisional order for the selected upgrade of your service
	 *
	 * REST: GET /order/upgrade/microsoftExchange/{serviceName}/{planCode}
	 * @param planCode [required] Plan code of the offer you want to upgrade to
	 * @param quantity [required] Quantity you want to upgrade to
	 * @param serviceName [required] The internal ID of Microsoft service
	 *
	 * API beta
	 */
	public OvhOrderUpgradeOperationAndOrder upgrade_microsoftExchange_serviceName_planCode_GET(String serviceName, String planCode, Long quantity) throws IOException {
		String qPath = "/order/upgrade/microsoftExchange/{serviceName}/{planCode}";
		StringBuilder sb = path(qPath, serviceName, planCode);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrderUpgradeOperationAndOrder.class);
	}

	/**
	 * Perform the requested upgrade of your service
	 *
	 * REST: POST /order/upgrade/microsoftExchange/{serviceName}/{planCode}
	 * @param planCode [required] Plan code of the offer you want to upgrade to
	 * @param autoPayWithPreferredPaymentMethod [required] Indicates that order will be automatically paid with preferred payment method
	 * @param quantity [required] Quantity you want to upgrade to
	 * @param serviceName [required] The internal ID of Microsoft service
	 *
	 * API beta
	 */
	public OvhOrderUpgradeOperationAndOrder upgrade_microsoftExchange_serviceName_planCode_POST(String serviceName, String planCode, Boolean autoPayWithPreferredPaymentMethod, Long quantity) throws IOException {
		String qPath = "/order/upgrade/microsoftExchange/{serviceName}/{planCode}";
		StringBuilder sb = path(qPath, serviceName, planCode);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "autoPayWithPreferredPaymentMethod", autoPayWithPreferredPaymentMethod);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrderUpgradeOperationAndOrder.class);
	}

	/**
	 * Retrieve available offers to upgrade your service to
	 *
	 * REST: GET /order/upgrade/microsoftExchange/{serviceName}
	 * @param serviceName [required] The internal ID of Microsoft service
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> upgrade_microsoftExchange_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/upgrade/microsoftExchange/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/upgrade/microsoftExchange
	 *
	 * API beta
	 */
	public ArrayList<String> upgrade_microsoftExchange_GET() throws IOException {
		String qPath = "/order/upgrade/microsoftExchange";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get a provisional order for the selected upgrade of your service
	 *
	 * REST: GET /order/upgrade/logs/{serviceName}/{planCode}
	 * @param planCode [required] Plan code of the offer you want to upgrade to
	 * @param quantity [required] Quantity you want to upgrade to
	 * @param serviceName [required] The internal ID of DBaaS Logs service
	 *
	 * API beta
	 */
	public OvhOrderUpgradeOperationAndOrder upgrade_logs_serviceName_planCode_GET(String serviceName, String planCode, Long quantity) throws IOException {
		String qPath = "/order/upgrade/logs/{serviceName}/{planCode}";
		StringBuilder sb = path(qPath, serviceName, planCode);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrderUpgradeOperationAndOrder.class);
	}

	/**
	 * Perform the requested upgrade of your service
	 *
	 * REST: POST /order/upgrade/logs/{serviceName}/{planCode}
	 * @param planCode [required] Plan code of the offer you want to upgrade to
	 * @param autoPayWithPreferredPaymentMethod [required] Indicates that order will be automatically paid with preferred payment method
	 * @param quantity [required] Quantity you want to upgrade to
	 * @param serviceName [required] The internal ID of DBaaS Logs service
	 *
	 * API beta
	 */
	public OvhOrderUpgradeOperationAndOrder upgrade_logs_serviceName_planCode_POST(String serviceName, String planCode, Boolean autoPayWithPreferredPaymentMethod, Long quantity) throws IOException {
		String qPath = "/order/upgrade/logs/{serviceName}/{planCode}";
		StringBuilder sb = path(qPath, serviceName, planCode);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "autoPayWithPreferredPaymentMethod", autoPayWithPreferredPaymentMethod);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrderUpgradeOperationAndOrder.class);
	}

	/**
	 * Retrieve available offers to upgrade your service to
	 *
	 * REST: GET /order/upgrade/logs/{serviceName}
	 * @param serviceName [required] The internal ID of DBaaS Logs service
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> upgrade_logs_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/upgrade/logs/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/upgrade/logs
	 *
	 * API beta
	 */
	public ArrayList<String> upgrade_logs_GET() throws IOException {
		String qPath = "/order/upgrade/logs";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/upgrade/privateCloud
	 *
	 * API beta
	 */
	public ArrayList<String> upgrade_privateCloud_GET() throws IOException {
		String qPath = "/order/upgrade/privateCloud";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Retrieve available offers to upgrade your service to
	 *
	 * REST: GET /order/upgrade/privateCloud/{serviceName}
	 * @param serviceName [required] The private cloud service name
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> upgrade_privateCloud_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/upgrade/privateCloud/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Get a provisional order for the selected upgrade of your service
	 *
	 * REST: GET /order/upgrade/privateCloud/{serviceName}/{planCode}
	 * @param planCode [required] Plan code of the offer you want to upgrade to
	 * @param quantity [required] Quantity you want to upgrade to
	 * @param serviceName [required] The private cloud service name
	 *
	 * API beta
	 */
	public OvhOrderUpgradeOperationAndOrder upgrade_privateCloud_serviceName_planCode_GET(String serviceName, String planCode, Long quantity) throws IOException {
		String qPath = "/order/upgrade/privateCloud/{serviceName}/{planCode}";
		StringBuilder sb = path(qPath, serviceName, planCode);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrderUpgradeOperationAndOrder.class);
	}

	/**
	 * Perform the requested upgrade of your service
	 *
	 * REST: POST /order/upgrade/privateCloud/{serviceName}/{planCode}
	 * @param planCode [required] Plan code of the offer you want to upgrade to
	 * @param autoPayWithPreferredPaymentMethod [required] Indicates that order will be automatically paid with preferred payment method
	 * @param quantity [required] Quantity you want to upgrade to
	 * @param serviceName [required] The private cloud service name
	 *
	 * API beta
	 */
	public OvhOrderUpgradeOperationAndOrder upgrade_privateCloud_serviceName_planCode_POST(String serviceName, String planCode, Boolean autoPayWithPreferredPaymentMethod, Long quantity) throws IOException {
		String qPath = "/order/upgrade/privateCloud/{serviceName}/{planCode}";
		StringBuilder sb = path(qPath, serviceName, planCode);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "autoPayWithPreferredPaymentMethod", autoPayWithPreferredPaymentMethod);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrderUpgradeOperationAndOrder.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/upgrade/metrics
	 *
	 * API beta
	 */
	public ArrayList<String> upgrade_metrics_GET() throws IOException {
		String qPath = "/order/upgrade/metrics";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Retrieve available offers to upgrade your service to
	 *
	 * REST: GET /order/upgrade/metrics/{serviceName}
	 * @param serviceName [required] The internal ID of your Metrics service
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> upgrade_metrics_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/upgrade/metrics/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Get a provisional order for the selected upgrade of your service
	 *
	 * REST: GET /order/upgrade/metrics/{serviceName}/{planCode}
	 * @param planCode [required] Plan code of the offer you want to upgrade to
	 * @param quantity [required] Quantity you want to upgrade to
	 * @param serviceName [required] The internal ID of your Metrics service
	 *
	 * API beta
	 */
	public OvhOrderUpgradeOperationAndOrder upgrade_metrics_serviceName_planCode_GET(String serviceName, String planCode, Long quantity) throws IOException {
		String qPath = "/order/upgrade/metrics/{serviceName}/{planCode}";
		StringBuilder sb = path(qPath, serviceName, planCode);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrderUpgradeOperationAndOrder.class);
	}

	/**
	 * Perform the requested upgrade of your service
	 *
	 * REST: POST /order/upgrade/metrics/{serviceName}/{planCode}
	 * @param planCode [required] Plan code of the offer you want to upgrade to
	 * @param autoPayWithPreferredPaymentMethod [required] Indicates that order will be automatically paid with preferred payment method
	 * @param quantity [required] Quantity you want to upgrade to
	 * @param serviceName [required] The internal ID of your Metrics service
	 *
	 * API beta
	 */
	public OvhOrderUpgradeOperationAndOrder upgrade_metrics_serviceName_planCode_POST(String serviceName, String planCode, Boolean autoPayWithPreferredPaymentMethod, Long quantity) throws IOException {
		String qPath = "/order/upgrade/metrics/{serviceName}/{planCode}";
		StringBuilder sb = path(qPath, serviceName, planCode);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "autoPayWithPreferredPaymentMethod", autoPayWithPreferredPaymentMethod);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrderUpgradeOperationAndOrder.class);
	}

	/**
	 * Retrieve available offers to upgrade your service to
	 *
	 * REST: GET /order/upgrade/cephaas/{serviceName}
	 * @param serviceName [required] The internal ID of Ceph service
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> upgrade_cephaas_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/upgrade/cephaas/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Get a provisional order for the selected upgrade of your service
	 *
	 * REST: GET /order/upgrade/cephaas/{serviceName}/{planCode}
	 * @param planCode [required] Plan code of the offer you want to upgrade to
	 * @param quantity [required] Quantity you want to upgrade to
	 * @param serviceName [required] The internal ID of Ceph service
	 *
	 * API beta
	 */
	public OvhOrderUpgradeOperationAndOrder upgrade_cephaas_serviceName_planCode_GET(String serviceName, String planCode, Long quantity) throws IOException {
		String qPath = "/order/upgrade/cephaas/{serviceName}/{planCode}";
		StringBuilder sb = path(qPath, serviceName, planCode);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrderUpgradeOperationAndOrder.class);
	}

	/**
	 * Perform the requested upgrade of your service
	 *
	 * REST: POST /order/upgrade/cephaas/{serviceName}/{planCode}
	 * @param planCode [required] Plan code of the offer you want to upgrade to
	 * @param autoPayWithPreferredPaymentMethod [required] Indicates that order will be automatically paid with preferred payment method
	 * @param quantity [required] Quantity you want to upgrade to
	 * @param serviceName [required] The internal ID of Ceph service
	 *
	 * API beta
	 */
	public OvhOrderUpgradeOperationAndOrder upgrade_cephaas_serviceName_planCode_POST(String serviceName, String planCode, Boolean autoPayWithPreferredPaymentMethod, Long quantity) throws IOException {
		String qPath = "/order/upgrade/cephaas/{serviceName}/{planCode}";
		StringBuilder sb = path(qPath, serviceName, planCode);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "autoPayWithPreferredPaymentMethod", autoPayWithPreferredPaymentMethod);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrderUpgradeOperationAndOrder.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/upgrade/cephaas
	 *
	 * API beta
	 */
	public ArrayList<String> upgrade_cephaas_GET() throws IOException {
		String qPath = "/order/upgrade/cephaas";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Retrieve available offers to upgrade your service to
	 *
	 * REST: GET /order/upgrade/baremetalPrivateBandwidth/{serviceName}
	 * @param serviceName [required] The dedicated service name
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> upgrade_baremetalPrivateBandwidth_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/upgrade/baremetalPrivateBandwidth/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Get a provisional order for the selected upgrade of your service
	 *
	 * REST: GET /order/upgrade/baremetalPrivateBandwidth/{serviceName}/{planCode}
	 * @param planCode [required] Plan code of the offer you want to upgrade to
	 * @param quantity [required] Quantity you want to upgrade to
	 * @param serviceName [required] The dedicated service name
	 *
	 * API beta
	 */
	public OvhOrderUpgradeOperationAndOrder upgrade_baremetalPrivateBandwidth_serviceName_planCode_GET(String serviceName, String planCode, Long quantity) throws IOException {
		String qPath = "/order/upgrade/baremetalPrivateBandwidth/{serviceName}/{planCode}";
		StringBuilder sb = path(qPath, serviceName, planCode);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrderUpgradeOperationAndOrder.class);
	}

	/**
	 * Perform the requested upgrade of your service
	 *
	 * REST: POST /order/upgrade/baremetalPrivateBandwidth/{serviceName}/{planCode}
	 * @param planCode [required] Plan code of the offer you want to upgrade to
	 * @param autoPayWithPreferredPaymentMethod [required] Indicates that order will be automatically paid with preferred payment method
	 * @param quantity [required] Quantity you want to upgrade to
	 * @param serviceName [required] The dedicated service name
	 *
	 * API beta
	 */
	public OvhOrderUpgradeOperationAndOrder upgrade_baremetalPrivateBandwidth_serviceName_planCode_POST(String serviceName, String planCode, Boolean autoPayWithPreferredPaymentMethod, Long quantity) throws IOException {
		String qPath = "/order/upgrade/baremetalPrivateBandwidth/{serviceName}/{planCode}";
		StringBuilder sb = path(qPath, serviceName, planCode);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "autoPayWithPreferredPaymentMethod", autoPayWithPreferredPaymentMethod);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrderUpgradeOperationAndOrder.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/upgrade/baremetalPrivateBandwidth
	 *
	 * API beta
	 */
	public ArrayList<String> upgrade_baremetalPrivateBandwidth_GET() throws IOException {
		String qPath = "/order/upgrade/baremetalPrivateBandwidth";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/upgrade/sslGateway
	 *
	 * API beta
	 */
	public ArrayList<String> upgrade_sslGateway_GET() throws IOException {
		String qPath = "/order/upgrade/sslGateway";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get a provisional order for the selected upgrade of your service
	 *
	 * REST: GET /order/upgrade/sslGateway/{serviceName}/{planCode}
	 * @param planCode [required] Plan code of the offer you want to upgrade to
	 * @param quantity [required] Quantity you want to upgrade to
	 * @param serviceName [required] The internal ID of SSL Gateway service
	 *
	 * API beta
	 */
	public OvhOrderUpgradeOperationAndOrder upgrade_sslGateway_serviceName_planCode_GET(String serviceName, String planCode, Long quantity) throws IOException {
		String qPath = "/order/upgrade/sslGateway/{serviceName}/{planCode}";
		StringBuilder sb = path(qPath, serviceName, planCode);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrderUpgradeOperationAndOrder.class);
	}

	/**
	 * Perform the requested upgrade of your service
	 *
	 * REST: POST /order/upgrade/sslGateway/{serviceName}/{planCode}
	 * @param planCode [required] Plan code of the offer you want to upgrade to
	 * @param autoPayWithPreferredPaymentMethod [required] Indicates that order will be automatically paid with preferred payment method
	 * @param quantity [required] Quantity you want to upgrade to
	 * @param serviceName [required] The internal ID of SSL Gateway service
	 *
	 * API beta
	 */
	public OvhOrderUpgradeOperationAndOrder upgrade_sslGateway_serviceName_planCode_POST(String serviceName, String planCode, Boolean autoPayWithPreferredPaymentMethod, Long quantity) throws IOException {
		String qPath = "/order/upgrade/sslGateway/{serviceName}/{planCode}";
		StringBuilder sb = path(qPath, serviceName, planCode);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "autoPayWithPreferredPaymentMethod", autoPayWithPreferredPaymentMethod);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrderUpgradeOperationAndOrder.class);
	}

	/**
	 * Retrieve available offers to upgrade your service to
	 *
	 * REST: GET /order/upgrade/sslGateway/{serviceName}
	 * @param serviceName [required] The internal ID of SSL Gateway service
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> upgrade_sslGateway_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/upgrade/sslGateway/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Retrieve available offers to upgrade your service to
	 *
	 * REST: GET /order/upgrade/ipLoadbalancing/{serviceName}
	 * @param serviceName [required] The internal ID of your IPLB service
	 *
	 * API beta
	 */
	public ArrayList<OvhGenericProductDefinition> upgrade_ipLoadbalancing_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/upgrade/ipLoadbalancing/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t3);
	}

	/**
	 * Get a provisional order for the selected upgrade of your service
	 *
	 * REST: GET /order/upgrade/ipLoadbalancing/{serviceName}/{planCode}
	 * @param planCode [required] Plan code of the offer you want to upgrade to
	 * @param quantity [required] Quantity you want to upgrade to
	 * @param serviceName [required] The internal ID of your IPLB service
	 *
	 * API beta
	 */
	public OvhOrderUpgradeOperationAndOrder upgrade_ipLoadbalancing_serviceName_planCode_GET(String serviceName, String planCode, Long quantity) throws IOException {
		String qPath = "/order/upgrade/ipLoadbalancing/{serviceName}/{planCode}";
		StringBuilder sb = path(qPath, serviceName, planCode);
		query(sb, "quantity", quantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrderUpgradeOperationAndOrder.class);
	}

	/**
	 * Perform the requested upgrade of your service
	 *
	 * REST: POST /order/upgrade/ipLoadbalancing/{serviceName}/{planCode}
	 * @param planCode [required] Plan code of the offer you want to upgrade to
	 * @param autoPayWithPreferredPaymentMethod [required] Indicates that order will be automatically paid with preferred payment method
	 * @param quantity [required] Quantity you want to upgrade to
	 * @param serviceName [required] The internal ID of your IPLB service
	 *
	 * API beta
	 */
	public OvhOrderUpgradeOperationAndOrder upgrade_ipLoadbalancing_serviceName_planCode_POST(String serviceName, String planCode, Boolean autoPayWithPreferredPaymentMethod, Long quantity) throws IOException {
		String qPath = "/order/upgrade/ipLoadbalancing/{serviceName}/{planCode}";
		StringBuilder sb = path(qPath, serviceName, planCode);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "autoPayWithPreferredPaymentMethod", autoPayWithPreferredPaymentMethod);
		addBody(o, "quantity", quantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrderUpgradeOperationAndOrder.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/upgrade/ipLoadbalancing
	 *
	 * API beta
	 */
	public ArrayList<String> upgrade_ipLoadbalancing_GET() throws IOException {
		String qPath = "/order/upgrade/ipLoadbalancing";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Retrieve information of Private Cloud CDI catalog
	 *
	 * REST: GET /order/catalog/formatted/privateCloudCDI
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 *
	 * API beta
	 */
	public OvhCatalog catalog_formatted_privateCloudCDI_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/privateCloudCDI";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhCatalog.class);
	}

	/**
	 * Retrieve information of cPanel licenses catalog
	 *
	 * REST: GET /order/catalog/formatted/licensecPanel
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 *
	 * API beta
	 */
	public net.minidev.ovh.api.order.catalog.OvhCatalog catalog_formatted_licensecPanel_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/licensecPanel";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, net.minidev.ovh.api.order.catalog.OvhCatalog.class);
	}

	/**
	 * Retrieve information of Virtuozzo licenses catalog
	 *
	 * REST: GET /order/catalog/formatted/licenseVirtuozzo
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 *
	 * API beta
	 */
	public net.minidev.ovh.api.order.catalog.OvhCatalog catalog_formatted_licenseVirtuozzo_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/licenseVirtuozzo";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, net.minidev.ovh.api.order.catalog.OvhCatalog.class);
	}

	/**
	 * Retrieve information of Logs Data Platform catalog
	 *
	 * REST: GET /order/catalog/formatted/logs
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 */
	public net.minidev.ovh.api.order.catalog.OvhCatalog catalog_formatted_logs_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/logs";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, net.minidev.ovh.api.order.catalog.OvhCatalog.class);
	}

	/**
	 * Retrieve information of Public Cloud catalog
	 *
	 * REST: GET /order/catalog/formatted/cloud
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 *
	 * API beta
	 */
	public net.minidev.ovh.api.order.catalog.OvhCatalog catalog_formatted_cloud_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/cloud";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, net.minidev.ovh.api.order.catalog.OvhCatalog.class);
	}

	/**
	 * Retrieve information of dedicated server catalog
	 *
	 * REST: GET /order/catalog/formatted/dedicated
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 *
	 * API beta
	 */
	public net.minidev.ovh.api.order.catalog.OvhCatalog catalog_formatted_dedicated_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/dedicated";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, net.minidev.ovh.api.order.catalog.OvhCatalog.class);
	}

	/**
	 * Retrieve information of Reseller catalog
	 *
	 * REST: GET /order/catalog/formatted/reseller
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 *
	 * API beta
	 */
	public net.minidev.ovh.api.order.catalog.OvhCatalog catalog_formatted_reseller_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/reseller";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, net.minidev.ovh.api.order.catalog.OvhCatalog.class);
	}

	/**
	 * Retrieve list of catalog name
	 *
	 * REST: GET /order/catalog/formatted
	 * @deprecated
	 */
	public ArrayList<String> catalog_formatted_GET() throws IOException {
		String qPath = "/order/catalog/formatted";
		StringBuilder sb = path(qPath);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Retrieve information of Private Cloud Dedicated Cloud catalog
	 *
	 * REST: GET /order/catalog/formatted/privateCloudDC
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 *
	 * API beta
	 */
	public OvhCatalog catalog_formatted_privateCloudDC_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/privateCloudDC";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhCatalog.class);
	}

	/**
	 * Retrieve information of Private Cloud SDDC catalog
	 *
	 * REST: GET /order/catalog/formatted/privateCloudSDDC
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 *
	 * API beta
	 */
	public OvhCatalog catalog_formatted_privateCloudSDDC_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/privateCloudSDDC";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhCatalog.class);
	}

	/**
	 * Retrieve information of SqlServer licenses catalog
	 *
	 * REST: GET /order/catalog/formatted/licenseSqlServer
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 *
	 * API beta
	 */
	public net.minidev.ovh.api.order.catalog.OvhCatalog catalog_formatted_licenseSqlServer_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/licenseSqlServer";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, net.minidev.ovh.api.order.catalog.OvhCatalog.class);
	}

	/**
	 * Retrieve information of CloudLinux licenses catalog
	 *
	 * REST: GET /order/catalog/formatted/licenseCloudLinux
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 *
	 * API beta
	 */
	public net.minidev.ovh.api.order.catalog.OvhCatalog catalog_formatted_licenseCloudLinux_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/licenseCloudLinux";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, net.minidev.ovh.api.order.catalog.OvhCatalog.class);
	}

	/**
	 * Retrieve information of IP addresses catalog
	 *
	 * REST: GET /order/catalog/formatted/ip
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 *
	 * API beta
	 */
	public net.minidev.ovh.api.order.catalog.OvhCatalog catalog_formatted_ip_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/ip";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, net.minidev.ovh.api.order.catalog.OvhCatalog.class);
	}

	/**
	 * Retrieve information of Desk as a service catalog
	 *
	 * REST: GET /order/catalog/formatted/deskaas
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 *
	 * API beta
	 */
	public net.minidev.ovh.api.order.catalog.OvhCatalog catalog_formatted_deskaas_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/deskaas";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, net.minidev.ovh.api.order.catalog.OvhCatalog.class);
	}

	/**
	 * Retrieve information of Private Cloud Reseller Enterprise catalog
	 *
	 * REST: GET /order/catalog/formatted/privateCloudResellerEnterprise
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 */
	public net.minidev.ovh.api.order.catalog.pcc.OvhCatalog catalog_formatted_privateCloudResellerEnterprise_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/privateCloudResellerEnterprise";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, net.minidev.ovh.api.order.catalog.pcc.OvhCatalog.class);
	}

	/**
	 * Retrieve information of Plesk licenses catalog
	 *
	 * REST: GET /order/catalog/formatted/licensePlesk
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 *
	 * API beta
	 */
	public net.minidev.ovh.api.order.catalog.OvhCatalog catalog_formatted_licensePlesk_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/licensePlesk";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, net.minidev.ovh.api.order.catalog.OvhCatalog.class);
	}

	/**
	 * Retrieve information of dedicated discover offer server catalog
	 *
	 * REST: GET /order/catalog/formatted/discover
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 */
	public net.minidev.ovh.api.order.catalog.OvhCatalog catalog_formatted_discover_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/discover";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, net.minidev.ovh.api.order.catalog.OvhCatalog.class);
	}

	/**
	 * Retrieve information of Windows licenses catalog
	 *
	 * REST: GET /order/catalog/formatted/licenseWindows
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 *
	 * API beta
	 */
	public net.minidev.ovh.api.order.catalog.OvhCatalog catalog_formatted_licenseWindows_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/licenseWindows";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, net.minidev.ovh.api.order.catalog.OvhCatalog.class);
	}

	/**
	 * Retrieve information of Worklight licenses catalog
	 *
	 * REST: GET /order/catalog/formatted/licenseWorklight
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 *
	 * API beta
	 */
	public net.minidev.ovh.api.order.catalog.OvhCatalog catalog_formatted_licenseWorklight_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/licenseWorklight";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, net.minidev.ovh.api.order.catalog.OvhCatalog.class);
	}

	/**
	 * Retrieve information of VPS catalog
	 *
	 * REST: GET /order/catalog/formatted/vps
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 *
	 * API beta
	 */
	public net.minidev.ovh.api.order.catalog.OvhCatalog catalog_formatted_vps_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/vps";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, net.minidev.ovh.api.order.catalog.OvhCatalog.class);
	}

	/**
	 * Retrieve information of Private Cloud Reseller catalog
	 *
	 * REST: GET /order/catalog/formatted/privateCloudReseller
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 */
	public net.minidev.ovh.api.order.catalog.pcc.OvhCatalog catalog_formatted_privateCloudReseller_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/privateCloudReseller";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, net.minidev.ovh.api.order.catalog.pcc.OvhCatalog.class);
	}

	/**
	 * Retrieve information of Directadmin licenses offers catalog
	 *
	 * REST: GET /order/catalog/formatted/licenseDirectadmin
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 *
	 * API beta
	 */
	public net.minidev.ovh.api.order.catalog.OvhCatalog catalog_formatted_licenseDirectadmin_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/formatted/licenseDirectadmin";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, net.minidev.ovh.api.order.catalog.OvhCatalog.class);
	}

	/**
	 * Retrieve bare-metal servers catalog
	 *
	 * REST: GET /order/catalog/public/baremetalServers
	 * @param ovhSubsidiary [required] Subsidiary of the country you want to consult catalog
	 *
	 * API beta
	 */
	public net.minidev.ovh.api.order.catalog._public.OvhCatalog catalog_public_baremetalServers_GET(OvhOvhSubsidiaryEnum ovhSubsidiary) throws IOException {
		String qPath = "/order/catalog/public/baremetalServers";
		StringBuilder sb = path(qPath);
		query(sb, "ovhSubsidiary", ovhSubsidiary);
		String resp = execN(qPath, "GET", sb.toString(), null);
		return convertTo(resp, net.minidev.ovh.api.order.catalog._public.OvhCatalog.class);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/saas/csp2/new/{duration}
	 * @param giftCode [required] Gift code for office license
	 * @param officeBusinessQuantity [required] Number of prepaid office business license
	 * @param officeProPlusQuantity [required] Number of prepaid office pro plus license
	 * @param duration [required] Duration
	 */
	public OvhOrder saas_csp2_new_duration_GET(String duration, String giftCode, Long officeBusinessQuantity, Long officeProPlusQuantity) throws IOException {
		String qPath = "/order/saas/csp2/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		query(sb, "giftCode", giftCode);
		query(sb, "officeBusinessQuantity", officeBusinessQuantity);
		query(sb, "officeProPlusQuantity", officeProPlusQuantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/saas/csp2/new/{duration}
	 * @param giftCode [required] Gift code for office license
	 * @param officeBusinessQuantity [required] Number of prepaid office business license
	 * @param officeProPlusQuantity [required] Number of prepaid office pro plus license
	 * @param duration [required] Duration
	 */
	public OvhOrder saas_csp2_new_duration_POST(String duration, String giftCode, Long officeBusinessQuantity, Long officeProPlusQuantity) throws IOException {
		String qPath = "/order/saas/csp2/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "giftCode", giftCode);
		addBody(o, "officeBusinessQuantity", officeBusinessQuantity);
		addBody(o, "officeProPlusQuantity", officeProPlusQuantity);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'new' option
	 *
	 * REST: GET /order/saas/csp2/new
	 * @param giftCode [required] Gift code for office license
	 * @param officeBusinessQuantity [required] Number of prepaid office business license
	 * @param officeProPlusQuantity [required] Number of prepaid office pro plus license
	 */
	public ArrayList<String> saas_csp2_new_GET(String giftCode, Long officeBusinessQuantity, Long officeProPlusQuantity) throws IOException {
		String qPath = "/order/saas/csp2/new";
		StringBuilder sb = path(qPath);
		query(sb, "giftCode", giftCode);
		query(sb, "officeBusinessQuantity", officeBusinessQuantity);
		query(sb, "officeProPlusQuantity", officeProPlusQuantity);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/veeamCloudConnect/{serviceName}/upgrade/{duration}
	 * @param offer [required] The offer on which you want to be upgraded
	 * @param serviceName [required]
	 * @param duration [required] Duration
	 */
	public OvhOrder veeamCloudConnect_serviceName_upgrade_duration_GET(String serviceName, String duration, OvhOffer offer) throws IOException {
		String qPath = "/order/veeamCloudConnect/{serviceName}/upgrade/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		query(sb, "offer", offer);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/veeamCloudConnect/{serviceName}/upgrade/{duration}
	 * @param offer [required] The offer on which you want to be upgraded
	 * @param serviceName [required]
	 * @param duration [required] Duration
	 */
	public OvhOrder veeamCloudConnect_serviceName_upgrade_duration_POST(String serviceName, String duration, OvhOffer offer) throws IOException {
		String qPath = "/order/veeamCloudConnect/{serviceName}/upgrade/{duration}";
		StringBuilder sb = path(qPath, serviceName, duration);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "offer", offer);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Get allowed durations for 'upgrade' option
	 *
	 * REST: GET /order/veeamCloudConnect/{serviceName}/upgrade
	 * @param offer [required] The offer on which you want to be upgraded
	 * @param serviceName [required]
	 */
	public ArrayList<String> veeamCloudConnect_serviceName_upgrade_GET(String serviceName, OvhOffer offer) throws IOException {
		String qPath = "/order/veeamCloudConnect/{serviceName}/upgrade";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "offer", offer);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed options
	 *
	 * REST: GET /order/veeamCloudConnect/{serviceName}
	 * @param serviceName [required]
	 */
	public ArrayList<String> veeamCloudConnect_serviceName_GET(String serviceName) throws IOException {
		String qPath = "/order/veeamCloudConnect/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * List available services
	 *
	 * REST: GET /order/veeamCloudConnect
	 */
	public ArrayList<String> veeamCloudConnect_GET() throws IOException {
		String qPath = "/order/veeamCloudConnect";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get allowed durations for 'new' option
	 *
	 * REST: GET /order/hpcspot/new
	 */
	public ArrayList<String> hpcspot_new_GET() throws IOException {
		String qPath = "/order/hpcspot/new";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Get prices and contracts information
	 *
	 * REST: GET /order/hpcspot/new/{duration}
	 * @param duration [required] Duration
	 */
	public OvhOrder hpcspot_new_duration_GET(String duration) throws IOException {
		String qPath = "/order/hpcspot/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}

	/**
	 * Create order
	 *
	 * REST: POST /order/hpcspot/new/{duration}
	 * @param duration [required] Duration
	 */
	public OvhOrder hpcspot_new_duration_POST(String duration) throws IOException {
		String qPath = "/order/hpcspot/new/{duration}";
		StringBuilder sb = path(qPath, duration);
		String resp = exec(qPath, "POST", sb.toString(), null);
		return convertTo(resp, OvhOrder.class);
	}
}
