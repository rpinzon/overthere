package com.xebialabs.overthere.ssh;

import com.xebialabs.overthere.ConnectionOptions;
import com.xebialabs.overthere.WindowsCloudHostListener;
import com.xebialabs.overthere.itest.OverthereConnectionItestBase;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.xebialabs.overthere.ConnectionOptions.*;
import static com.xebialabs.overthere.OperatingSystemFamily.WINDOWS;
import static com.xebialabs.overthere.WindowsCloudHostListener.REGULAR_WINDOWS_USER_PASSWORD;
import static com.xebialabs.overthere.WindowsCloudHostListener.REGULAR_WINDOWS_USER_USERNAME;
import static com.xebialabs.overthere.ssh.SshConnectionBuilder.*;
import static com.xebialabs.overthere.ssh.SshConnectionType.SFTP_OpenSSHD;

@Test
@Listeners({WindowsCloudHostListener.class})
public class SshSftpOpensshdConnectionWithRegularUserItest extends OverthereConnectionItestBase {

    @Override
    protected String getProtocol() {
        return SSH_PROTOCOL;
    }

    @Override
    protected ConnectionOptions getOptions() {
        ConnectionOptions options = new ConnectionOptions();
        options.set(OPERATING_SYSTEM, WINDOWS);
        options.set(CONNECTION_TYPE, SFTP_OpenSSHD);
        options.set(ADDRESS, WindowsCloudHostListener.getHost().getHostName());
        options.set(PORT, 2222);
        options.set(USERNAME, REGULAR_WINDOWS_USER_USERNAME);
        options.set(PASSWORD, REGULAR_WINDOWS_USER_PASSWORD);
        options.set(ALLOCATE_PTY, "xterm:80:24:0:0");
        return options;
    }

    @Override
    protected String getExpectedConnectionClassName() {
        return SshSftpOpenSshdConnection.class.getName();
    }
}
