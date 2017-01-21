/***********************************************************************
 * Module:  SkyLotException.java
 * Author:  saul
 * Purpose: Defines the Class SkyLotException
 ***********************************************************************/

package saul.app.autotest.utils;

import lombok.extern.log4j.Log4j;

/**
 * 项目默认异常控制
 * 
 * @pdOid e9baf7c2-7ad0-4c3c-8cd1-b6302490abff
 */
@Log4j

public class AutotestException extends Exception {
	/** @pdOid a58530ab-7caa-4cbc-b3d0-1b41e150a056 */
	private static final long serialVersionUID = 1L;

	/**
	 * 默认异常处理，转移Exception总类进行处理
	 *
	 *
	 * @pdOid 5bf48135-47b2-4ea5-b020-0fc1c8a0d11e
	 */
	public AutotestException() {
		super();
	}

	/**
	 * @param message
	 *            the detail message. The detail message is saved for later
	 *
	 *            retrieval by the {@link #getMessage()} method.
	 * @pdOid fe4b0954-d4f2-4711-add4-a4b560cda930
	 */
	public AutotestException(String message) {
		super(message);
		log.error(message);
	}

	/**
	 * @since 1.4
	 *
	 * @param message
	 *            the detail message (which is saved for later retrieval by the
	 *
	 *            {@link #getMessage()} method).
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *
	 *            {@link #getCause()} method). (A <tt>null</tt> value is
	 *
	 *            permitted, and indicates that the cause is nonexistent or
	 *
	 *            unknown.)
	 * @pdOid 12c0cbcc-a8d7-4e0e-8da9-43144ea1f442
	 */
	public AutotestException(String message, Throwable cause) {
		super(message, cause);
		log.error(message);
	}

	/**
	 * @since 1.4
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *
	 *            {@link #getCause()} method). (A <tt>null</tt> value is
	 *
	 *            permitted, and indicates that the cause is nonexistent or
	 *
	 *            unknown.)
	 * @pdOid 438ba1d3-4672-4c27-94f4-32db5a8b15b0
	 */
	public AutotestException(Throwable cause) {
		super(cause);
		log.error(cause.getMessage());
	}

}