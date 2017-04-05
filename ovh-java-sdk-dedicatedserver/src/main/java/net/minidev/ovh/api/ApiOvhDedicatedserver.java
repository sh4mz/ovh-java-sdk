package net.minidev.ovh.api;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import net.minidev.ovh.api.complextype.OvhChartReturn;
import net.minidev.ovh.api.dedicated.OvhAvailabilities;
import net.minidev.ovh.api.dedicated.OvhTaskFunctionEnum;
import net.minidev.ovh.api.dedicated.OvhTaskStatusEnum;
import net.minidev.ovh.api.dedicated.server.OvhAlertLanguageEnum;
import net.minidev.ovh.api.dedicated.server.OvhBackupFtp;
import net.minidev.ovh.api.dedicated.server.OvhBackupFtpAcl;
import net.minidev.ovh.api.dedicated.server.OvhBackupStorageOrderable;
import net.minidev.ovh.api.dedicated.server.OvhBandwidthOrderable;
import net.minidev.ovh.api.dedicated.server.OvhBootOptionEnum;
import net.minidev.ovh.api.dedicated.server.OvhBootTypeEnum;
import net.minidev.ovh.api.dedicated.server.OvhCacheTTLEnum;
import net.minidev.ovh.api.dedicated.server.OvhDedicated;
import net.minidev.ovh.api.dedicated.server.OvhEmailAlert;
import net.minidev.ovh.api.dedicated.server.OvhFirewall;
import net.minidev.ovh.api.dedicated.server.OvhHardwareRaidProfile;
import net.minidev.ovh.api.dedicated.server.OvhHardwareRaidSize;
import net.minidev.ovh.api.dedicated.server.OvhHardwareSpecifications;
import net.minidev.ovh.api.dedicated.server.OvhInstallCustom;
import net.minidev.ovh.api.dedicated.server.OvhInstallTemplate;
import net.minidev.ovh.api.dedicated.server.OvhInstallationProgressStatus;
import net.minidev.ovh.api.dedicated.server.OvhIntervention;
import net.minidev.ovh.api.dedicated.server.OvhIpCountryEnum;
import net.minidev.ovh.api.dedicated.server.OvhIpOrderable;
import net.minidev.ovh.api.dedicated.server.OvhIpmi;
import net.minidev.ovh.api.dedicated.server.OvhIpmiAccessTypeEnum;
import net.minidev.ovh.api.dedicated.server.OvhIpmiAccessValue;
import net.minidev.ovh.api.dedicated.server.OvhIpmiTestResult;
import net.minidev.ovh.api.dedicated.server.OvhIpmiTestTypeEnum;
import net.minidev.ovh.api.dedicated.server.OvhKvm;
import net.minidev.ovh.api.dedicated.server.OvhMonitoringIntervalEnum;
import net.minidev.ovh.api.dedicated.server.OvhMonitoringProtocolEnum;
import net.minidev.ovh.api.dedicated.server.OvhMrtgPeriodEnum;
import net.minidev.ovh.api.dedicated.server.OvhMrtgTimestampValue;
import net.minidev.ovh.api.dedicated.server.OvhMrtgTypeEnum;
import net.minidev.ovh.api.dedicated.server.OvhNetboot;
import net.minidev.ovh.api.dedicated.server.OvhNetbootOption;
import net.minidev.ovh.api.dedicated.server.OvhNetworkSpecifications;
import net.minidev.ovh.api.dedicated.server.OvhOption;
import net.minidev.ovh.api.dedicated.server.OvhOptionEnum;
import net.minidev.ovh.api.dedicated.server.OvhOrderableSysFeatureEnum;
import net.minidev.ovh.api.dedicated.server.OvhRtm;
import net.minidev.ovh.api.dedicated.server.OvhRtmChartPeriodEnum;
import net.minidev.ovh.api.dedicated.server.OvhRtmChartTypeEnum;
import net.minidev.ovh.api.dedicated.server.OvhRtmCommandSize;
import net.minidev.ovh.api.dedicated.server.OvhRtmConnection;
import net.minidev.ovh.api.dedicated.server.OvhRtmCpu;
import net.minidev.ovh.api.dedicated.server.OvhRtmDisk;
import net.minidev.ovh.api.dedicated.server.OvhRtmDiskSmart;
import net.minidev.ovh.api.dedicated.server.OvhRtmLoad;
import net.minidev.ovh.api.dedicated.server.OvhRtmMemory;
import net.minidev.ovh.api.dedicated.server.OvhRtmMotherboardHw;
import net.minidev.ovh.api.dedicated.server.OvhRtmOs;
import net.minidev.ovh.api.dedicated.server.OvhRtmPartition;
import net.minidev.ovh.api.dedicated.server.OvhRtmPci;
import net.minidev.ovh.api.dedicated.server.OvhRtmRaid;
import net.minidev.ovh.api.dedicated.server.OvhRtmRaidVolume;
import net.minidev.ovh.api.dedicated.server.OvhRtmRaidVolumePort;
import net.minidev.ovh.api.dedicated.server.OvhServerBurst;
import net.minidev.ovh.api.dedicated.server.OvhServiceMonitoring;
import net.minidev.ovh.api.dedicated.server.OvhSmsAlert;
import net.minidev.ovh.api.dedicated.server.OvhSpla;
import net.minidev.ovh.api.dedicated.server.OvhSplaStatusEnum;
import net.minidev.ovh.api.dedicated.server.OvhSplaTypeEnum;
import net.minidev.ovh.api.dedicated.server.OvhSupportReplaceHddInfo;
import net.minidev.ovh.api.dedicated.server.OvhTask;
import net.minidev.ovh.api.dedicated.server.OvhTemplateCaps;
import net.minidev.ovh.api.dedicated.server.OvhUsbKeyOrderableDetails;
import net.minidev.ovh.api.dedicated.server.OvhVirtualMac;
import net.minidev.ovh.api.dedicated.server.OvhVirtualMacManagement;
import net.minidev.ovh.api.dedicated.server.OvhVmacTypeEnum;
import net.minidev.ovh.api.license.OvhWindowsOsVersionEnum;
import net.minidev.ovh.api.license.OvhWindowsSqlVersionEnum;
import net.minidev.ovh.api.nichandle.OvhOvhSubsidiaryEnum;
import net.minidev.ovh.api.secondarydns.OvhSecondaryDNS;
import net.minidev.ovh.api.secondarydns.OvhSecondaryDNSCheckField;
import net.minidev.ovh.api.secondarydns.OvhSecondaryDNSNameServer;
import net.minidev.ovh.api.service.OvhTerminationReasonEnum;
import net.minidev.ovh.api.services.OvhService;
import net.minidev.ovh.api.support.OvhNewMessageInfo;
import net.minidev.ovh.api.vrack.OvhDedicatedServer;
import net.minidev.ovh.core.ApiOvhBase;
import net.minidev.ovh.core.ApiOvhCore;

/**
 * BasePath:https://api.ovh.com/1.0
 * ResourcePath:/dedicated/server
 * version:1.0
 */
