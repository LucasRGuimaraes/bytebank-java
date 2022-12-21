package com.example.demo;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.entities.User;
import com.example.domain.repository.UserRepository;

@Component
public class UserService {
	
	private UserRepository userRepository =  UserRepository.getInstace_();
	
	public void analisarArquivo(MultipartFile file) {
		
		try {
			HSSFWorkbook arquivo = new HSSFWorkbook(file.getInputStream());
			
			HSSFSheet planilha = arquivo.getSheetAt(0);
			
			Iterator<Row> iterator = planilha.iterator();
			
			while(iterator.hasNext()) {
				Row row = iterator.next();
				
				if(row.getRowNum() == 0) {
					continue;
				}
				
				Cell nome = row.getCell(0);
				Cell idade = row.getCell(1);
				Cell email = row.getCell(2);
				
				User user = new User();
				user.setNome(getvaluefromcell(nome));
				user.setIdade(getvaluefromcell(idade));
				user.setEmail(getvaluefromcell(email));
				
				userRepository.addUser(user);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private String getvaluefromcell(Cell cell) {
		
		if(cell.getCellType() == CellType.STRING) {
			return cell.getStringCellValue();
		}else if(cell.getCellType() == CellType.NUMERIC)  {
			return String.valueOf(cell.getNumericCellValue());
		}
		
		return "NAO SEI";
		
	}

}
