<?php

/**
 * request_param - a request parameter for receiving requested
 * information to the client.
 * 
 * @Project Simsimi API Example
 * @Date 2014.08.04
 */

class requestParam
{
	
	private $lc; // Language code
	private $text; // Query message
	
   /*
	* Double(0.0~1.0) & Default value is 0.0
	* (0.0 is a bad Simsimi Version and 1.0 is a kind Simsimi Version.
	*/
	
	private $ft; 
	
	private $key; // your Trial-key value
	
	function __construct()
	{
			
			$this->text = null;
			$this->lc =null;
			$this->text = null;
			$this->key = "d6bbfd1b-7cb3-4cfe-87b1-261e4d210d19";
	}
	
	/**
	 * Retrieve the value of text.
	 *
	 * @return A String data type.
	 */
	public function getText()
	{
		return $this->text;
	}
	
	/**
	 * set the value of text.
	 *
	 * @param text
	 *            A variable of type String.
	 */
	public function setText($text)
	{
		$this->text = urlencode($text);
	}
	
	/**
	 * Retrieve the value of Language code(Lc).
	 *
	 * @return A String data type.
	 */
	public function getLC()
	{
		return $this->lc;
	}
	
	/**
	 * set the value of lc.
	 *
	 * @param lc
	 *            A variable of type String.
	 */
	public function setLC($lc)
	{
		$this->lc = urlencode($lc);
	}
	
	/**
	 * Retrieve the value of ft.
	 *
	 * @return A double data type.
	 */
	public function getFt()
	{
		return $this->ft;
	}
	
	/**
	 * set the value of ft.
	 *
	 * @param ft
	 *            A variable of type double.
	 */
	public function setFt($ft)
	{
		$this->ft = $ft;
	}
	
	/**
	 * Retrieve the value of key.
	 *
	 * @return A String data type.
	 */
	public function getKey()
	{
		return $this->key;
	}
	
	
	public function __destruct()
	{
		
	}
	
}
?>