package com.leandro.APIpeople.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.leandro.APIpeople.entities.ManagementPeople;
import com.leandro.APIpeople.repository.ManagementPeopleName;
import com.leandro.APIpeople.repository.ManagementPeopleRepository;

@Service
public class ManagementPeopleService {

	@Autowired
	private ManagementPeopleRepository managementPeopleRepository;
	
	@Autowired
	private ManagementPeopleName managementPeopleName;
	
	
	public List<ManagementPeople> createAll(List <ManagementPeople> managementPeople) {
		managementPeopleRepository.saveAll(managementPeople);
		return list();
	}

	public List<ManagementPeople> list() {
		
		return managementPeopleRepository.findAll();
	}

	public List<ManagementPeople> update(ManagementPeople managementPeople) {
		managementPeopleRepository.save(managementPeople);
		return list();
	}

	public List<ManagementPeople> delete(Long id) {
		managementPeopleRepository.deleteById(id);
		return list();
	}
	
	public Optional<ManagementPeople> buscarPorNome (String name) {
		return managementPeopleName.findByName(name);
	}
	
	public byte[] gerarRelatorio(List<ManagementPeople> managementPeoples) throws DocumentException, IOException {
		Document document = new Document();
		
		//fluxo de saida que armazena os dados em um byte array
		
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		//classe da biblioteca Itext que permite criar o documento em pdf
		
		
        PdfWriter.getInstance(document, byteArrayOutputStream);
        document.open();
        
        document.add(new Paragraph("Relatório de pessoas cadastradas:"));
        
        for (ManagementPeople managementPeople : managementPeoples) {
        	document.add(new Paragraph("\n"));
        	document.add(new Paragraph("ID: " + managementPeople.getId()));
            document.add(new Paragraph("Nome: " + managementPeople.getName()));
            document.add(new Paragraph("Cpf: " + managementPeople.getCpf()));
            document.add(new Paragraph("Email: " + managementPeople.getEmail()));
            document.add(new Paragraph("Numero: " + managementPeople.getNumero()));
            document.add(new Paragraph("\n"));
        }
        
        document.close();
        
        return byteArrayOutputStream.toByteArray();
	}
}
