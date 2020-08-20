package com.rkeeves.pat4.io;

import java.io.DataOutput;
import java.io.IOException;

public class Pat4LittleEndianDataOutput implements Pat4FileDataOutput {

	public Pat4LittleEndianDataOutput(DataOutput out) {
		this.out = out;
	}
	
	private DataOutput out;
	

	@Override
	public Pat4FileDataOutput writeBoolean(boolean v) throws IOException {
		out.writeBoolean(v);
		return this;
	}

	@Override
	public Pat4FileDataOutput writeByte(byte v) throws IOException {
		out.writeByte(v);
		return this;
	}

	@Override
	public Pat4FileDataOutput writeChar(char v) throws IOException {
		out.writeChar(Character.reverseBytes((char) v));
		return this;
	}

	@Override
	public Pat4FileDataOutput writeInt(int v) throws IOException {
		out.writeInt(Integer.reverseBytes(v));
		return this;
	}

	@Override
	public Pat4FileDataOutput writeFloat(float v) throws IOException {
		out.writeInt(Integer.reverseBytes(Float.floatToIntBits(v)));
		return this;
	}

	@Override
	public Pat4FileDataOutput writeVarLenNulTerminatedString(String s) throws IOException {
		for (int i = 0; i < s.length(); i++)
			writeChar( s.charAt(i) );
		writeChar( (char) 0 );
		return this;
	}

}
