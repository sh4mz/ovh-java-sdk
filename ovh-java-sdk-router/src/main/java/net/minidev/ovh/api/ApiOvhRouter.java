package net.minidev.ovh.api;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import net.minidev.ovh.api.router.OvhNetwork;
import net.minidev.ovh.api.router.OvhPrivLinkReqActionEnum;
import net.minidev.ovh.api.router.OvhPrivateLink;
import net.minidev.ovh.api.router.OvhPrivateLinkRequest;
import net.minidev.ovh.api.router.OvhPrivateLinkRoute;
import net.minidev.ovh.api.router.OvhRouter;
import net.minidev.ovh.api.router.OvhTask;
import net.minidev.ovh.api.router.OvhTaskFunctionEnum;
import net.minidev.ovh.api.router.OvhTaskStatusEnum;
import net.minidev.ovh.api.router.OvhVpn;
import net.minidev.ovh.api.service.OvhTerminationFutureUseEnum;
import net.minidev.ovh.api.service.OvhTerminationReasonEnum;
import net.minidev.ovh.api.services.OvhService;
import net.minidev.ovh.core.ApiOvhBase;
import net.minidev.ovh.core.ApiOvhCore;

/**
 * BasePath:https://eu.api.ovh.com/1.0
 * ResourcePath:/router
 * version:1.0
 */
public class ApiOvhRouter extends ApiOvhBase {
	public ApiOvhRouter(ApiOvhCore core) {
		super(core);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /router/{serviceName}
	 * @param serviceName [required] The internal name of your Router offer
	 */
	public OvhRouter serviceName_GET(String serviceName) throws IOException {
		String qPath = "/router/{serviceName}";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhRouter.class);
	}

