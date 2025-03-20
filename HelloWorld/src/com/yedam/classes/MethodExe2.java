package com.yedam.classes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MethodExe2 {
	private List<Product> store; //필드
	
	//생성자
	MethodExe2() {
		init();
	}
	
	void init() {
		store = new ArrayList<Product>();
		try {
			FileInputStream fis = new FileInputStream("c:/temp/object.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Product> list = (List<Product>) ois.readObject();
			for(Product prod : list) {
				 String[] msg = new String[3];
				 	msg[0] = prod.getProductCode(); // Product 클래스에서 이름을 가져오는 메서드
		            msg[1] = prod.getProductName(); // Product 클래스에서 설명을 가져오는 메서드
		            msg[2] = String.valueOf(prod.getPrice()); // Product 클래스에서 가격을 가져오는 메서드

		            // store에 새로운 Product 객체 추가
		            store.add(new Product(msg[0], msg[1], Integer.parseInt(msg[2])));
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
//		try {
//			Scanner scn = new Scanner(new FileInputStream("c:/temp/message.txt"));
//			while(true) {
//				String msg = scn.nextLine();
//				String[] msgAry = msg.split(" ");
//				store.add(new Product(msgAry[0], msgAry[1], Integer.parseInt(msgAry[2])));
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (NoSuchElementException e) {
//			
//		}
		// 초기화 끝.
	}
	
	// 종료시점에 store 정보를 message.txt에 저장.
	void save() {
		
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/object.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(store);
				oos.flush();
				oos.close();fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			Writer writer = new FileWriter("c:/temp/message.txt");
//			for(Product prod : store) {
//				String msg = prod.getProductCode() + " " + prod.getProductName() + " " + prod.getPrice();
//				writer.write(msg + "\n");
//				writer.flush();
//			}
//			writer.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (NoSuchElementException e) {
//			
//		}
		// 초기화 끝.
	};
	
	//메소드
	boolean add(Product prod) {
		boolean result = store.add(prod);
		return result;
	} // end of void add(Product prd)
	// 상품이름, ALL
	List<Product> productList(Product prod) {
		List<Product> list = new ArrayList<Product>();
		for(int i = 0; i < store.size(); i++) {
			if(prod.getProductName().equals("ALL")
					|| store.get(i).getProductName().equals(prod.getProductName())) {
				if(store.get(i).getPrice() >= prod.getPrice()) {
					list.add(store.get(i));
				}
			}
			
		}
		return list;
	}// end of productList.
	// 삭제 => boolean remove(String code)
	boolean remove(String code) {
		List<Product> remove = new ArrayList<Product>();
		for(int i = 0; i < store.size(); i++) {
			if(store.get(i).getProductCode().equals(code)) {
					store.remove(i);
					return true;
			}
		}
		return false;
	}// end of remove.
	
	// 수정 => boolean modify
	boolean modify(Product prod) {
		for(int i = 0; i < store.size(); i++) {
			if(store.get(i).getProductCode().equals(prod.getProductCode())) {
					// 상품명수정.
				if(prod.getProductName() != null) {
					store.get(i).setProductName(prod.getProductName());
				}
				//상품가격 수정.
				if(prod.getPrice() != 0) {
					store.get(i).setPrice(prod.getPrice());
				}
				return true;
			}
		}
		return false;
	}// end of modify.

}
