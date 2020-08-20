package com.rkeeves.pat4.io;

import java.io.DataInput;
import java.io.IOException;

public class Pat4LittleEndianDataInput implements Pat4FileDataInput {

	public Pat4LittleEndianDataInput(DataInput di) {
		this.di=di;
	}
	
	private DataInput di;

	public boolean readBoolean() throws IOException {
		return di.readBoolean();
	}

	public byte readByte() throws IOException {
		return di.readByte();
	}
	
	public char readChar() throws IOException {
		return Character.reverseBytes(di.readChar());
	}
	
	public int readInt() throws IOException {
		return Integer.reverseBytes(di.readInt());
	}
	
	public float readFloat() throws IOException {
		return Float.intBitsToFloat(Integer.reverseBytes(di.readInt()));
	}
	
	public String readVarLenNulTerminatedString() throws IOException{
		char c;
		StringBuilder sb = new StringBuilder();
		while((c=Character.reverseBytes(di.readChar()))!=0) {
			sb.append(c);
		}
		return sb.toString();
	}

	

	
}
