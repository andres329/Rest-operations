/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author informatica
 */
public class Rest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, ProtocolException, IOException {
    Scanner input = new Scanner(System.in);
            int i;

            System.out.println("1)GET\n2)POST\n3)DELETE\n4)PUT(id)\n5)GET(id)");
            i=input.nextInt();
            switch (i){
            case 1:
                URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection(); 
                conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
                BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
                conn.disconnect();
                break;
            case 2:
                URL url1 = new URL("http://localhost:8080/api/tutorial/1.0/employees");
		HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
		conn1.setDoOutput(true);
		conn1.setRequestMethod("POST");
		conn1.setRequestProperty("Content-Type", "application/json");
                Scanner inputP = new Scanner(System.in);
                System.out.println("inserire il nome dell'impiegato da aggiungere");
                String Nome=inputP.nextLine();
                System.out.println("inserire il cognome dell'impiegato da aggiungere");
                String Cognome=inputP.nextLine();
                System.out.println("inserire la e-mail dell'impiegato da aggiungere");
                String Mail=inputP.nextLine();
                System.out.println("inserire il numero di telefono dell'impiegato da aggiungere");
                String Telefono=inputP.nextLine();
                System.out.println("inserire l'id dell'impiegato da aggiungere");
                int id= inputP.nextInt();
                String employee = "{\"employeeId\": "+id+",\"firstName\":\""+Nome+"\",\"lastName\":\""+Cognome+"\",\"email\":\""+Mail+"\",\"phone\":\""+Telefono+"\"}";
                //String employee = "{\"employeeId\":4,\"firstName\":\"andrea\",\"lastName\":\"guerri\",\"email\":\"ads@asd.it\",\"phone\":\"123\"}";
                OutputStream os = conn1.getOutputStream();
		os.write(employee.getBytes());
		os.flush();
                BufferedReader br1 = new BufferedReader(new InputStreamReader(
				(conn1.getInputStream())));

		String output1;
		System.out.println("Output from Server .... \n");
		while ((output = br1.readLine()) != null) {
			System.out.println(output);
		}

		conn1.disconnect();
                break;
            case 3:
                Scanner inputid = new Scanner(System.in);
                System.out.println("inserisci id dell'impiegato da eliminare");
                int id1=inputid.nextInt();
                URL url2 = new URL("http://localhost:8080/api/tutorial/1.0/employees/"+id1);
                HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection(); 
                conn2.setRequestMethod("DELETE");
		conn2.setRequestProperty("Accept", "application/json");
                BufferedReader br2 = new BufferedReader(new InputStreamReader(
			(conn2.getInputStream())));

		String output2;
		System.out.println("Output from Server .... \n");
		while ((output2 = br2.readLine()) != null) {
			System.out.println(output2);
		}
                conn2.disconnect();
                break;
            case 4:
                Scanner inputPU = new Scanner(System.in);
                System.out.println("inserire il nome dell'impiegato da aggiungere");
                String NomeP=inputPU.nextLine();
                System.out.println("inserire il cognome dell'impiegato da aggiungere");
                String CognomeP=inputPU.nextLine();
                System.out.println("inserire la e-mail dell'impiegato da aggiungere");
                String MailP=inputPU.nextLine();
                System.out.println("inserire il numero di telefono dell'impiegato da aggiungere");
                String TelefonoP=inputPU.nextLine();
                System.out.println("inserire l'id dell'impiegato da aggiungere");
                int idP= inputPU.nextInt();
                URL url3 = new URL("http://localhost:8080/api/tutorial/1.0/employees/"+idP);
		HttpURLConnection conn3 = (HttpURLConnection) url3.openConnection();
		conn3.setDoOutput(true);
		conn3.setRequestMethod("PUT");
		conn3.setRequestProperty("Content-Type", "application/json");
                String employeeP= "{\"employeeId\": "+idP+",\"firstName\":\""+NomeP+"\",\"lastName\":\""+CognomeP+"\",\"email\":\""+MailP+"\",\"phone\":\""+TelefonoP+"\"}";
                OutputStream os1 = conn3.getOutputStream();
		os1.write(employeeP.getBytes());
		os1.flush();
                BufferedReader br3 = new BufferedReader(new InputStreamReader(
				(conn3.getInputStream())));

		String output3;
		System.out.println("Output from Server .... \n");
		while ((output = br3.readLine()) != null) {
			System.out.println(output);
		}

		conn3.disconnect();
                break;
            case 5:
                Scanner inputid2 = new Scanner(System.in);
                System.out.println("inserisci id dell'impiegato da visualizzare");
                int id2=inputid2.nextInt();
                URL url4 = new URL("http://localhost:8080/api/tutorial/1.0/employees/"+id2);
                HttpURLConnection conn4 = (HttpURLConnection) url4.openConnection(); 
                conn4.setRequestMethod("GET");
		conn4.setRequestProperty("Accept", "application/json");
                BufferedReader br4 = new BufferedReader(new InputStreamReader(
			(conn4.getInputStream())));

		String output4;
		System.out.println("Output from Server .... \n");
		while ((output4 = br4.readLine()) != null) {
			System.out.println(output4);
		}
                conn4.disconnect();
                break;
        } 


    }
    
}
