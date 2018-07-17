package com.linewell.common.utils;

import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * copy from ccip-core-framework-1.0.jar
 * @author mawei
 *
 */
public class CDC04FE60F6132D9E9E3703BF57F5DEC {
	private static final int DFBB5FF1C547833E4B55A183D37CCBB7;
	private static short C3F47D2AC93A81411AF50B45F29185D2 = 0;
	private static final int E68AD84D963794E4FE0E0E008D906091 = (int) (System.currentTimeMillis() >>> 8);
	private String D8D8A94B87398605A3239B713010343B = "";

	static {
		int i;
		try {
			i = DA833A2AC4A7DCB2A62E5E5BC48CB993(InetAddress.getLocalHost().getAddress());
		} catch (Exception localException) {
			i = 0;
		}
		DFBB5FF1C547833E4B55A183D37CCBB7 = i;
	}

	public static String getUnid() {
		CDC04FE60F6132D9E9E3703BF57F5DEC localCDC04FE60F6132D9E9E3703BF57F5DEC = new CDC04FE60F6132D9E9E3703BF57F5DEC();
		return localCDC04FE60F6132D9E9E3703BF57F5DEC.toString();
	}

	public static String DA833A2AC4A7DCB2A62E5E5BC48CB993(int paramInt) {
		String str = getUnid();
		if (paramInt >= 32) {
			return str;
		}
		int i = str.length() - paramInt;
		int j = (int) Math.random() * i;
		str = str.substring(j, paramInt);
		return str;
	}

	protected int F076A2539F6C30CC9CFF4F6A09305A9D() {
		return E68AD84D963794E4FE0E0E008D906091;
	}

	protected short FEC66745529196FC1205BA2E2777624F() {
		synchronized (CDC04FE60F6132D9E9E3703BF57F5DEC.class) {
			if (C3F47D2AC93A81411AF50B45F29185D2 < 0) {
				C3F47D2AC93A81411AF50B45F29185D2 = 0;
			}
			return C3F47D2AC93A81411AF50B45F29185D2++;
		}
	}

	protected int F083A158B3E37F844AC953506FFF03FF() {
		return DFBB5FF1C547833E4B55A183D37CCBB7;
	}

	protected short CD021E98EB039E176168E9E15D13C93F() {
		return (short) (int) (System.currentTimeMillis() >>> 32);
	}

	protected int A2B0C8927A1858364E0B8027AFE571AD() {
		return (int) System.currentTimeMillis();
	}

	protected String C7E19DA6ABABD5DD1204D83F215F84B4(int paramInt) {
		String str = Integer.toHexString(paramInt);
		StringBuffer localStringBuffer = new StringBuffer("00000000");
		localStringBuffer.replace(8 - str.length(), 8, str);
		return localStringBuffer.toString();
	}

	protected String DA833A2AC4A7DCB2A62E5E5BC48CB993(short paramShort) {
		String str = Integer.toHexString(paramShort);
		StringBuffer localStringBuffer = new StringBuffer("0000");
		localStringBuffer.replace(4 - str.length(), 4, str);
		return localStringBuffer.toString();
	}

	public String toString() {
		StringBuffer localStringBuffer1 = new StringBuffer(36)
				.append(C7E19DA6ABABD5DD1204D83F215F84B4(F083A158B3E37F844AC953506FFF03FF()))
				.append(this.D8D8A94B87398605A3239B713010343B)
				.append(C7E19DA6ABABD5DD1204D83F215F84B4(F076A2539F6C30CC9CFF4F6A09305A9D()))
				.append(this.D8D8A94B87398605A3239B713010343B)
				.append(DA833A2AC4A7DCB2A62E5E5BC48CB993(CD021E98EB039E176168E9E15D13C93F()))
				.append(this.D8D8A94B87398605A3239B713010343B)
				.append(C7E19DA6ABABD5DD1204D83F215F84B4(A2B0C8927A1858364E0B8027AFE571AD()))
				.append(this.D8D8A94B87398605A3239B713010343B)
				.append(DA833A2AC4A7DCB2A62E5E5BC48CB993(FEC66745529196FC1205BA2E2777624F()));
		MessageDigest localMessageDigest = null;
		try {
			localMessageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
			return localStringBuffer1.toString().toUpperCase();
		}
		localMessageDigest.update(localStringBuffer1.toString().getBytes());
		byte[] arrayOfByte = localMessageDigest.digest();
		StringBuffer localStringBuffer2 = new StringBuffer();
		for (int i = 0; i < arrayOfByte.length; i++) {
			int j = arrayOfByte[i] & 0xFF;
			if (j < 16) {
				localStringBuffer2.append('0');
			}
			localStringBuffer2.append(Integer.toHexString(j));
		}
		return localStringBuffer2.toString().toUpperCase();
	}

	public static boolean A21350183AEDCD46097CF338BD7E9537(String paramString) {
		return (paramString.length() == 32) && (paramString.matches("[A-Z0-9]{32}"));
	}

	public static int DA833A2AC4A7DCB2A62E5E5BC48CB993(byte[] paramArrayOfByte) {
		int i = 0;
		for (int j = 0; j < 4; j++) {
			i = (i << 8) - -128 + paramArrayOfByte[j];
		}
		return i;
	}
}
