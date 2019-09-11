package com.largehat.common.im.service.codec.tcp;


import com.largehat.common.im.entity.ImPacket;
import com.largehat.common.im.packets.command.Command;

/**
 * 版本: [1.0]
 * 功能说明:
 */
public class TcpPacket extends ImPacket {

    private static final long serialVersionUID = -4283971967100935982L;
    private byte version = 0;
    private byte mask = 0;

    public TcpPacket() {

    }

    public TcpPacket(Command command, byte[] body) {
        super(command, body);
    }

    public TcpPacket(byte[] body) {
        super(body);
    }

    public byte getVersion() {
        return version;
    }

    public void setVersion(byte version) {
        this.version = version;
    }

    public byte getMask() {
        return mask;
    }

    public void setMask(byte mask) {
        this.mask = mask;
    }

}
