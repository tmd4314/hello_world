package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.yedam.classes.Product;

public class ObejctStreamExe {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("c:/temp/object.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Product> list = (List<Product>) ois.readObject();
			for(Product prod : list) {
				System.out.println(prod.showList());
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("end of prog.");
	}
	
	static void wrtie() {
		// 객체 -> btye : 직렬화.
		// byte -> 객체 : 역직렬화.
		// 클래스 implements Serializable (인터페이스)
		List<Product> list = new ArrayList();
		list.add(new Product("A001", "연필", 1000));
		list.add(new Product("B001", "지우개", 500));
		
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/object.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(list);
				oos.flush();
				oos.close();fos.close();
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog.");
	}
}
