/* Trevor Apple (appletr)
 * Jason Hsu (hsuja)
 * CS362-400
 * 6/7/15
 * Final Project - Part B
 */

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import java.util.regex.Pattern;

import junit.framework.TestCase;


/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
	  
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   System.out.println("MANUAL TESTS");
	   System.out.println(urlVal.isValid("ftp://ftp.is.co.za/rfc/rfc1808.txt"));
	   System.out.println(urlVal.isValid("http://www.test_name.com"));
	   System.out.println(urlVal.isValid("http://www.test-name.com/player?data=15"));
	   System.out.println(urlVal.isValid("http://www.test-name.com#"));
	   
	   System.out.println(urlVal.isValid("http://www.test-name.com"));
	   System.out.println(urlVal.isValid("http://www.test-name.net"));
	   System.out.println(urlVal.isValid("http://www.test~name.com"));
	 
	   System.out.println(urlVal.isValid("http://www.amazon.com"));
	   System.out.println(urlVal.isValid("http://ww.amazon.com"));
	   System.out.println(urlVal.isValid("https://twitter.com/"));
	   System.out.println(urlVal.isValid("http://www.amazon.com/ref=nav_logo"));
	   System.out.println(urlVal.isValid("https://www.abcdefghijklmnopqrstuvwxyz.com"));
	   System.out.println(urlVal.isValid("https://www.ABCDEFGHIJKLMNOPQRSTUVWXYZ.com"));
	   System.out.println(urlVal.isValid("http://www.12345679890.com"));
	   System.out.println(urlVal.isValid("https://mail.google.com/mail/u/0/#inbox"));
	   System.out.println(urlVal.isValid("http://mentalfloss.com/article/58468/most-amazing-lie-history"));
	   System.out.println(urlVal.isValid("http://www.ietf.org/rfc/rfc2396.txt"));
	   System.out.println(urlVal.isValid("http://www.ietf.org/rfc/rfc%202396.txt"));
	   
	   System.out.println(urlVal.isValid("http://www.amazon.om"));
	   System.out.println(urlVal.isValid("http://www.amazon.bom"));
	   System.out.println(urlVal.isValid("http:///www.amazon.com"));
	   System.out.println(urlVal.isValid("amazon.com"));
	   System.out.println(urlVal.isValid("invalid"));
	      
   }
   
   
   public void testYourFirstPartition()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   System.out.println("FIRST PARTITION TEST");
	   System.out.println(urlVal.isValid("https://www.0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.com"));
   }
   
   public void testYourSecondPartition(){
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   System.out.println("SECOND PARTITION TEST");
	   System.out.println(urlVal.isValid("telnet://192.0.2.16:80/"));
	   System.out.println(urlVal.isValid("smb://www.testName.com"));
	   System.out.println(urlVal.isValid("http://www.testName.com"));
   }
   
   
   public void testIsValid(Object[] test_cases, int flag)
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   String[] valid_schemes = (String[]) test_cases[0];
	   String[] invalid_schemes = (String[]) test_cases[1];
	   String[] valid_authorities = (String[]) test_cases[2];
	   String[] invalid_authorities = (String[]) test_cases[3];
	   String[] valid_ports = (String[]) test_cases[4];
	   String[] invalid_ports = (String[]) test_cases[5];
	   String[] valid_paths = (String[]) test_cases[6];
	   String[] invalid_paths = (String[]) test_cases[7];
	   String[] valid_queries = (String[]) test_cases[8];
	   String[] invalid_queries = (String[]) test_cases[9];
	   
	   String test;
	     
	   switch(flag){
	   case 0:
		   System.out.println("TESTING ALL VALID INPUTS:\n");
		   
		   for(int i  = 0; i < 10; i++){
			   
			   for(int j = 0; j < 10; j++){
				   
				   for(int k = 0; k < 10; k++){
					   
					   for(int l = 0; l < 10; l++){
						   
						   for(int m = 0; m < 10; m++){
							   
							   test = valid_schemes[i] + valid_authorities[j] + valid_ports[k] + valid_paths[l] + valid_queries[m];
							   System.out.println(test + " is " + urlVal.isValid(test) + " Expected: Valid");
							   
							   //System.out.println(test);
						   }
					   }
				   }
			   }
		   }
		   break;
	   case 1:
		   System.out.println("TESTING INVALID SCHEME:\n");
		   
		   for(int i  = 0; i < 10; i++){
			   
			   for(int j = 0; j < 10; j++){
				   
				   for(int k = 0; k < 10; k++){
					   
					   for(int l = 0; l < 10; l++){
						   
						   for(int m = 0; m < 10; m++){
							   
							   test = invalid_schemes[i] + valid_authorities[j] + valid_ports[k] + valid_paths[l] + valid_queries[m];
							   System.out.println(test + " is " + urlVal.isValid(test) + " Expected: false (Invalid Scheme)");
							   //System.out.println(test);
						   }
					   }
				   }
			   }
		   }
		   break;
	   case 2:
		   System.out.println("TESTING INVALID AUTHORITY:\n");
		   
		   for(int i  = 0; i < 10; i++){
			   
			   for(int j = 0; j < 10; j++){
				   
				   for(int k = 0; k < 10; k++){
					   
					   for(int l = 0; l < 10; l++){
						   
						   for(int m = 0; m < 10; m++){
							   
							   test = valid_schemes[i] + invalid_authorities[j] + valid_ports[k] + valid_paths[l] + valid_queries[m];
							   System.out.println(test + " is " + urlVal.isValid(test) + " Expected: false (Invalid Authority)");
							   
						   }
					   }
				   }
			   }
		   }
		   break;
	   case 3:
		   System.out.println("TESTING INVALID PORT:\n");
		   
		   for(int i  = 0; i < 10; i++){
			   
			   for(int j = 0; j < 10; j++){
				   
				   for(int k = 0; k < 10; k++){
					   
					   for(int l = 0; l < 10; l++){
						   
						   for(int m = 0; m < 10; m++){
							   
							   test = valid_schemes[i] + valid_authorities[j] + invalid_ports[k] + valid_paths[l] + valid_queries[m];
							   System.out.println(test + " is " + urlVal.isValid(test) + " Expected: false (Invalid Port)");
							   
						   }
					   }
				   }
			   }
		   }
		   break;
	   case 4:
		   System.out.println("TESTING INVALID PATH:\n");
		   
		   for(int i  = 0; i < 10; i++){
			   
			   for(int j = 0; j < 10; j++){
				   
				   for(int k = 0; k < 10; k++){
					   
					   for(int l = 0; l < 10; l++){
						   
						   for(int m = 0; m < 10; m++){
							   
							   test = valid_schemes[i] + valid_authorities[j] + valid_ports[k] + invalid_paths[l] + valid_queries[m];
							   System.out.println(test + " is " + urlVal.isValid(test) + " Expected: false (Invalid Path)");
							   
						   }
					   }
				   }
			   }
		   }
		   break;
		   
	   case 5:
		   System.out.println("TESTING INVALID QUERY:\n");
		   
		   for(int i  = 0; i < 10; i++){
			   
			   for(int j = 0; j < 10; j++){
				   
				   for(int k = 0; k < 10; k++){
					   
					   for(int l = 0; l < 10; l++){
						   
						   for(int m = 0; m < 10; m++){
							   
							   test = valid_schemes[i] + valid_authorities[j] + valid_ports[k] + valid_paths[l] + invalid_queries[m];
							   System.out.println(test + " is " + urlVal.isValid(test) + " Expected: false (Invalid Query)");
							   
						   }
					   }
				   }
			   }
		   }
		   break;
		   
		   
		   
		   
		   default:
		   
	  
	   }
	   
	  
	   
	   
	 
	   
   }
   
   public void testAnyOtherUnitTest()
   {
	   
   }
   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   
   static String[] valid_schemes = {
		   "",
		   "http://",
		   "h://",
		   "http4://",
		   "ht3p://",
		   "htt+://",
		   "ht-://",
		   "h.://",
		   "ftp://",
		   "f333333333://"
   }; 
   
   static String[] invalid_schemes = {
		   "9http://",
		   "://",
		   "http#://",
		   "http:",
		   "http:/",
		   "http/",
		   "http//",
		   "ftp:",
		   "ftp@://",
		   ".http://",
   };
   
   static String[] valid_authorities = {
		   "www.google.com",
		   "google.com",
		   "www.google.org",
		   "google.net",
		   "www.goo-le.biz",
		   "www.google.cu",
		   "255.255.255.255",
		   "12.24.23.143",
		   "1.2.0.4",
		   "localhost"
   };
   
   static String[] invalid_authorities = {
		   "www.google.",
		   "google.",
		   "google",
		   "www.google.zz",
		   "google+.com",
		   "255.255.256.255",
		   "255.255.255",
		   "255.255",
		   "255.255.255.255.255",
		   ""
   };
   
   static String[] valid_ports = {
		   ":11111",
		   ":0999",
		   ":097",
		   ":12",
		   ":5",
		   ":19483",
		   ":3938",
		   ":800",
		   ":89",
		   ""
   };
   
   static String[] invalid_ports = {
		   ":123456",
		   ":1234h",
		   ":p20",
		   ":",
		   "222",
		   ":30&4",
		   "2:0033",
		   ":-33",
		   ":30:80",
		   "::80"
   };
   
   static String[] valid_paths = {
		   "",
		   "/somepath",
		   "/999999",
		   "/9",
		   "/s",
		   "/:@?-+,.!/~%$_()",
		   "/somepath/",
		   "/somepath/somepath",
		   "/somepath24",
		   "/"
   };
   
   static String[] invalid_paths = {
		   "somepath",
		   "somepath/",
		   "/somepath#",
		   "/../somepath",
		   "/..",
		   "//somepath",
		   "///somepath",
		   "//somepath/",
		   "/<path>",
		   "/..path/"
   };
   
   static String[] valid_queries = {
		   "",
		   "?",
		   "?query",
		   "??",
		   "?394843945",
		   "?5",
		   "?search12345",
		   "?mode=read",
		   "?mode=read&status=0",
		   "?mode="
   };
   
   static String[] invalid_queries = {
		   "mode=read",
		   "?mode#read",
		   "?#",
		   "?mode33#",
		   "query",
		   "mode=read",
		   "?mode#read",
		   "?#",
		   "?mode33#",
		   "query"
   };
   
  static Object[] test_cases = {
		  valid_schemes,
		  invalid_schemes,
		  valid_authorities,
		  invalid_authorities,
		  valid_ports,
		  invalid_ports,
		  valid_paths,
		  invalid_paths,
		  valid_queries,
		  invalid_queries
  };
  
  
   
   
   public static void main(String[] argv) {

	   UrlValidatorTest fct = new UrlValidatorTest("url test");
	   
	   fct.testManualTest();
	   fct.testYourFirstPartition();
	   fct.testYourSecondPartition();
	  
	   fct.testIsValid(test_cases, 0);	/* Test all valid URL parts */
	   fct.testIsValid(test_cases, 1);	/* Test invalid schemes only */
	   fct.testIsValid(test_cases, 2);	/* Test invalid authorities only */
	   fct.testIsValid(test_cases, 3);	/* Test invalid ports only */
	   fct.testIsValid(test_cases, 4);	/* Test invalid paths only */
	   fct.testIsValid(test_cases, 5);	/* Test invalid queries only */
	   
   }

}
