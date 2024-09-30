package com.quoinsight.shellexec;
/*
  # inspired by https://czak.pl/2016/01/13/minimal-android-project.html
  # thisSource: https://github.com/QuoInsight/minimal.apk/edit/master/src/main/java/com/quoinsight/minimal/MainActivity.java
*/

public class MainActivity extends android.app.Activity {

  @Override public void onCreate(android.os.Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //android.widget.Toast.makeText(this, "Quoinsight.ShellExec.1", android.widget.Toast.LENGTH_SHORT).show();

	String strCmdln = "/system/bin/sh /data/usr2/apk/shellexec.sh";
	String[] arrCmdln = {"sh", "-c", "/data/usr2/apk/shellexec.sh >> /data/usr2/apk/shellexec.log 2>&1"}; 
	try {
		java.lang.Process p = java.lang.Runtime.getRuntime().exec(
			//"whoami" //"date" 
			arrCmdln	// strCmdln
		);
		java.io.BufferedReader r = new java.io.BufferedReader(new java.io.InputStreamReader(p.getInputStream()));
		String outLine;
		while ((outLine = r.readLine()) != null) {
			android.widget.Toast.makeText(this, outLine, android.widget.Toast.LENGTH_SHORT).show();
			break;
		}
	//} catch (java.io.IOException e) { }
	} catch (java.lang.Exception e) {
		//System.out.println("exec failed: " + e.getMessage());
		android.widget.Toast.makeText(this, e.getMessage(), android.widget.Toast.LENGTH_LONG).show();
    }

    android.widget.Toast.makeText(this, "Quoinsight.ShellExec.9", android.widget.Toast.LENGTH_SHORT).show();
    finish(); // all done and exit/quit !
  }

}
