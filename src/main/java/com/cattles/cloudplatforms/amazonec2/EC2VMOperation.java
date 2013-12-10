package com.cattles.cloudplatforms.amazonec2;

import java.awt.List;
import java.util.ArrayList;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.TerminateInstancesRequest;
import com.cattles.interfaces.VMOperationInterface;
import com.cattles.vmManagement.VMInfo;

public class EC2VMOperation implements VMOperationInterface {
	
	EC2ConfigOperation ec2Config=new EC2ConfigOperation();
	AWSCredentials credentials = ec2Config.initAWSCredentials();
	// Initialize variables.
	ArrayList<String> instanceIds = new ArrayList<String>();
	// Create the AmazonEC2Client object so we can call various APIs.
	AmazonEC2 ec2 = new AmazonEC2Client(credentials);

    /**
     * Used to create one virtual machine
     *
     * @return
     * @throws Exception
     */
    @Override
    public VMInfo createInstance() throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Used to create certain number of VMs.
     *
     * @param vmNumber
     * @return
     * @throws Exception
     */
    @Override
    public List createInstances(int vmNumber) throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * used to launch one instance
     *
     * @param _VMInfo
     * @return
     * @throws Exception
     */
    @Override
    public VMInfo launchInstance(VMInfo _VMInfo) throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * used to launch a list of instances
     *
     * @param vmList
     * @return
     * @throws Exception
     */
    @Override
    public VMInfo launchInstances(List vmList) throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * used to shutdown one instance
     *
     * @param _VMInfo
     * @return
     * @throws Exception
     */
    @Override
    public boolean shutdownInstance(VMInfo _VMInfo) throws Exception {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * used to shutdown a list of instances
     *
     * @param vmList
     * @return
     * @throws Exception
     */
    @Override
    public boolean shutdownInstances(List vmList) throws Exception {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * used to reboot one instance
     *
     * @param _VMInfo
     * @throws Exception
     */
    @Override
    public List rebootInstance(VMInfo _VMInfo) throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * used to reboot a list of instances
     *
     * @param vmList
     * @throws Exception
     */
    @Override
    public List rebootInstances(List vmList) throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
	public boolean destoryInstances(List vmList) throws Exception {
		// TODO Auto-generated method stub
    	//============================================================================================//
    	//=================================== Terminating any Instances ==============================// 
    	//============================================================================================//
        try {
        	// Terminate instances.
        	TerminateInstancesRequest terminateRequest = new TerminateInstancesRequest(instanceIds);
        	ec2.terminateInstances(terminateRequest);
    	} catch (AmazonServiceException e) {
    		// Write out any exceptions that may have occurred.
            System.out.println("Error terminating instances");
    		System.out.println("Caught Exception: " + e.getMessage());
            System.out.println("Reponse Status Code: " + e.getStatusCode());
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("Request ID: " + e.getRequestId());
        }
		return false;
	}

}
