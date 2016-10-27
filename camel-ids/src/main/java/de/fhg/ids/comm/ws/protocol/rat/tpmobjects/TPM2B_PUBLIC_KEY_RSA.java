package de.fhg.ids.comm.ws.protocol.rat.tpmobjects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.fhg.ids.comm.ws.protocol.rat.RemoteAttestationClientHandler;

public class TPM2B_PUBLIC_KEY_RSA extends TPMU_PUBLIC_ID {
	
	/*
	 * TPM2B_PUBLIC_KEY_RSA Structure
	 * typedef struct {
	 *     UINT16 size;
	 *     BYTE   buffer[MAX_RSA_KEY_BYTES];
	 * } TPM2B_PUBLIC_KEY_RSA;
	 */
	
	private Logger LOG = LoggerFactory.getLogger(RemoteAttestationClientHandler.class);
	private byte[] buffer = new byte[TPM2Constants.MAX_RSA_KEY_BYTES];
	private short size = 0;

	
	public short getSize() {
		return size;
	}

	public void setSize(short size) {
		this.size = size;
	}

	public byte[] getBuffer() {
		return buffer;
	}

	public void setBuffer(byte[] buffer) {
		this.buffer = buffer;
	}
	
	public int getBufferLength() {
		return buffer.length;
	}	

	@Override
	public byte[] toBytes() {
		return ByteArrayUtil.buildBuf(size, buffer);
	}

	@Override
	public void fromBytes(byte[] source, int offset) {
        ByteArrayReadWriter brw = new ByteArrayReadWriter(source, offset);
        this.size = brw.readShort();
        if(this.size <= TPM2Constants.MAX_RSA_KEY_BYTES) {
            this.buffer = new byte[this.getSize()];
            brw.readBytes(this.getSize());        	
        }
        else {
        	LOG.debug("error: buffer of TPM2B_PUBLIC_KEY_RSA is larger then MAX_RSA_KEY_BYTES");
        }
	}

	@Override
    public String toString() {
		return "TPM2B_PUBLIC_KEY_RSA (" + this.getSize() + " bytes): [\n"
	            + ByteArrayUtil.toPrintableHexString(this.buffer) + "\n]\n";
    }
}
