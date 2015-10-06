/**
 * Copyright (c) 2008-2015, XebiaLabs B.V., All rights reserved.
 *
 *
 * Overthere is licensed under the terms of the GPLv2
 * <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most XebiaLabs Libraries.
 * There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
 * this software, see the FLOSS License Exception
 * <http://github.com/xebialabs/overthere/blob/master/LICENSE>.
 *
 * This program is free software; you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation; version 2
 * of the License.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
 * Floor, Boston, MA 02110-1301  USA
 */
package com.xebialabs.overthere.ssh;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.xebialabs.overthere.ConnectionOptions;
import com.xebialabs.overthere.UnixCloudHostListener;
import com.xebialabs.overthere.itest.OverthereConnectionItestBase;

import static com.xebialabs.overthere.ConnectionOptions.ADDRESS;
import static com.xebialabs.overthere.ConnectionOptions.OPERATING_SYSTEM;
import static com.xebialabs.overthere.ConnectionOptions.PASSWORD;
import static com.xebialabs.overthere.ConnectionOptions.PORT;
import static com.xebialabs.overthere.ConnectionOptions.USERNAME;
import static com.xebialabs.overthere.OperatingSystemFamily.UNIX;
import static com.xebialabs.overthere.ssh.SshConnectionBuilder.ALLOCATE_DEFAULT_PTY;
import static com.xebialabs.overthere.ssh.SshConnectionBuilder.CONNECTION_TYPE;
import static com.xebialabs.overthere.ssh.SshConnectionBuilder.SSH_PROTOCOL;
import static com.xebialabs.overthere.ssh.SshConnectionBuilder.SU_PASSWORD;
import static com.xebialabs.overthere.ssh.SshConnectionBuilder.SU_USERNAME;
import static com.xebialabs.overthere.ssh.SshConnectionType.SU;

@Test
@Listeners({UnixCloudHostListener.class})
public class SshSuConnectionItest extends OverthereConnectionItestBase {

    @Override
    protected String getProtocol() {
        return SSH_PROTOCOL;
    }

    @Override
    protected ConnectionOptions getOptions() {
        ConnectionOptions options = new ConnectionOptions();
        options.set(OPERATING_SYSTEM, UNIX);
        options.set(CONNECTION_TYPE, SU);
        options.set(ADDRESS, UnixCloudHostListener.getHost().getHostName());
        options.set(PORT, 22);
        options.set(USERNAME, "overthere");
        options.set(PASSWORD, "}Kp39hdb}LzM");
        options.set(SU_USERNAME, "root");
        options.set(SU_PASSWORD, "87bC=vu@DTHx");
        options.set(ALLOCATE_DEFAULT_PTY, true);
        return options;
    }

    @Override
    protected String getExpectedConnectionClassName() {
        return SshSuConnection.class.getName();
    }

}
