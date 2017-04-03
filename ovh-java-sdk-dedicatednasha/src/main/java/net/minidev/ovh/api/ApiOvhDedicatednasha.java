package net.minidev.ovh.api;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import net.minidev.ovh.api.complextype.OvhUnitAndValue;
import net.minidev.ovh.api.dedicated.OvhNasHAAvailabilities;
import net.minidev.ovh.api.dedicated.OvhTaskStatusEnum;
import net.minidev.ovh.api.dedicated.nasha.OvhAccess;
import net.minidev.ovh.api.dedicated.nasha.OvhCustomSnap;
import net.minidev.ovh.api.dedicated.nasha.OvhOptions;
import net.minidev.ovh.api.dedicated.nasha.OvhPartition;
import net.minidev.ovh.api.dedicated.nasha.OvhQuota;
import net.minidev.ovh.api.dedicated.nasha.OvhSnapshot;
import net.minidev.ovh.api.dedicated.nasha.OvhStorage;
import net.minidev.ovh.api.dedicated.nastask.OvhTask;
import net.minidev.ovh.api.dedicated.storage.OvhAclTypeEnum;
import net.minidev.ovh.api.dedicated.storage.OvhAtimeEnum;
import net.minidev.ovh.api.dedicated.storage.OvhNasUsageTypeEnum;
import net.minidev.ovh.api.dedicated.storage.OvhPartitionUsageTypeEnum;
import net.minidev.ovh.api.dedicated.storage.OvhProtocolEnum;
import net.minidev.ovh.api.dedicated.storage.OvhRecordSizeEnum;
import net.minidev.ovh.api.dedicated.storage.OvhSnapshotEnum;
import net.minidev.ovh.api.dedicated.storage.OvhSyncEnum;
import net.minidev.ovh.api.dedicated.storage.OvhTaskFunctionEnum;
import net.minidev.ovh.api.service.OvhTerminationReasonEnum;
import net.minidev.ovh.api.services.OvhService;
import net.minidev.ovh.core.ApiOvhBase;
import net.minidev.ovh.core.ApiOvhCore;

/**
 * BasePath:https://api.ovh.com/1.0
 * ResourcePath:/dedicated/nasha
 * version:1.0
 */
public class ApiOvhDedicatednasha extends ApiOvhBase {
	public ApiOvhDedicatednasha(ApiOvhCore core) {
		super(core);
	}

