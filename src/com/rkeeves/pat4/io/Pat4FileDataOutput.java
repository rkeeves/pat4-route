package com.rkeeves.pat4.io;

import java.io.IOException;

public interface Pat4FileDataOutput {
	
	public Pat4FileDataOutput writeBoolean(boolean v) throws IOException ;

	public Pat4FileDataOutput writeByte(byte v) throws IOException;

	public Pat4FileDataOutput writeChar(char v) throws IOException;

	public Pat4FileDataOutput writeInt(int v) throws IOException;

	public Pat4FileDataOutput writeFloat(float v) throws IOException;

	public Pat4FileDataOutput writeVarLenNulTerminatedString(String s) throws IOException;
	
}