	/**
	 * Terminate your service
	 *
	 * REST: POST /router/{serviceName}/terminate
	 * @param serviceName [required] The internal name of your Router offer
	 */
	public String serviceName_terminate_POST(String serviceName) throws IOException {
		String qPath = "/router/{serviceName}/terminate";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "POST", sb.toString(), null);
		return convertTo(resp, String.class);
	}

	/**
	 * Accept, reject or cancel a pending request
	 *
	 * REST: POST /router/{serviceName}/privateLink/{peerServiceName}/request/manage
	 * @param action [required]
	 * @param serviceName [required] The internal name of your Router offer
	 * @param peerServiceName [required] Service name of the other side of this link
	 */
	public String serviceName_privateLink_peerServiceName_request_manage_POST(String serviceName, String peerServiceName, OvhPrivLinkReqActionEnum action) throws IOException {
		String qPath = "/router/{serviceName}/privateLink/{peerServiceName}/request/manage";
		StringBuilder sb = path(qPath, serviceName, peerServiceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "action", action);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, String.class);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /router/{serviceName}/privateLink/{peerServiceName}/request
	 * @param serviceName [required] The internal name of your Router offer
	 * @param peerServiceName [required] Service name of the other side of this link
	 */
	public OvhPrivateLinkRequest serviceName_privateLink_peerServiceName_request_GET(String serviceName, String peerServiceName) throws IOException {
		String qPath = "/router/{serviceName}/privateLink/{peerServiceName}/request";
		StringBuilder sb = path(qPath, serviceName, peerServiceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhPrivateLinkRequest.class);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /router/{serviceName}/privateLink/{peerServiceName}/route/{network}
	 * @param serviceName [required] The internal name of your Router offer
	 * @param peerServiceName [required] Service name of the other side of this link
	 * @param network [required] Network allowed to be routed outside
	 */
	public OvhPrivateLinkRoute serviceName_privateLink_peerServiceName_route_network_GET(String serviceName, String peerServiceName, String network) throws IOException {
		String qPath = "/router/{serviceName}/privateLink/{peerServiceName}/route/{network}";
		StringBuilder sb = path(qPath, serviceName, peerServiceName, network);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhPrivateLinkRoute.class);
	}

	/**
	 * Delete an existing route from your router
	 *
	 * REST: DELETE /router/{serviceName}/privateLink/{peerServiceName}/route/{network}
	 * @param serviceName [required] The internal name of your Router offer
	 * @param peerServiceName [required] Service name of the other side of this link
	 * @param network [required] Network allowed to be routed outside
	 */
	public OvhTask serviceName_privateLink_peerServiceName_route_network_DELETE(String serviceName, String peerServiceName, String network) throws IOException {
		String qPath = "/router/{serviceName}/privateLink/{peerServiceName}/route/{network}";
		StringBuilder sb = path(qPath, serviceName, peerServiceName, network);
		String resp = exec(qPath, "DELETE", sb.toString(), null);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Routes set up in a Private Link
	 *
	 * REST: GET /router/{serviceName}/privateLink/{peerServiceName}/route
	 * @param serviceName [required] The internal name of your Router offer
	 * @param peerServiceName [required] Service name of the other side of this link
	 */
	public ArrayList<String> serviceName_privateLink_peerServiceName_route_GET(String serviceName, String peerServiceName) throws IOException {
		String qPath = "/router/{serviceName}/privateLink/{peerServiceName}/route";
		StringBuilder sb = path(qPath, serviceName, peerServiceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}
	private static TypeReference<ArrayList<String>> t1 = new TypeReference<ArrayList<String>>() {};

	/**
	 * Add a new outgoing route to your router
	 *
	 * REST: POST /router/{serviceName}/privateLink/{peerServiceName}/route
	 * @param network [required] Network to be routed outside your router (CIDR format, e.g. 10.1.0.0./16
	 * @param serviceName [required] The internal name of your Router offer
	 * @param peerServiceName [required] Service name of the other side of this link
	 */
	public OvhTask serviceName_privateLink_peerServiceName_route_POST(String serviceName, String peerServiceName, String network) throws IOException {
		String qPath = "/router/{serviceName}/privateLink/{peerServiceName}/route";
		StringBuilder sb = path(qPath, serviceName, peerServiceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "network", network);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /router/{serviceName}/privateLink/{peerServiceName}
	 * @param serviceName [required] The internal name of your Router offer
	 * @param peerServiceName [required] Service name of the other side of this link
	 */
	public OvhPrivateLink serviceName_privateLink_peerServiceName_GET(String serviceName, String peerServiceName) throws IOException {
		String qPath = "/router/{serviceName}/privateLink/{peerServiceName}";
		StringBuilder sb = path(qPath, serviceName, peerServiceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhPrivateLink.class);
	}

	/**
	 * Alter this object properties
	 *
	 * REST: PUT /router/{serviceName}/privateLink/{peerServiceName}
	 * @param body [required] New object properties
	 * @param serviceName [required] The internal name of your Router offer
	 * @param peerServiceName [required] Service name of the other side of this link
	 */
	public void serviceName_privateLink_peerServiceName_PUT(String serviceName, String peerServiceName, OvhPrivateLink body) throws IOException {
		String qPath = "/router/{serviceName}/privateLink/{peerServiceName}";
		StringBuilder sb = path(qPath, serviceName, peerServiceName);
		exec(qPath, "PUT", sb.toString(), body);
	}

	/**
	 * Remove an existing Private Link from your Router service
	 *
	 * REST: DELETE /router/{serviceName}/privateLink/{peerServiceName}
	 * @param serviceName [required] The internal name of your Router offer
	 * @param peerServiceName [required] Service name of the other side of this link
	 */
	public OvhTask serviceName_privateLink_peerServiceName_DELETE(String serviceName, String peerServiceName) throws IOException {
		String qPath = "/router/{serviceName}/privateLink/{peerServiceName}";
		StringBuilder sb = path(qPath, serviceName, peerServiceName);
		String resp = exec(qPath, "DELETE", sb.toString(), null);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Private links set up on this router
	 *
	 * REST: GET /router/{serviceName}/privateLink
	 * @param serviceName [required] The internal name of your Router offer
	 */
	public ArrayList<String> serviceName_privateLink_GET(String serviceName) throws IOException {
		String qPath = "/router/{serviceName}/privateLink";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Add a new Private Link to your Router service
	 *
	 * REST: POST /router/{serviceName}/privateLink
	 * @param name [required] Your memory-friendly name for this private link
	 * @param peerServiceName [required] serviceName of the router service you want to create a private link with
	 * @param serviceName [required] The internal name of your Router offer
	 */
	public String serviceName_privateLink_POST(String serviceName, String name, String peerServiceName) throws IOException {
		String qPath = "/router/{serviceName}/privateLink";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "name", name);
		addBody(o, "peerServiceName", peerServiceName);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, String.class);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /router/{serviceName}/task/{id}
	 * @param serviceName [required] The internal name of your Router offer
	 * @param id [required]
	 */
	public OvhTask serviceName_task_id_GET(String serviceName, Long id) throws IOException {
		String qPath = "/router/{serviceName}/task/{id}";
		StringBuilder sb = path(qPath, serviceName, id);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Tasks for this Router
	 *
	 * REST: GET /router/{serviceName}/task
	 * @param status [required] Filter the value of status property (=)
	 * @param function [required] Filter the value of function property (=)
	 * @param serviceName [required] The internal name of your Router offer
	 */
	public ArrayList<Long> serviceName_task_GET(String serviceName, OvhTaskFunctionEnum function, OvhTaskStatusEnum status) throws IOException {
		String qPath = "/router/{serviceName}/task";
		StringBuilder sb = path(qPath, serviceName);
		query(sb, "function", function);
		query(sb, "status", status);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}
	private static TypeReference<ArrayList<Long>> t2 = new TypeReference<ArrayList<Long>>() {};

	/**
	 * Networks mounted on this Router
	 *
	 * REST: GET /router/{serviceName}/network
	 * @param serviceName [required] The internal name of your Router offer
	 */
	public ArrayList<String> serviceName_network_GET(String serviceName) throws IOException {
		String qPath = "/router/{serviceName}/network";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}

	/**
	 * Add a network to your router
	 *
	 * REST: POST /router/{serviceName}/network
	 * @param description [required]
	 * @param vlanTag [required] Vlan tag from range 1 to 4094 or NULL for untagged traffic
	 * @param ipNet [required] Gateway IP / CIDR Netmask, (e.g. 192.168.1.254/24)
	 * @param serviceName [required] The internal name of your Router offer
	 */
	public OvhTask serviceName_network_POST(String serviceName, String description, String ipNet, Long vlanTag) throws IOException {
		String qPath = "/router/{serviceName}/network";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "description", description);
		addBody(o, "ipNet", ipNet);
		addBody(o, "vlanTag", vlanTag);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /router/{serviceName}/network/{ipNet}
	 * @param serviceName [required] The internal name of your Router offer
	 * @param ipNet [required] Gateway IP / CIDR Netmask
	 */
	public OvhNetwork serviceName_network_ipNet_GET(String serviceName, String ipNet) throws IOException {
		String qPath = "/router/{serviceName}/network/{ipNet}";
		StringBuilder sb = path(qPath, serviceName, ipNet);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhNetwork.class);
	}

	/**
	 * Alter this object properties
	 *
	 * REST: PUT /router/{serviceName}/network/{ipNet}
	 * @param body [required] New object properties
	 * @param serviceName [required] The internal name of your Router offer
	 * @param ipNet [required] Gateway IP / CIDR Netmask
	 */
	public void serviceName_network_ipNet_PUT(String serviceName, String ipNet, OvhNetwork body) throws IOException {
		String qPath = "/router/{serviceName}/network/{ipNet}";
		StringBuilder sb = path(qPath, serviceName, ipNet);
		exec(qPath, "PUT", sb.toString(), body);
	}

	/**
	 * Remove this network from your router
	 *
	 * REST: DELETE /router/{serviceName}/network/{ipNet}
	 * @param serviceName [required] The internal name of your Router offer
	 * @param ipNet [required] Gateway IP / CIDR Netmask
	 */
	public OvhTask serviceName_network_ipNet_DELETE(String serviceName, String ipNet) throws IOException {
		String qPath = "/router/{serviceName}/network/{ipNet}";
		StringBuilder sb = path(qPath, serviceName, ipNet);
		String resp = exec(qPath, "DELETE", sb.toString(), null);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Confirm termination of your service
	 *
	 * REST: POST /router/{serviceName}/confirmTermination
	 * @param futureUse [required] What next after your termination request
	 * @param reason [required] Reason of your termination request
	 * @param commentary [required] Commentary about your termination request
	 * @param token [required] The termination token sent by mail to the admin contact
	 * @param serviceName [required] The internal name of your Router offer
	 */
	public String serviceName_confirmTermination_POST(String serviceName, String commentary, OvhTerminationFutureUseEnum futureUse, OvhTerminationReasonEnum reason, String token) throws IOException {
		String qPath = "/router/{serviceName}/confirmTermination";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "commentary", commentary);
		addBody(o, "futureUse", futureUse);
		addBody(o, "reason", reason);
		addBody(o, "token", token);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, String.class);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /router/{serviceName}/serviceInfos
	 * @param serviceName [required] The internal name of your Router offer
	 */
	public OvhService serviceName_serviceInfos_GET(String serviceName) throws IOException {
		String qPath = "/router/{serviceName}/serviceInfos";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhService.class);
	}

	/**
	 * Alter this object properties
	 *
	 * REST: PUT /router/{serviceName}/serviceInfos
	 * @param body [required] New object properties
	 * @param serviceName [required] The internal name of your Router offer
	 */
	public void serviceName_serviceInfos_PUT(String serviceName, OvhService body) throws IOException {
		String qPath = "/router/{serviceName}/serviceInfos";
		StringBuilder sb = path(qPath, serviceName);
		exec(qPath, "PUT", sb.toString(), body);
	}

	/**
	 * VPN associated with this Router
	 *
	 * REST: GET /router/{serviceName}/vpn
	 * @param serviceName [required] The internal name of your Router offer
	 */
	public ArrayList<Long> serviceName_vpn_GET(String serviceName) throws IOException {
		String qPath = "/router/{serviceName}/vpn";
		StringBuilder sb = path(qPath, serviceName);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t2);
	}

	/**
	 * Add a VPN to your router
	 *
	 * REST: POST /router/{serviceName}/vpn
	 * @param psk [required] Your PSK key
	 * @param serverPrivNet [required] Server's private network
	 * @param clientIp [required] IP you will be connecting from / NULL (allow all)
	 * @param clientPrivNet [required] Client's private network
	 * @param serviceName [required] The internal name of your Router offer
	 */
	public OvhVpn serviceName_vpn_POST(String serviceName, String clientIp, String clientPrivNet, String psk, String serverPrivNet) throws IOException {
		String qPath = "/router/{serviceName}/vpn";
		StringBuilder sb = path(qPath, serviceName);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "clientIp", clientIp);
		addBody(o, "clientPrivNet", clientPrivNet);
		addBody(o, "psk", psk);
		addBody(o, "serverPrivNet", serverPrivNet);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhVpn.class);
	}

	/**
	 * Get this object properties
	 *
	 * REST: GET /router/{serviceName}/vpn/{id}
	 * @param serviceName [required] The internal name of your Router offer
	 * @param id [required]
	 */
	public OvhVpn serviceName_vpn_id_GET(String serviceName, Long id) throws IOException {
		String qPath = "/router/{serviceName}/vpn/{id}";
		StringBuilder sb = path(qPath, serviceName, id);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, OvhVpn.class);
	}

	/**
	 * Alter this object properties
	 *
	 * REST: PUT /router/{serviceName}/vpn/{id}
	 * @param body [required] New object properties
	 * @param serviceName [required] The internal name of your Router offer
	 * @param id [required]
	 */
	public void serviceName_vpn_id_PUT(String serviceName, Long id, OvhVpn body) throws IOException {
		String qPath = "/router/{serviceName}/vpn/{id}";
		StringBuilder sb = path(qPath, serviceName, id);
		exec(qPath, "PUT", sb.toString(), body);
	}

	/**
	 * Delete a VPN from your router
	 *
	 * REST: DELETE /router/{serviceName}/vpn/{id}
	 * @param serviceName [required] The internal name of your Router offer
	 * @param id [required]
	 */
	public OvhTask serviceName_vpn_id_DELETE(String serviceName, Long id) throws IOException {
		String qPath = "/router/{serviceName}/vpn/{id}";
		StringBuilder sb = path(qPath, serviceName, id);
		String resp = exec(qPath, "DELETE", sb.toString(), null);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * Change your VPN's PSK
	 *
	 * REST: POST /router/{serviceName}/vpn/{id}/setPsk
	 * @param psk [required] Your PSK key
	 * @param serviceName [required] The internal name of your Router offer
	 * @param id [required]
	 */
	public OvhTask serviceName_vpn_id_setPsk_POST(String serviceName, Long id, String psk) throws IOException {
		String qPath = "/router/{serviceName}/vpn/{id}/setPsk";
		StringBuilder sb = path(qPath, serviceName, id);
		HashMap<String, Object>o = new HashMap<String, Object>();
		addBody(o, "psk", psk);
		String resp = exec(qPath, "POST", sb.toString(), o);
		return convertTo(resp, OvhTask.class);
	}

	/**
	 * List available services
	 *
	 * REST: GET /router
	 */
	public ArrayList<String> GET() throws IOException {
		String qPath = "/router";
		StringBuilder sb = path(qPath);
		String resp = exec(qPath, "GET", sb.toString(), null);
		return convertTo(resp, t1);
	}
}