public class ApiOvhDedicatedserver extends ApiOvhBase {
	public ApiOvhDedicatedserver(ApiOvhCore core) {
		super(core);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhDedicated serviceName_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhDedicated.class);
	}

	/**
	 * Alter this object properties
	 *
	 * REST: PUT /dedicated/server/{serviceName}
	 * @param body [required] New object properties
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public void serviceName_PUT(String serviceName, OvhDedicated body) throws IOException {
		String qPath = "/dedicated/server/{serviceName}";
		qPath = qPath.replace("{serviceName}", serviceName);
		exec("PUT", qPath, body);
	}

	/**
	 * Merge a splitted block and route it to the choosen server. You cannot undo this operation
	 *
	 * REST: POST /dedicated/server/{serviceName}/ipBlockMerge
	 * @param block [required] The splitted block you want to merge
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhTask serviceName_ipBlockMerge_POST(String serviceName, String block) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/ipBlockMerge";
		qPath = qPath.replace("{serviceName}", serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "block", block);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhRtm serviceName_statistics_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhRtm.class);
	}

	/**
	 * Get server opened connections
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/connection
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<OvhRtmConnection> serviceName_statistics_connection_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/connection";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t1);
	}
	private static TypeReference<ArrayList<OvhRtmConnection>> t1 = new TypeReference<ArrayList<OvhRtmConnection>>() {};

	/**
	 * Retrieve RTM graph values
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/chart
	 * @param period [required] chart period
	 * @param type [required] RTM chart type
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhChartReturn serviceName_statistics_chart_GET(String serviceName, OvhRtmChartPeriodEnum period, OvhRtmChartTypeEnum type) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/chart";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = query(qPath, "period", period);
		qPath = query(qPath, "type", type);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhChartReturn.class);
	}

	/**
	 * Get server cpu informations
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/cpu
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhRtmCpu serviceName_statistics_cpu_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/cpu";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhRtmCpu.class);
	}

	/**
	 * Get server PCI devices informations
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/pci
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<OvhRtmPci> serviceName_statistics_pci_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/pci";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t2);
	}
	private static TypeReference<ArrayList<OvhRtmPci>> t2 = new TypeReference<ArrayList<OvhRtmPci>>() {};

	/**
	 * Server disks
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/disk
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> serviceName_statistics_disk_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/disk";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}
	private static TypeReference<ArrayList<String>> t3 = new TypeReference<ArrayList<String>>() {};

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/disk/{disk}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param disk [required] Disk
	 */
	public OvhRtmDisk serviceName_statistics_disk_disk_GET(String serviceName, String disk) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/disk/{disk}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{disk}", disk);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhRtmDisk.class);
	}

	/**
	 * Get disk smart informations
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/disk/{disk}/smart
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param disk [required] Disk
	 */
	public OvhRtmDiskSmart serviceName_statistics_disk_disk_smart_GET(String serviceName, String disk) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/disk/{disk}/smart";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{disk}", disk);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhRtmDiskSmart.class);
	}

	/**
	 * Get server process
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/process
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<OvhRtmCommandSize> serviceName_statistics_process_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/process";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t4);
	}
	private static TypeReference<ArrayList<OvhRtmCommandSize>> t4 = new TypeReference<ArrayList<OvhRtmCommandSize>>() {};

	/**
	 * Get server os informations
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/os
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhRtmOs serviceName_statistics_os_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/os";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhRtmOs.class);
	}

	/**
	 * Server raid informations
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/raid
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> serviceName_statistics_raid_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/raid";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/raid/{unit}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param unit [required] Raid unit
	 */
	public OvhRtmRaid serviceName_statistics_raid_unit_GET(String serviceName, String unit) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/raid/{unit}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{unit}", unit);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhRtmRaid.class);
	}

	/**
	 * Raid unit volumes
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/raid/{unit}/volume
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param unit [required] Raid unit
	 */
	public ArrayList<String> serviceName_statistics_raid_unit_volume_GET(String serviceName, String unit) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/raid/{unit}/volume";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{unit}", unit);
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/raid/{unit}/volume/{volume}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param unit [required] Raid unit
	 * @param volume [required] Raid volume name
	 */
	public OvhRtmRaidVolume serviceName_statistics_raid_unit_volume_volume_GET(String serviceName, String unit, String volume) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/raid/{unit}/volume/{volume}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{unit}", unit);
		qPath = qPath.replace("{volume}", volume);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhRtmRaidVolume.class);
	}

	/**
	 * Raid unit volume ports
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/raid/{unit}/volume/{volume}/port
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param unit [required] Raid unit
	 * @param volume [required] Raid volume name
	 */
	public ArrayList<String> serviceName_statistics_raid_unit_volume_volume_port_GET(String serviceName, String unit, String volume) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/raid/{unit}/volume/{volume}/port";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{unit}", unit);
		qPath = qPath.replace("{volume}", volume);
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/raid/{unit}/volume/{volume}/port/{port}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param unit [required] Raid unit
	 * @param volume [required] Raid volume name
	 * @param port [required] Raid volume port
	 */
	public OvhRtmRaidVolumePort serviceName_statistics_raid_unit_volume_volume_port_port_GET(String serviceName, String unit, String volume, String port) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/raid/{unit}/volume/{volume}/port/{port}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{unit}", unit);
		qPath = qPath.replace("{volume}", volume);
		qPath = qPath.replace("{port}", port);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhRtmRaidVolumePort.class);
	}

	/**
	 * Get server memory informations
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/memory
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<OvhRtmMemory> serviceName_statistics_memory_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/memory";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t5);
	}
	private static TypeReference<ArrayList<OvhRtmMemory>> t5 = new TypeReference<ArrayList<OvhRtmMemory>>() {};

	/**
	 * Get server load
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/load
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhRtmLoad serviceName_statistics_load_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/load";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhRtmLoad.class);
	}

	/**
	 * Server partitions
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/partition
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> serviceName_statistics_partition_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/partition";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/partition/{partition}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param partition [required] Partition
	 */
	public OvhRtmPartition serviceName_statistics_partition_partition_GET(String serviceName, String partition) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/partition/{partition}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partition}", partition);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhRtmPartition.class);
	}

	/**
	 * Retrieve partition charts
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/partition/{partition}/chart
	 * @param period [required] chart period
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param partition [required] Partition
	 */
	public OvhChartReturn serviceName_statistics_partition_partition_chart_GET(String serviceName, String partition, OvhRtmChartPeriodEnum period) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/partition/{partition}/chart";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partition}", partition);
		qPath = query(qPath, "period", period);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhChartReturn.class);
	}

	/**
	 * Get server motherboard hardware informations
	 *
	 * REST: GET /dedicated/server/{serviceName}/statistics/motherboard
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhRtmMotherboardHw serviceName_statistics_motherboard_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/statistics/motherboard";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhRtmMotherboardHw.class);
	}

	/**
	 * technical intervention history
	 *
	 * REST: GET /dedicated/server/{serviceName}/intervention
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<Long> serviceName_intervention_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/intervention";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t6);
	}
	private static TypeReference<ArrayList<Long>> t6 = new TypeReference<ArrayList<Long>>() {};

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/intervention/{interventionId}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param interventionId [required] The intervention id
	 */
	public OvhIntervention serviceName_intervention_interventionId_GET(String serviceName, Long interventionId) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/intervention/{interventionId}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{interventionId}", interventionId.toString());
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhIntervention.class);
	}

	/**
	 * List all ip from server
	 *
	 * REST: GET /dedicated/server/{serviceName}/ips
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> serviceName_ips_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/ips";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}

	/**
	 * Virtual MAC addresses of the server
	 *
	 * REST: GET /dedicated/server/{serviceName}/virtualMac
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> serviceName_virtualMac_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/virtualMac";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}

	/**
	 * Add a virtual mac to an IP address
	 *
	 * REST: POST /dedicated/server/{serviceName}/virtualMac
	 * @param virtualMachineName [required] Friendly name of your Virtual Machine behind this IP/MAC
	 * @param ipAddress [required] Ip address to link with this virtualMac
	 * @param type [required] vmac address type
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhTask serviceName_virtualMac_POST(String serviceName, String virtualMachineName, String ipAddress, OvhVmacTypeEnum type) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/virtualMac";
		qPath = qPath.replace("{serviceName}", serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "virtualMachineName", virtualMachineName);
		addBody(o, "ipAddress", ipAddress);
		addBody(o, "type", type);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/virtualMac/{macAddress}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param macAddress [required] Virtual MAC address in 00:00:00:00:00:00 format
	 */
	public OvhVirtualMac serviceName_virtualMac_macAddress_GET(String serviceName, String macAddress) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/virtualMac/{macAddress}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{macAddress}", macAddress);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhVirtualMac.class);
	}

	/**
	 * List of IPs associated to this Virtual MAC
	 *
	 * REST: GET /dedicated/server/{serviceName}/virtualMac/{macAddress}/virtualAddress
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param macAddress [required] Virtual MAC address in 00:00:00:00:00:00 format
	 */
	public ArrayList<String> serviceName_virtualMac_macAddress_virtualAddress_GET(String serviceName, String macAddress) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/virtualMac/{macAddress}/virtualAddress";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{macAddress}", macAddress);
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}

	/**
	 * Add an IP to this Virtual MAC
	 *
	 * REST: POST /dedicated/server/{serviceName}/virtualMac/{macAddress}/virtualAddress
	 * @param virtualMachineName [required] Friendly name of your Virtual Machine behind this IP/MAC
	 * @param ipAddress [required] IP address to link to this virtual MAC
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param macAddress [required] Virtual MAC address in 00:00:00:00:00:00 format
	 */
	public OvhTask serviceName_virtualMac_macAddress_virtualAddress_POST(String serviceName, String macAddress, String virtualMachineName, String ipAddress) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/virtualMac/{macAddress}/virtualAddress";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{macAddress}", macAddress);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "virtualMachineName", virtualMachineName);
		addBody(o, "ipAddress", ipAddress);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/virtualMac/{macAddress}/virtualAddress/{ipAddress}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param macAddress [required] Virtual MAC address in 00:00:00:00:00:00 format
	 * @param ipAddress [required] IP address
	 */
	public OvhVirtualMacManagement serviceName_virtualMac_macAddress_virtualAddress_ipAddress_GET(String serviceName, String macAddress, String ipAddress) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/virtualMac/{macAddress}/virtualAddress/{ipAddress}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{macAddress}", macAddress);
		qPath = qPath.replace("{ipAddress}", ipAddress);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhVirtualMacManagement.class);
	}

	/**
	 * Remove this ip from virtual mac , if you remove the last linked Ip, virtualmac will be deleted
	 *
	 * REST: DELETE /dedicated/server/{serviceName}/virtualMac/{macAddress}/virtualAddress/{ipAddress}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param macAddress [required] Virtual MAC address in 00:00:00:00:00:00 format
	 * @param ipAddress [required] IP address
	 */
	public OvhTask serviceName_virtualMac_macAddress_virtualAddress_ipAddress_DELETE(String serviceName, String macAddress, String ipAddress) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/virtualMac/{macAddress}/virtualAddress/{ipAddress}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{macAddress}", macAddress);
		qPath = qPath.replace("{ipAddress}", ipAddress);
		String resp = exec("DELETE", qPath);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * DNS field to temporarily add to your zone so that we can verify you are the owner of this domain
	 *
	 * REST: GET /dedicated/server/{serviceName}/secondaryDnsNameDomainToken
	 * @param domain [required] The domain to check
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhSecondaryDNSCheckField serviceName_secondaryDnsNameDomainToken_GET(String serviceName, String domain) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/secondaryDnsNameDomainToken";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = query(qPath, "domain", domain);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhSecondaryDNSCheckField.class);
	}

	/**
	 * Get hardware RAID size for a given configuration
	 *
	 * REST: GET /dedicated/server/{serviceName}/install/hardwareRaidSize
	 * @param templateName [required] Template name
	 * @param partitionSchemeName [required] Partition scheme name
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhHardwareRaidSize serviceName_install_hardwareRaidSize_GET(String serviceName, String partitionSchemeName, String templateName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/install/hardwareRaidSize";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = query(qPath, "partitionSchemeName", partitionSchemeName);
		qPath = query(qPath, "templateName", templateName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhHardwareRaidSize.class);
	}

	/**
	 * Retrieve hardware RAID profile
	 *
	 * REST: GET /dedicated/server/{serviceName}/install/hardwareRaidProfile
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhHardwareRaidProfile serviceName_install_hardwareRaidProfile_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/install/hardwareRaidProfile";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhHardwareRaidProfile.class);
	}

	/**
	 * Retrieve compatible  install templates names
	 *
	 * REST: GET /dedicated/server/{serviceName}/install/compatibleTemplates
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhInstallTemplate serviceName_install_compatibleTemplates_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/install/compatibleTemplates";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhInstallTemplate.class);
	}

	/**
	 * Gives some capabilities regarding the template for the current dedicated server.
	 *
	 * REST: GET /dedicated/server/{serviceName}/install/templateCapabilities
	 * @param templateName [required]
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhTemplateCaps serviceName_install_templateCapabilities_GET(String serviceName, String templateName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/install/templateCapabilities";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = query(qPath, "templateName", templateName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhTemplateCaps.class);
	}

	/**
	 * Get installation status
	 *
	 * REST: GET /dedicated/server/{serviceName}/install/status
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhInstallationProgressStatus serviceName_install_status_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/install/status";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhInstallationProgressStatus.class);
	}

	/**
	 * Retrieve compatible  install template partitions scheme
	 *
	 * REST: GET /dedicated/server/{serviceName}/install/compatibleTemplatePartitionSchemes
	 * @param templateName [required]
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> serviceName_install_compatibleTemplatePartitionSchemes_GET(String serviceName, String templateName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/install/compatibleTemplatePartitionSchemes";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = query(qPath, "templateName", templateName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}

	/**
	 * Start an install
	 *
	 * REST: POST /dedicated/server/{serviceName}/install/start
	 * @param templateName [required] Template name
	 * @param partitionSchemeName [required] Partition scheme name
	 * @param details [required] parameters for default install
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhTask serviceName_install_start_POST(String serviceName, String templateName, String partitionSchemeName, OvhInstallCustom details) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/install/start";
		qPath = qPath.replace("{serviceName}", serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "templateName", templateName);
		addBody(o, "partitionSchemeName", partitionSchemeName);
		addBody(o, "details", details);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/burst
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhServerBurst serviceName_burst_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/burst";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhServerBurst.class);
	}

	/**
	 * Alter this object properties
	 *
	 * REST: PUT /dedicated/server/{serviceName}/burst
	 * @param body [required] New object properties
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public void serviceName_burst_PUT(String serviceName, OvhServerBurst body) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/burst";
		qPath = qPath.replace("{serviceName}", serviceName);
		exec("PUT", qPath, body);
	}

	/**
	 * Confirm termination of your service
	 *
	 * REST: POST /dedicated/server/{serviceName}/confirmTermination
	 * @param reason Reason of your termination request
	 * @param commentary Commentary about your termination request
	 * @param token [required] The termination token sent by mail to the admin contact
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public String serviceName_confirmTermination_POST(String serviceName, OvhTerminationReasonEnum reason, String commentary, String token) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/confirmTermination";
		qPath = qPath.replace("{serviceName}", serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "reason", reason);
		addBody(o, "commentary", commentary);
		addBody(o, "token", token);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, String.class);
	}

	/**
	 * Server Vracks
	 *
	 * REST: GET /dedicated/server/{serviceName}/vrack
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> serviceName_vrack_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/vrack";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/vrack/{vrack}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param vrack [required] vrack name
	 */
	public OvhDedicatedServer serviceName_vrack_vrack_GET(String serviceName, String vrack) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/vrack/{vrack}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{vrack}", vrack);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhDedicatedServer.class);
	}

	/**
	 * remove this server from this vrack
	 *
	 * REST: DELETE /dedicated/server/{serviceName}/vrack/{vrack}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param vrack [required] vrack name
	 */
	public net.minidev.ovh.api.vrack.OvhTask serviceName_vrack_vrack_DELETE(String serviceName, String vrack) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/vrack/{vrack}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{vrack}", vrack);
		String resp = exec("DELETE", qPath);
		return convertTo(resp, net.minidev.ovh.api.vrack.OvhTask.class);
	}

	/**
	 * Retrieve vrack traffic graph values
	 *
	 * REST: GET /dedicated/server/{serviceName}/vrack/{vrack}/mrtg
	 * @param period [required] mrtg period
	 * @param type [required] mrtg type
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param vrack [required] vrack name
	 */
	public ArrayList<OvhMrtgTimestampValue> serviceName_vrack_vrack_mrtg_GET(String serviceName, String vrack, OvhMrtgPeriodEnum period, OvhMrtgTypeEnum type) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/vrack/{vrack}/mrtg";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{vrack}", vrack);
		qPath = query(qPath, "period", period);
		qPath = query(qPath, "type", type);
		String resp = exec("GET", qPath);
		return convertTo(resp, t7);
	}
	private static TypeReference<ArrayList<OvhMrtgTimestampValue>> t7 = new TypeReference<ArrayList<OvhMrtgTimestampValue>>() {};

	/**
	 * Server compatibles netboots
	 *
	 * REST: GET /dedicated/server/{serviceName}/boot
	 * @param bootType [required] Filter the value of bootType property (=)
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<Long> serviceName_boot_GET(String serviceName, OvhBootTypeEnum bootType) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/boot";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = query(qPath, "bootType", bootType);
		String resp = exec("GET", qPath);
		return convertTo(resp, t6);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/boot/{bootId}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param bootId [required] boot id
	 */
	public OvhNetboot serviceName_boot_bootId_GET(String serviceName, Long bootId) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/boot/{bootId}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{bootId}", bootId.toString());
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhNetboot.class);
	}

	/**
	 * Option used on this netboot
	 *
	 * REST: GET /dedicated/server/{serviceName}/boot/{bootId}/option
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param bootId [required] boot id
	 */
	public ArrayList<OvhBootOptionEnum> serviceName_boot_bootId_option_GET(String serviceName, Long bootId) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/boot/{bootId}/option";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{bootId}", bootId.toString());
		String resp = exec("GET", qPath);
		return convertTo(resp, t8);
	}
	private static TypeReference<ArrayList<OvhBootOptionEnum>> t8 = new TypeReference<ArrayList<OvhBootOptionEnum>>() {};

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/boot/{bootId}/option/{option}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param bootId [required] boot id
	 * @param option [required] The option of this boot
	 */
	public OvhNetbootOption serviceName_boot_bootId_option_option_GET(String serviceName, Long bootId, net.minidev.ovh.api.dedicated.server.OvhBootOptionEnum option) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/boot/{bootId}/option/{option}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{bootId}", bootId.toString());
		qPath = qPath.replace("{option}", option.toString());
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhNetbootOption.class);
	}

	/**
	 * Service monitoring details
	 *
	 * REST: GET /dedicated/server/{serviceName}/serviceMonitoring
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<Long> serviceName_serviceMonitoring_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/serviceMonitoring";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t6);
	}

	/**
	 * Add a new service monitoring
	 *
	 * REST: POST /dedicated/server/{serviceName}/serviceMonitoring
	 * @param protocol [required] The protocol to use
	 * @param challengeText [required] The expected return
	 * @param ip [required] The IP to monitor
	 * @param url [required] The URL to test
	 * @param interval [required] The test interval
	 * @param port [required] The service port to monitor
	 * @param enabled [required] Is this service monitoring is enabled
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhServiceMonitoring serviceName_serviceMonitoring_POST(String serviceName, OvhMonitoringProtocolEnum protocol, String challengeText, String ip, String url, OvhMonitoringIntervalEnum interval, Long port, Boolean enabled) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/serviceMonitoring";
		qPath = qPath.replace("{serviceName}", serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "protocol", protocol);
		addBody(o, "challengeText", challengeText);
		addBody(o, "ip", ip);
		addBody(o, "url", url);
		addBody(o, "interval", interval);
		addBody(o, "port", port);
		addBody(o, "enabled", enabled);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, OvhServiceMonitoring.class);
	}

	/**
	 * Service monitoring alert by email
	 *
	 * REST: GET /dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/email
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param monitoringId [required] This monitoring id
	 */
	public ArrayList<Long> serviceName_serviceMonitoring_monitoringId_alert_email_GET(String serviceName, Long monitoringId) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/email";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{monitoringId}", monitoringId.toString());
		String resp = exec("GET", qPath);
		return convertTo(resp, t6);
	}

	/**
	 * Add a new email alert
	 *
	 * REST: POST /dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/email
	 * @param email [required] Alert destination
	 * @param language [required] Alert language
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param monitoringId [required] This monitoring id
	 */
	public OvhEmailAlert serviceName_serviceMonitoring_monitoringId_alert_email_POST(String serviceName, Long monitoringId, String email, OvhAlertLanguageEnum language) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/email";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{monitoringId}", monitoringId.toString());
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "email", email);
		addBody(o, "language", language);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, OvhEmailAlert.class);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/email/{alertId}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param monitoringId [required] This monitoring id
	 * @param alertId [required] This monitoring id
	 */
	public OvhEmailAlert serviceName_serviceMonitoring_monitoringId_alert_email_alertId_GET(String serviceName, Long monitoringId, Long alertId) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/email/{alertId}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{monitoringId}", monitoringId.toString());
		qPath = qPath.replace("{alertId}", alertId.toString());
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhEmailAlert.class);
	}

	/**
	 * Alter this object properties
	 *
	 * REST: PUT /dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/email/{alertId}
	 * @param body [required] New object properties
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param monitoringId [required] This monitoring id
	 * @param alertId [required] This monitoring id
	 */
	public void serviceName_serviceMonitoring_monitoringId_alert_email_alertId_PUT(String serviceName, Long monitoringId, Long alertId, OvhEmailAlert body) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/email/{alertId}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{monitoringId}", monitoringId.toString());
		qPath = qPath.replace("{alertId}", alertId.toString());
		exec("PUT", qPath, body);
	}

	/**
	 * Remove this Email alert monitoring
	 *
	 * REST: DELETE /dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/email/{alertId}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param monitoringId [required] This monitoring id
	 * @param alertId [required] This monitoring id
	 */
	public void serviceName_serviceMonitoring_monitoringId_alert_email_alertId_DELETE(String serviceName, Long monitoringId, Long alertId) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/email/{alertId}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{monitoringId}", monitoringId.toString());
		qPath = qPath.replace("{alertId}", alertId.toString());
		exec("DELETE", qPath);
	}

	/**
	 * Service monitoring alert by SMS
	 *
	 * REST: GET /dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/sms
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param monitoringId [required] This monitoring id
	 */
	public ArrayList<Long> serviceName_serviceMonitoring_monitoringId_alert_sms_GET(String serviceName, Long monitoringId) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/sms";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{monitoringId}", monitoringId.toString());
		String resp = exec("GET", qPath);
		return convertTo(resp, t6);
	}

	/**
	 * Create a SMS alert
	 *
	 * REST: POST /dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/sms
	 * @param smsAccount [required] Your SMS account
	 * @param phoneNumberTo [required] Alert destination
	 * @param language [required] Alert language
	 * @param toHour [required] Daily hour end time for SMS notification
	 * @param fromHour [required] Daily hour start time for SMS notification
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param monitoringId [required] This monitoring id
	 */
	public OvhSmsAlert serviceName_serviceMonitoring_monitoringId_alert_sms_POST(String serviceName, Long monitoringId, String smsAccount, String phoneNumberTo, OvhAlertLanguageEnum language, Long toHour, Long fromHour) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/sms";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{monitoringId}", monitoringId.toString());
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "smsAccount", smsAccount);
		addBody(o, "phoneNumberTo", phoneNumberTo);
		addBody(o, "language", language);
		addBody(o, "toHour", toHour);
		addBody(o, "fromHour", fromHour);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, OvhSmsAlert.class);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/sms/{alertId}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param monitoringId [required] This monitoring id
	 * @param alertId [required] Id of this alert
	 */
	public OvhSmsAlert serviceName_serviceMonitoring_monitoringId_alert_sms_alertId_GET(String serviceName, Long monitoringId, Long alertId) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/sms/{alertId}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{monitoringId}", monitoringId.toString());
		qPath = qPath.replace("{alertId}", alertId.toString());
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhSmsAlert.class);
	}

	/**
	 * Alter this object properties
	 *
	 * REST: PUT /dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/sms/{alertId}
	 * @param body [required] New object properties
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param monitoringId [required] This monitoring id
	 * @param alertId [required] Id of this alert
	 */
	public void serviceName_serviceMonitoring_monitoringId_alert_sms_alertId_PUT(String serviceName, Long monitoringId, Long alertId, OvhSmsAlert body) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/sms/{alertId}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{monitoringId}", monitoringId.toString());
		qPath = qPath.replace("{alertId}", alertId.toString());
		exec("PUT", qPath, body);
	}

	/**
	 * Remove this SMS alert
	 *
	 * REST: DELETE /dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/sms/{alertId}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param monitoringId [required] This monitoring id
	 * @param alertId [required] Id of this alert
	 */
	public void serviceName_serviceMonitoring_monitoringId_alert_sms_alertId_DELETE(String serviceName, Long monitoringId, Long alertId) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}/alert/sms/{alertId}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{monitoringId}", monitoringId.toString());
		qPath = qPath.replace("{alertId}", alertId.toString());
		exec("DELETE", qPath);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param monitoringId [required] This monitoring id
	 */
	public OvhServiceMonitoring serviceName_serviceMonitoring_monitoringId_GET(String serviceName, Long monitoringId) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{monitoringId}", monitoringId.toString());
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhServiceMonitoring.class);
	}

	/**
	 * Alter this object properties
	 *
	 * REST: PUT /dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}
	 * @param body [required] New object properties
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param monitoringId [required] This monitoring id
	 */
	public void serviceName_serviceMonitoring_monitoringId_PUT(String serviceName, Long monitoringId, OvhServiceMonitoring body) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{monitoringId}", monitoringId.toString());
		exec("PUT", qPath, body);
	}

	/**
	 * Remove this service monitoring
	 *
	 * REST: DELETE /dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param monitoringId [required] This monitoring id
	 */
	public void serviceName_serviceMonitoring_monitoringId_DELETE(String serviceName, Long monitoringId) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/serviceMonitoring/{monitoringId}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{monitoringId}", monitoringId.toString());
		exec("DELETE", qPath);
	}

	/**
	 * Move an Ip failover to this server
	 *
	 * REST: POST /dedicated/server/{serviceName}/ipMove
	 * @param ip [required] The ip to move to this server
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhTask serviceName_ipMove_POST(String serviceName, String ip) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/ipMove";
		qPath = qPath.replace("{serviceName}", serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "ip", ip);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Ask for a broken HDD replacement
	 *
	 * REST: POST /dedicated/server/{serviceName}/support/replace/hardDiskDrive
	 * @param disks [required] If 'inverse' is set as 'false', the list of HDD TO REPLACE. If 'inverse' is set as 'true', the list of HDD TO NOT REPLACE.
	 * @param comment [required] User comment
	 * @param inverse [required] If set to 'true', replace only NON LISTED DISKS
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhNewMessageInfo serviceName_support_replace_hardDiskDrive_POST(String serviceName, OvhSupportReplaceHddInfo[] disks, String comment, Boolean inverse) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/support/replace/hardDiskDrive";
		qPath = qPath.replace("{serviceName}", serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "disks", disks);
		addBody(o, "comment", comment);
		addBody(o, "inverse", inverse);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, OvhNewMessageInfo.class);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/serviceInfos
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhService serviceName_serviceInfos_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/serviceInfos";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhService.class);
	}

	/**
	 * Alter this object properties
	 *
	 * REST: PUT /dedicated/server/{serviceName}/serviceInfos
	 * @param body [required] New object properties
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public void serviceName_serviceInfos_PUT(String serviceName, OvhService body) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/serviceInfos";
		qPath = qPath.replace("{serviceName}", serviceName);
		exec("PUT", qPath, body);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/secondaryDnsDomains/{domain}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param domain [required] domain on slave server
	 */
	public OvhSecondaryDNS serviceName_secondaryDnsDomains_domain_GET(String serviceName, String domain) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/secondaryDnsDomains/{domain}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{domain}", domain);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhSecondaryDNS.class);
	}

	/**
	 * Alter this object properties
	 *
	 * REST: PUT /dedicated/server/{serviceName}/secondaryDnsDomains/{domain}
	 * @param body [required] New object properties
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param domain [required] domain on slave server
	 */
	public void serviceName_secondaryDnsDomains_domain_PUT(String serviceName, String domain, OvhSecondaryDNS body) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/secondaryDnsDomains/{domain}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{domain}", domain);
		exec("PUT", qPath, body);
	}

	/**
	 * remove this domain
	 *
	 * REST: DELETE /dedicated/server/{serviceName}/secondaryDnsDomains/{domain}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param domain [required] domain on slave server
	 */
	public void serviceName_secondaryDnsDomains_domain_DELETE(String serviceName, String domain) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/secondaryDnsDomains/{domain}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{domain}", domain);
		exec("DELETE", qPath);
	}

	/**
	 * domain name server informations
	 *
	 * REST: GET /dedicated/server/{serviceName}/secondaryDnsDomains/{domain}/dnsServer
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param domain [required] domain on slave server
	 */
	public OvhSecondaryDNSNameServer serviceName_secondaryDnsDomains_domain_dnsServer_GET(String serviceName, String domain) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/secondaryDnsDomains/{domain}/dnsServer";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{domain}", domain);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhSecondaryDNSNameServer.class);
	}

	/**
	 * List of secondary dns domain name
	 *
	 * REST: GET /dedicated/server/{serviceName}/secondaryDnsDomains
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> serviceName_secondaryDnsDomains_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/secondaryDnsDomains";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}

	/**
	 * add a domain on secondary dns
	 *
	 * REST: POST /dedicated/server/{serviceName}/secondaryDnsDomains
	 * @param domain [required] The domain to add
	 * @param ip [required]
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public void serviceName_secondaryDnsDomains_POST(String serviceName, String domain, String ip) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/secondaryDnsDomains";
		qPath = qPath.replace("{serviceName}", serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "domain", domain);
		addBody(o, "ip", ip);
		exec("POST", qPath, o);
	}

	/**
	 * Retrieve available country for IP order
	 *
	 * REST: GET /dedicated/server/{serviceName}/ipCountryAvailable
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<OvhIpCountryEnum> serviceName_ipCountryAvailable_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/ipCountryAvailable";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t9);
	}
	private static TypeReference<ArrayList<OvhIpCountryEnum>> t9 = new TypeReference<ArrayList<OvhIpCountryEnum>>() {};

	/**
	 * Terminate your service
	 *
	 * REST: POST /dedicated/server/{serviceName}/terminate
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public String serviceName_terminate_POST(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/terminate";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("POST", qPath);
		return convertTo(resp, String.class);
	}

	/**
	 * Launch a contact change procedure
	 *
	 * REST: POST /dedicated/server/{serviceName}/changeContact
	 * @param contactAdmin The contact to set as admin contact
	 * @param contactTech The contact to set as tech contact
	 * @param contactBilling The contact to set as billing contact
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<Long> serviceName_changeContact_POST(String serviceName, String contactAdmin, String contactTech, String contactBilling) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/changeContact";
		qPath = qPath.replace("{serviceName}", serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "contactAdmin", contactAdmin);
		addBody(o, "contactTech", contactTech);
		addBody(o, "contactBilling", contactBilling);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, t6);
	}

	/**
	 * Retrieve traffic graph values
	 *
	 * REST: GET /dedicated/server/{serviceName}/mrtg
	 * @param period [required] mrtg period
	 * @param type [required] mrtg type
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<OvhMrtgTimestampValue> serviceName_mrtg_GET(String serviceName, OvhMrtgPeriodEnum period, OvhMrtgTypeEnum type) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/mrtg";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = query(qPath, "period", period);
		qPath = query(qPath, "type", type);
		String resp = exec("GET", qPath);
		return convertTo(resp, t7);
	}

	/**
	 * List of dedicated server options
	 *
	 * REST: GET /dedicated/server/{serviceName}/option
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<OvhOptionEnum> serviceName_option_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/option";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t10);
	}
	private static TypeReference<ArrayList<OvhOptionEnum>> t10 = new TypeReference<ArrayList<OvhOptionEnum>>() {};

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/option/{option}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param option [required] The option name
	 */
	public OvhOption serviceName_option_option_GET(String serviceName, net.minidev.ovh.api.dedicated.server.OvhOptionEnum option) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/option/{option}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{option}", option.toString());
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhOption.class);
	}

	/**
	 * Release a given option
	 *
	 * REST: DELETE /dedicated/server/{serviceName}/option/{option}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param option [required] The option name
	 */
	public void serviceName_option_option_DELETE(String serviceName, net.minidev.ovh.api.dedicated.server.OvhOptionEnum option) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/option/{option}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{option}", option.toString());
		exec("DELETE", qPath);
	}

	/**
	 * Check if given IP can be moved to this server
	 *
	 * REST: GET /dedicated/server/{serviceName}/ipCanBeMovedTo
	 * @param ip [required] The ip to move to this server
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public void serviceName_ipCanBeMovedTo_GET(String serviceName, String ip) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/ipCanBeMovedTo";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = query(qPath, "ip", ip);
		exec("GET", qPath);
	}

	/**
	 * Hard reboot this server
	 *
	 * REST: POST /dedicated/server/{serviceName}/reboot
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhTask serviceName_reboot_POST(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/reboot";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("POST", qPath);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/features/firewall
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhFirewall serviceName_features_firewall_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/firewall";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhFirewall.class);
	}

	/**
	 * Alter this object properties
	 *
	 * REST: PUT /dedicated/server/{serviceName}/features/firewall
	 * @param body [required] New object properties
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public void serviceName_features_firewall_PUT(String serviceName, OvhFirewall body) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/firewall";
		qPath = qPath.replace("{serviceName}", serviceName);
		exec("PUT", qPath, body);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/features/backupFTP
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhBackupFtp serviceName_features_backupFTP_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/backupFTP";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhBackupFtp.class);
	}

	/**
	 * Create a new Backup FTP space
	 *
	 * REST: POST /dedicated/server/{serviceName}/features/backupFTP
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhTask serviceName_features_backupFTP_POST(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/backupFTP";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("POST", qPath);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Terminate your Backup FTP service, ALL DATA WILL BE PERMANENTLY DELETED
	 *
	 * REST: DELETE /dedicated/server/{serviceName}/features/backupFTP
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhTask serviceName_features_backupFTP_DELETE(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/backupFTP";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("DELETE", qPath);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Change your Backup FTP password
	 *
	 * REST: POST /dedicated/server/{serviceName}/features/backupFTP/password
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhTask serviceName_features_backupFTP_password_POST(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/backupFTP/password";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("POST", qPath);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get all IP blocks that can be used in the ACL
	 *
	 * REST: GET /dedicated/server/{serviceName}/features/backupFTP/authorizableBlocks
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> serviceName_features_backupFTP_authorizableBlocks_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/backupFTP/authorizableBlocks";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}

	/**
	 * List of IP blocks (and protocols to allow on these blocks) authorized on your backup FTP
	 *
	 * REST: GET /dedicated/server/{serviceName}/features/backupFTP/access
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<String> serviceName_features_backupFTP_access_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/backupFTP/access";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}

	/**
	 * Create a new Backup FTP ACL
	 *
	 * REST: POST /dedicated/server/{serviceName}/features/backupFTP/access
	 * @param ftp [required] Wether to allow the FTP protocol for this ACL
	 * @param ipBlock [required] The IP Block specific to this ACL. It musts belong to your server.
	 * @param nfs [required] Wether to allow the NFS protocol for this ACL
	 * @param cifs [required] Wether to allow the CIFS (SMB) protocol for this ACL
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhTask serviceName_features_backupFTP_access_POST(String serviceName, Boolean ftp, String ipBlock, Boolean nfs, Boolean cifs) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/backupFTP/access";
		qPath = qPath.replace("{serviceName}", serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "ftp", ftp);
		addBody(o, "ipBlock", ipBlock);
		addBody(o, "nfs", nfs);
		addBody(o, "cifs", cifs);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/features/backupFTP/access/{ipBlock}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param ipBlock [required] The IP Block specific to this ACL
	 */
	public OvhBackupFtpAcl serviceName_features_backupFTP_access_ipBlock_GET(String serviceName, String ipBlock) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/backupFTP/access/{ipBlock}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{ipBlock}", ipBlock);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhBackupFtpAcl.class);
	}

	/**
	 * Alter this object properties
	 *
	 * REST: PUT /dedicated/server/{serviceName}/features/backupFTP/access/{ipBlock}
	 * @param body [required] New object properties
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param ipBlock [required] The IP Block specific to this ACL
	 */
	public void serviceName_features_backupFTP_access_ipBlock_PUT(String serviceName, String ipBlock, OvhBackupFtpAcl body) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/backupFTP/access/{ipBlock}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{ipBlock}", ipBlock);
		exec("PUT", qPath, body);
	}

	/**
	 * Revoke this ACL
	 *
	 * REST: DELETE /dedicated/server/{serviceName}/features/backupFTP/access/{ipBlock}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param ipBlock [required] The IP Block specific to this ACL
	 */
	public OvhTask serviceName_features_backupFTP_access_ipBlock_DELETE(String serviceName, String ipBlock) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/backupFTP/access/{ipBlock}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{ipBlock}", ipBlock);
		String resp = exec("DELETE", qPath);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/features/ipmi
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhIpmi serviceName_features_ipmi_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/ipmi";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhIpmi.class);
	}

	/**
	 * Launch test on KVM IPMI interface
	 *
	 * REST: POST /dedicated/server/{serviceName}/features/ipmi/test
	 * @param ttl [required] Result time to live in minutes
	 * @param type [required] Test to make on KVM IPMI interface
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhTask serviceName_features_ipmi_test_POST(String serviceName, OvhCacheTTLEnum ttl, OvhIpmiTestTypeEnum type) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/ipmi/test";
		qPath = qPath.replace("{serviceName}", serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "ttl", ttl);
		addBody(o, "type", type);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Result of http, ping and identification tests on IPMI interface
	 *
	 * REST: GET /dedicated/server/{serviceName}/features/ipmi/test
	 * @param type [required] Test type result on KVM IPMI interface
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhIpmiTestResult serviceName_features_ipmi_test_GET(String serviceName, OvhIpmiTestTypeEnum type) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/ipmi/test";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = query(qPath, "type", type);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhIpmiTestResult.class);
	}

	/**
	 * Reset KVM IPMI interface
	 *
	 * REST: POST /dedicated/server/{serviceName}/features/ipmi/resetInterface
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhTask serviceName_features_ipmi_resetInterface_POST(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/ipmi/resetInterface";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("POST", qPath);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Request an acces on KVM IPMI interface
	 *
	 * REST: POST /dedicated/server/{serviceName}/features/ipmi/access
	 * @param ipToAllow [required] IP to allow connection from for this IPMI session
	 * @param sshKey [required] SSH key name to allow access on KVM/IP interface with (name from /me/sshKey)
	 * @param ttl [required] Session access time to live in minutes
	 * @param type [required] IPMI console access
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhTask serviceName_features_ipmi_access_POST(String serviceName, String ipToAllow, String sshKey, OvhCacheTTLEnum ttl, OvhIpmiAccessTypeEnum type) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/ipmi/access";
		qPath = qPath.replace("{serviceName}", serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "ipToAllow", ipToAllow);
		addBody(o, "sshKey", sshKey);
		addBody(o, "ttl", ttl);
		addBody(o, "type", type);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * IPMI access method
	 *
	 * REST: GET /dedicated/server/{serviceName}/features/ipmi/access
	 * @param type [required] IPMI console access
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhIpmiAccessValue serviceName_features_ipmi_access_GET(String serviceName, OvhIpmiAccessTypeEnum type) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/ipmi/access";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = query(qPath, "type", type);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhIpmiAccessValue.class);
	}

	/**
	 * Reset KVM IPMI sessions
	 *
	 * REST: POST /dedicated/server/{serviceName}/features/ipmi/resetSessions
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhTask serviceName_features_ipmi_resetSessions_POST(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/ipmi/resetSessions";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("POST", qPath);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/features/kvm
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhKvm serviceName_features_kvm_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/features/kvm";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhKvm.class);
	}

	/**
	 * Dedicated server todos
	 *
	 * REST: GET /dedicated/server/{serviceName}/task
	 * @param function [required] Filter the value of function property (=)
	 * @param status [required] Filter the value of status property (=)
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<Long> serviceName_task_GET(String serviceName, OvhTaskFunctionEnum function, OvhTaskStatusEnum status) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/task";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = query(qPath, "function", function);
		qPath = query(qPath, "status", status);
		String resp = exec("GET", qPath);
		return convertTo(resp, t6);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/task/{taskId}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param taskId [required] the id of the task
	 */
	public OvhTask serviceName_task_taskId_GET(String serviceName, Long taskId) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/task/{taskId}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{taskId}", taskId.toString());
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * this action stop the task progression if it's possible
	 *
	 * REST: POST /dedicated/server/{serviceName}/task/{taskId}/cancel
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param taskId [required] the id of the task
	 */
	public void serviceName_task_taskId_cancel_POST(String serviceName, Long taskId) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/task/{taskId}/cancel";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{taskId}", taskId.toString());
		exec("POST", qPath);
	}

	/**
	 * Is a KVM express orderable with your server
	 *
	 * REST: GET /dedicated/server/{serviceName}/orderable/kvmExpress
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public Boolean serviceName_orderable_kvmExpress_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/orderable/kvmExpress";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, Boolean.class);
	}

	/**
	 * Is professional use orderable with your server
	 *
	 * REST: GET /dedicated/server/{serviceName}/orderable/professionalUse
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public Boolean serviceName_orderable_professionalUse_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/orderable/professionalUse";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, Boolean.class);
	}

	/**
	 * Get IP orderable with your server.
	 *
	 * REST: GET /dedicated/server/{serviceName}/orderable/ip
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhIpOrderable serviceName_orderable_ip_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/orderable/ip";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhIpOrderable.class);
	}

	/**
	 * Get USB keys orderable with your server
	 *
	 * REST: GET /dedicated/server/{serviceName}/orderable/usbKey
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhUsbKeyOrderableDetails serviceName_orderable_usbKey_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/orderable/usbKey";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhUsbKeyOrderableDetails.class);
	}

	/**
	 * Get the backup storage orderable with your server.
	 *
	 * REST: GET /dedicated/server/{serviceName}/orderable/backupStorage
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhBackupStorageOrderable serviceName_orderable_backupStorage_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/orderable/backupStorage";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhBackupStorageOrderable.class);
	}

	/**
	 * Is a KVM orderable with your server
	 *
	 * REST: GET /dedicated/server/{serviceName}/orderable/kvm
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public Boolean serviceName_orderable_kvm_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/orderable/kvm";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, Boolean.class);
	}

	/**
	 * Is this feature orderable with your server
	 *
	 * REST: GET /dedicated/server/{serviceName}/orderable/feature
	 * @param feature [required] the feature
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public Boolean serviceName_orderable_feature_GET(String serviceName, OvhOrderableSysFeatureEnum feature) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/orderable/feature";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = query(qPath, "feature", feature);
		String resp = exec("GET", qPath);
		return convertTo(resp, Boolean.class);
	}

	/**
	 * Get bandwidth orderable with your server.
	 *
	 * REST: GET /dedicated/server/{serviceName}/orderable/bandwidth
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhBandwidthOrderable serviceName_orderable_bandwidth_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/orderable/bandwidth";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhBandwidthOrderable.class);
	}

	/**
	 * Add your existing windows license serial to this dedicated server. Will be manageable in /license/windows.
	 *
	 * REST: POST /dedicated/server/{serviceName}/license/windows
	 * @param licenseId [required] Your license serial number
	 * @param version [required] Your license version
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhTask serviceName_license_windows_POST(String serviceName, String licenseId, OvhWindowsOsVersionEnum version) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/license/windows";
		qPath = qPath.replace("{serviceName}", serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "licenseId", licenseId);
		addBody(o, "version", version);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get the windows SQL server license compliant with your server.
	 *
	 * REST: GET /dedicated/server/{serviceName}/license/compliantWindowsSqlServer
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<OvhWindowsSqlVersionEnum> serviceName_license_compliantWindowsSqlServer_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/license/compliantWindowsSqlServer";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t11);
	}
	private static TypeReference<ArrayList<OvhWindowsSqlVersionEnum>> t11 = new TypeReference<ArrayList<OvhWindowsSqlVersionEnum>>() {};

	/**
	 * Get the windows license compliant with your server.
	 *
	 * REST: GET /dedicated/server/{serviceName}/license/compliantWindows
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<OvhWindowsOsVersionEnum> serviceName_license_compliantWindows_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/license/compliantWindows";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t12);
	}
	private static TypeReference<ArrayList<OvhWindowsOsVersionEnum>> t12 = new TypeReference<ArrayList<OvhWindowsOsVersionEnum>>() {};

	/**
	 * Your own SPLA licenses attached to this dedicated server
	 *
	 * REST: GET /dedicated/server/{serviceName}/spla
	 * @param status [required] Filter the value of status property (=)
	 * @param type [required] Filter the value of type property (=)
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public ArrayList<Long> serviceName_spla_GET(String serviceName, OvhSplaStatusEnum status, OvhSplaTypeEnum type) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/spla";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = query(qPath, "status", status);
		qPath = query(qPath, "type", type);
		String resp = exec("GET", qPath);
		return convertTo(resp, t6);
	}

	/**
	 * Add a new SPLA license
	 *
	 * REST: POST /dedicated/server/{serviceName}/spla
	 * @param type [required] License type
	 * @param serialNumber [required] License serial number
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public Long serviceName_spla_POST(String serviceName, OvhSplaTypeEnum type, String serialNumber) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/spla";
		qPath = qPath.replace("{serviceName}", serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "type", type);
		addBody(o, "serialNumber", serialNumber);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, Long.class);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /dedicated/server/{serviceName}/spla/{id}
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param id [required] License id
	 */
	public OvhSpla serviceName_spla_id_GET(String serviceName, Long id) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/spla/{id}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{id}", id.toString());
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhSpla.class);
	}

	/**
	 * Alter this object properties
	 *
	 * REST: PUT /dedicated/server/{serviceName}/spla/{id}
	 * @param body [required] New object properties
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param id [required] License id
	 */
	public void serviceName_spla_id_PUT(String serviceName, Long id, OvhSpla body) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/spla/{id}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{id}", id.toString());
		exec("PUT", qPath, body);
	}

	/**
	 * Revoke an SPLA license
	 *
	 * REST: POST /dedicated/server/{serviceName}/spla/{id}/revoke
	 * @param serviceName [required] The internal name of your dedicated server
	 * @param id [required] License id
	 */
	public void serviceName_spla_id_revoke_POST(String serviceName, Long id) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/spla/{id}/revoke";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{id}", id.toString());
		exec("POST", qPath);
	}

	/**
	 * Retrieve network informations about this dedicated server
	 *
	 * REST: GET /dedicated/server/{serviceName}/specifications/network
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhNetworkSpecifications serviceName_specifications_network_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/specifications/network";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhNetworkSpecifications.class);
	}

	/**
	 * Retrieve IP capabilities about this dedicated server
	 *
	 * REST: GET /dedicated/server/{serviceName}/specifications/ip
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhIpOrderable serviceName_specifications_ip_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/specifications/ip";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhIpOrderable.class);
	}

	/**
	 * Retrieve hardware informations about this dedicated server
	 *
	 * REST: GET /dedicated/server/{serviceName}/specifications/hardware
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhHardwareSpecifications serviceName_specifications_hardware_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/specifications/hardware";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhHardwareSpecifications.class);
	}

	/**
	 * Secondary nameServer available for your Server
	 *
	 * REST: GET /dedicated/server/{serviceName}/secondaryDnsNameServerAvailable
	 * @param serviceName [required] The internal name of your dedicated server
	 */
	public OvhSecondaryDNSNameServer serviceName_secondaryDnsNameServerAvailable_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/server/{serviceName}/secondaryDnsNameServerAvailable";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhSecondaryDNSNameServer.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /dedicated/server
	 */
	public ArrayList<String> GET() throws IOException {
		String qPath = "/dedicated/server";
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}

	/**
	 * List the availability of dedicated server
	 *
	 * REST: GET /dedicated/server/availabilities
	 * @param country [required] The subsidiary company where the availability is requested
	 * @param hardware [required] The kind of hardware which is requested
	 */
	public ArrayList<OvhAvailabilities> availabilities_GET(OvhOvhSubsidiaryEnum country, String hardware) throws IOException {
		String qPath = "/dedicated/server/availabilities";
		qPath = query(qPath, "country", country);
		qPath = query(qPath, "hardware", hardware);
		String resp = execN("GET", qPath);
		return convertTo(resp, t13);
	}
	private static TypeReference<ArrayList<OvhAvailabilities>> t13 = new TypeReference<ArrayList<OvhAvailabilities>>() {};
}
