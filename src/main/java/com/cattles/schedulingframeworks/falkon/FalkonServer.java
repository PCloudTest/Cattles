package com.cattles.schedulingframeworks.falkon;

import com.cattles.resourcePoolManagement.VirtualMachineResourcePool;
import com.cattles.schedulingframeworks.falkon.common.ExecuteCommand;
import com.cattles.ssh.CommandExecutable;
import com.cattles.ssh.ConnInfo;
import com.cattles.ssh.SSHResult;
import com.cattles.ssh.jsch.CmdExecFactory;
import com.cattles.util.Constant;
import com.cattles.vmManagement.VMInfo;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: youfuli
 * Date: 12/27/13
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class FalkonServer {
    private static Logger logger = Logger.getLogger(FalkonServer.class);
    VirtualMachineResourcePool virtualMachineResourcePool=VirtualMachineResourcePool.getResourcePool();
    ExecuteCommand executeCommand;
    public void startFalkonService(String serverID) {
        //get the vm information according to the serverID, which is also the ID of a virtual machine.
        VMInfo falkonServer=virtualMachineResourcePool.getVMWithID(serverID);
        logger.info("Initializing the falkon server!");
        FalkonServerInitialization falkonServerInitialization=new FalkonServerInitialization(falkonServer.getVmID(),falkonServer.getVmPublicIpAddress());
        Thread thread=Thread.currentThread();
        falkonServerInitialization.start();
        /*executeCommand=new ExecuteCommand(falkonServer.getVmPublicIpAddress(), Constant.VIRTUAL_MACHINE_ACCOUNT,Constant.VIRTUAL_MACHINE_PASSWORD);
        try {
            executeCommand.execShell("sh /usr/local/falkon.r174/cattles/startService.sh");
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            logger.info(e.getMessage());
        }*/
    }
    public void stopFalkonServie(String serverID){
        VMInfo falkonServer=virtualMachineResourcePool.getVMWithID(serverID);
        executeCommand=new ExecuteCommand(falkonServer.getVmPublicIpAddress(), Constant.VIRTUAL_MACHINE_ACCOUNT,Constant.VIRTUAL_MACHINE_PASSWORD);
        try {
            executeCommand.execShell("sh /usr/local/falkon.r174/cattles/stopService.sh falkon-service-");
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            logger.info(e.getMessage());
        }

    }
}