	/**
	 * Get this object properties
	 * 
	 * REST: GET /dedicated/nasha/{serviceName}/serviceInfos
	 * @param serviceName [required] The internal name of your storage
	 */
	public OvhService serviceName_serviceInfos_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/serviceInfos";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhService.class);
	}

	/**
	 * Alter this object properties
	 * 
	 * REST: PUT /dedicated/nasha/{serviceName}/serviceInfos
	 * @param null [required] New object properties
	 * @param serviceName [required] The internal name of your storage
	 */
	public void serviceName_serviceInfos_PUT(String serviceName, OvhService body) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/serviceInfos";
		qPath = qPath.replace("{serviceName}", serviceName);
		exec("PUT", qPath, body);
	}

	/**
	 * Get this object properties
	 * 
	 * REST: GET /dedicated/nasha/{serviceName}
	 * @param serviceName [required] The internal name of your storage
	 */
	public OvhStorage serviceName_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhStorage.class);
	}

	/**
	 * Alter this object properties
	 * 
	 * REST: PUT /dedicated/nasha/{serviceName}
	 * @param null [required] New object properties
	 * @param serviceName [required] The internal name of your storage
	 */
	public void serviceName_PUT(String serviceName, OvhStorage body) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}";
		qPath = qPath.replace("{serviceName}", serviceName);
		exec("PUT", qPath, body);
	}

	/**
	 * Confirm termination of your service
	 * 
	 * REST: POST /dedicated/nasha/{serviceName}/confirmTermination
	 * @param reason Reason of your termination request
	 * @param commentary Commentary about your termination request
	 * @param token [required] The termination token sent by mail to the admin contact
	 * @param serviceName [required] The internal name of your storage
	 */
	public String serviceName_confirmTermination_POST(String serviceName, OvhTerminationReasonEnum reason, String commentary, String token) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/confirmTermination";
		qPath = qPath.replace("{serviceName}", serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "reason", reason);
		addBody(o, "commentary", commentary);
		addBody(o, "token", token);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, String.class);
	}

	/**
	 * Terminate your service
	 * 
	 * REST: POST /dedicated/nasha/{serviceName}/terminate
	 * @param serviceName [required] The internal name of your storage
	 */
	public String serviceName_terminate_POST(String serviceName) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/terminate";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("POST", qPath);
		return convertTo(resp, String.class);
	}

	/**
	 * View task list
	 * 
	 * REST: GET /dedicated/nasha/{serviceName}/task
	 * @param status [required] Filter the value of status property (=)
	 * @param operation [required] Filter the value of operation property (=)
	 * @param serviceName [required] The internal name of your storage
	 */
	public ArrayList<Long> serviceName_task_GET(String serviceName, OvhTaskFunctionEnum operation, OvhTaskStatusEnum status) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/task";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = query(qPath, "operation", operation);
		qPath = query(qPath, "status", status);
		String resp = exec("GET", qPath);
		return convertTo(resp, t1);
	}
	private static TypeReference<ArrayList<Long>> t1 = new TypeReference<ArrayList<Long>>() {};

	/**
	 * Get this object properties
	 * 
	 * REST: GET /dedicated/nasha/{serviceName}/task/{taskId}
	 * @param serviceName [required] The internal name of your storage
	 * @param taskId [required] id of the task
	 */
	public OvhTask serviceName_task_taskId_GET(String serviceName, Long taskId) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/task/{taskId}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{taskId}", taskId.toString());
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Launch a contact change procedure
	 * 
	 * REST: POST /dedicated/nasha/{serviceName}/changeContact
	 * @param contactAdmin The contact to set as admin contact
	 * @param contactTech The contact to set as tech contact
	 * @param contactBilling The contact to set as billing contact
	 * @param serviceName [required] The internal name of your storage
	 */
	public ArrayList<Long> serviceName_changeContact_POST(String serviceName, String contactAdmin, String contactTech, String contactBilling) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/changeContact";
		qPath = qPath.replace("{serviceName}", serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "contactAdmin", contactAdmin);
		addBody(o, "contactTech", contactTech);
		addBody(o, "contactBilling", contactBilling);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, t1);
	}

	/**
	 * Delete the vrack container
	 * 
	 * REST: DELETE /dedicated/nasha/{serviceName}/vrack
	 * @param serviceName [required] The internal name of your storage
	 */
	public OvhTask serviceName_vrack_DELETE(String serviceName) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/vrack";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("DELETE", qPath);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Return statistics about the nas
	 * 
	 * REST: GET /dedicated/nasha/{serviceName}/use
	 * @param type [required] The type of statistic to be fetched
	 * @param serviceName [required] The internal name of your storage
	 */
	public OvhUnitAndValue<Double> serviceName_use_GET(String serviceName, OvhNasUsageTypeEnum type) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/use";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = query(qPath, "type", type);
		String resp = exec("GET", qPath);
		return convertTo(resp, t2);
	}
	private static TypeReference<OvhUnitAndValue<Double>> t2 = new TypeReference<OvhUnitAndValue<Double>>() {};

	/**
	 * Get partition list
	 * 
	 * REST: GET /dedicated/nasha/{serviceName}/partition
	 * @param serviceName [required] The internal name of your storage
	 */
	public ArrayList<String> serviceName_partition_GET(String serviceName) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition";
		qPath = qPath.replace("{serviceName}", serviceName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}
	private static TypeReference<ArrayList<String>> t3 = new TypeReference<ArrayList<String>>() {};

	/**
	 * Create a new partition
	 * 
	 * REST: POST /dedicated/nasha/{serviceName}/partition
	 * @param protocol [required] NFS|CIFS|NFS_CIFS
	 * @param partitionName [required] Partition name
	 * @param size [required] Partition size
	 * @param serviceName [required] The internal name of your storage
	 */
	public OvhTask serviceName_partition_POST(String serviceName, OvhProtocolEnum protocol, String partitionName, Long size) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition";
		qPath = qPath.replace("{serviceName}", serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "protocol", protocol);
		addBody(o, "partitionName", partitionName);
		addBody(o, "size", size);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get quota for this partition
	 * 
	 * REST: GET /dedicated/nasha/{serviceName}/partition/{partitionName}/quota
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 */
	public ArrayList<Long> serviceName_partition_partitionName_quota_GET(String serviceName, String partitionName) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/quota";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t1);
	}

	/**
	 * Set a new quota
	 * 
	 * REST: POST /dedicated/nasha/{serviceName}/partition/{partitionName}/quota
	 * @param uid [required] the uid to set quota on
	 * @param size [required] the size to set in MB
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 */
	public OvhTask serviceName_partition_partitionName_quota_POST(String serviceName, String partitionName, Long uid, Long size) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/quota";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "uid", uid);
		addBody(o, "size", size);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get this object properties
	 * 
	 * REST: GET /dedicated/nasha/{serviceName}/partition/{partitionName}/quota/{uid}
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 * @param uid [required] the uid to set quota on
	 */
	public OvhQuota serviceName_partition_partitionName_quota_uid_GET(String serviceName, String partitionName, Long uid) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/quota/{uid}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		qPath = qPath.replace("{uid}", uid.toString());
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhQuota.class);
	}

	/**
	 * Delete a given quota
	 * 
	 * REST: DELETE /dedicated/nasha/{serviceName}/partition/{partitionName}/quota/{uid}
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 * @param uid [required] the uid to set quota on
	 */
	public OvhTask serviceName_partition_partitionName_quota_uid_DELETE(String serviceName, String partitionName, Long uid) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/quota/{uid}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		qPath = qPath.replace("{uid}", uid.toString());
		String resp = exec("DELETE", qPath);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get this object properties
	 * 
	 * REST: GET /dedicated/nasha/{serviceName}/partition/{partitionName}
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 */
	public OvhPartition serviceName_partition_partitionName_GET(String serviceName, String partitionName) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhPartition.class);
	}

	/**
	 * Alter this object properties
	 * 
	 * REST: PUT /dedicated/nasha/{serviceName}/partition/{partitionName}
	 * @param null [required] New object properties
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 */
	public void serviceName_partition_partitionName_PUT(String serviceName, String partitionName, OvhPartition body) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		exec("PUT", qPath, body);
	}

	/**
	 * Delete this partition
	 * 
	 * REST: DELETE /dedicated/nasha/{serviceName}/partition/{partitionName}
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 */
	public OvhTask serviceName_partition_partitionName_DELETE(String serviceName, String partitionName) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		String resp = exec("DELETE", qPath);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get all RIPE/ARIN blocks that can be used in the ACL
	 * 
	 * REST: GET /dedicated/nasha/{serviceName}/partition/{partitionName}/authorizableBlocks
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 */
	public ArrayList<String> serviceName_partition_partitionName_authorizableBlocks_GET(String serviceName, String partitionName) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/authorizableBlocks";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}

	/**
	 * Get this object properties
	 * 
	 * REST: GET /dedicated/nasha/{serviceName}/partition/{partitionName}/options
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 */
	public OvhOptions serviceName_partition_partitionName_options_GET(String serviceName, String partitionName) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/options";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhOptions.class);
	}

	/**
	 * Setup options
	 * 
	 * REST: POST /dedicated/nasha/{serviceName}/partition/{partitionName}/options
	 * @param recordsize [required] ZFS recordsize
	 * @param sync [required] sync setting
	 * @param atime [required] atime setting
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 */
	public OvhTask serviceName_partition_partitionName_options_POST(String serviceName, String partitionName, OvhRecordSizeEnum recordsize, OvhSyncEnum sync, OvhAtimeEnum atime) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/options";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "recordsize", recordsize);
		addBody(o, "sync", sync);
		addBody(o, "atime", atime);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * get ACL for this partition
	 * 
	 * REST: GET /dedicated/nasha/{serviceName}/partition/{partitionName}/access
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 */
	public ArrayList<String> serviceName_partition_partitionName_access_GET(String serviceName, String partitionName) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/access";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}

	/**
	 * Add a new ACL entry
	 * 
	 * REST: POST /dedicated/nasha/{serviceName}/partition/{partitionName}/access
	 * @param ip [required] Ip or block to add
	 * @param type [required] ACL type
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 */
	public OvhTask serviceName_partition_partitionName_access_POST(String serviceName, String partitionName, String ip, OvhAclTypeEnum type) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/access";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "ip", ip);
		addBody(o, "type", type);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get this object properties
	 * 
	 * REST: GET /dedicated/nasha/{serviceName}/partition/{partitionName}/access/{ip}
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 * @param ip [required] the ip in root on storage
	 */
	public OvhAccess serviceName_partition_partitionName_access_ip_GET(String serviceName, String partitionName, String ip) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/access/{ip}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		qPath = qPath.replace("{ip}", ip);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhAccess.class);
	}

	/**
	 * Delete an ACL entry
	 * 
	 * REST: DELETE /dedicated/nasha/{serviceName}/partition/{partitionName}/access/{ip}
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 * @param ip [required] the ip in root on storage
	 */
	public OvhTask serviceName_partition_partitionName_access_ip_DELETE(String serviceName, String partitionName, String ip) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/access/{ip}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		qPath = qPath.replace("{ip}", ip);
		String resp = exec("DELETE", qPath);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get custom snapshots for this partition
	 * 
	 * REST: GET /dedicated/nasha/{serviceName}/partition/{partitionName}/customSnapshot
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 */
	public ArrayList<String> serviceName_partition_partitionName_customSnapshot_GET(String serviceName, String partitionName) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/customSnapshot";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}

	/**
	 * Create a new snapshot
	 * 
	 * REST: POST /dedicated/nasha/{serviceName}/partition/{partitionName}/customSnapshot
	 * @param expiration [required] optional expiration date/time, in iso8601 format
	 * @param name [required] the name of the snapshot
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 */
	public OvhTask serviceName_partition_partitionName_customSnapshot_POST(String serviceName, String partitionName, String expiration, String name) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/customSnapshot";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "expiration", expiration);
		addBody(o, "name", name);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get this object properties
	 * 
	 * REST: GET /dedicated/nasha/{serviceName}/partition/{partitionName}/customSnapshot/{name}
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 * @param name [required] name of the snapshot
	 */
	public OvhCustomSnap serviceName_partition_partitionName_customSnapshot_name_GET(String serviceName, String partitionName, String name) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/customSnapshot/{name}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		qPath = qPath.replace("{name}", name);
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhCustomSnap.class);
	}

	/**
	 * Delete a given snapshot
	 * 
	 * REST: DELETE /dedicated/nasha/{serviceName}/partition/{partitionName}/customSnapshot/{name}
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 * @param name [required] name of the snapshot
	 */
	public OvhTask serviceName_partition_partitionName_customSnapshot_name_DELETE(String serviceName, String partitionName, String name) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/customSnapshot/{name}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		qPath = qPath.replace("{name}", name);
		String resp = exec("DELETE", qPath);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Return statistics about the partition
	 * 
	 * REST: GET /dedicated/nasha/{serviceName}/partition/{partitionName}/use
	 * @param type [required] The type of statistic to be fetched
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 */
	public OvhUnitAndValue<Double> serviceName_partition_partitionName_use_GET(String serviceName, String partitionName, OvhPartitionUsageTypeEnum type) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/use";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		qPath = query(qPath, "type", type);
		String resp = exec("GET", qPath);
		return convertTo(resp, t2);
	}

	/**
	 * Get all IPs that can be used in the ACL
	 * 
	 * REST: GET /dedicated/nasha/{serviceName}/partition/{partitionName}/authorizableIps
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 */
	public ArrayList<String> serviceName_partition_partitionName_authorizableIps_GET(String serviceName, String partitionName) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/authorizableIps";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}

	/**
	 * Get scheduled snapshot types for this partition
	 * 
	 * REST: GET /dedicated/nasha/{serviceName}/partition/{partitionName}/snapshot
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 */
	public ArrayList<OvhSnapshotEnum> serviceName_partition_partitionName_snapshot_GET(String serviceName, String partitionName) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/snapshot";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		String resp = exec("GET", qPath);
		return convertTo(resp, t4);
	}
	private static TypeReference<ArrayList<OvhSnapshotEnum>> t4 = new TypeReference<ArrayList<OvhSnapshotEnum>>() {};

	/**
	 * Schedule a new snapshot type
	 * 
	 * REST: POST /dedicated/nasha/{serviceName}/partition/{partitionName}/snapshot
	 * @param snapshotType [required] Snapshot interval to add
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 */
	public OvhTask serviceName_partition_partitionName_snapshot_POST(String serviceName, String partitionName, OvhSnapshotEnum snapshotType) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/snapshot";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "snapshotType", snapshotType);
		String resp = exec("POST", qPath, o);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get this object properties
	 * 
	 * REST: GET /dedicated/nasha/{serviceName}/partition/{partitionName}/snapshot/{snapshotType}
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 * @param snapshotType [required] the interval of snapshot
	 */
	public OvhSnapshot serviceName_partition_partitionName_snapshot_snapshotType_GET(String serviceName, String partitionName, net.minidev.ovh.api.dedicated.storage.OvhSnapshotEnum snapshotType) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/snapshot/{snapshotType}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		qPath = qPath.replace("{snapshotType}", snapshotType.toString());
		String resp = exec("GET", qPath);
		return convertTo(resp, OvhSnapshot.class);
	}

	/**
	 * Delete a given snapshot
	 * 
	 * REST: DELETE /dedicated/nasha/{serviceName}/partition/{partitionName}/snapshot/{snapshotType}
	 * @param serviceName [required] The internal name of your storage
	 * @param partitionName [required] the given name of partition
	 * @param snapshotType [required] the interval of snapshot
	 */
	public OvhTask serviceName_partition_partitionName_snapshot_snapshotType_DELETE(String serviceName, String partitionName, net.minidev.ovh.api.dedicated.storage.OvhSnapshotEnum snapshotType) throws IOException {
		String qPath = "/dedicated/nasha/{serviceName}/partition/{partitionName}/snapshot/{snapshotType}";
		qPath = qPath.replace("{serviceName}", serviceName);
		qPath = qPath.replace("{partitionName}", partitionName);
		qPath = qPath.replace("{snapshotType}", snapshotType.toString());
		String resp = exec("DELETE", qPath);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * List available services
	 * 
	 * REST: GET /dedicated/nasha
	 */
	public ArrayList<String> GET() throws IOException {
		String qPath = "/dedicated/nasha";
		String resp = exec("GET", qPath);
		return convertTo(resp, t3);
	}

	/**
	 * Get availabilities of nasha offer
	 * 
	 * REST: GET /dedicated/nasha/availabilities
	 */
	public ArrayList<OvhNasHAAvailabilities> availabilities_GET() throws IOException {
		String qPath = "/dedicated/nasha/availabilities";
		String resp = exec("GET", qPath);
		return convertTo(resp, t5);
	}
	private static TypeReference<ArrayList<OvhNasHAAvailabilities>> t5 = new TypeReference<ArrayList<OvhNasHAAvailabilities>>() {};
}
