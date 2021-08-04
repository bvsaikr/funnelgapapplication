package com.tataelxsi.fga.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tataelxsi.fga.entity.FunnelBuc;
import com.tataelxsi.fga.entity.FunnelCustomer;
import com.tataelxsi.fga.entity.FunnelProject;
import com.tataelxsi.fga.entity.FunnelProjectCategory;
import com.tataelxsi.fga.entity.FunnelProjectProbability;
import com.tataelxsi.fga.entity.FunnelProjectStage;
import com.tataelxsi.fga.entity.FunnelRequirements;
import com.tataelxsi.fga.entity.FunnelSkill;
import com.tataelxsi.fga.repository.FunnelBucRepository;
import com.tataelxsi.fga.repository.FunnelCustomerRepository;
import com.tataelxsi.fga.repository.FunnelProjectCategoryRepository;
import com.tataelxsi.fga.repository.FunnelProjectProbabilityRepository;
import com.tataelxsi.fga.repository.FunnelProjectRepository;
import com.tataelxsi.fga.repository.FunnelProjectStageRepository;
import com.tataelxsi.fga.repository.FunnelRequirementsRepository;
import com.tataelxsi.fga.repository.FunnelSkillRepository;

@Service
public class FunnelService {
	
	
	@Autowired
	FunnelBucRepository bucrepo;
	
	@Autowired
	FunnelCustomerRepository custrepo;
	
	@Autowired
	FunnelProjectRepository projrepo;
	
	@Autowired
	FunnelProjectCategoryRepository pcrepo;
	
	@Autowired
	FunnelProjectProbabilityRepository pprepo;
	
	@Autowired
	FunnelProjectStageRepository psrepo;
	
	@Autowired
	FunnelRequirementsRepository reqrepo;
	
	@Autowired
	FunnelSkillRepository skillrepo;
	
	

	
	public ResponseEntity<Object> ImportExcelFile(MultipartFile file){
		
		
		
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook(file.getInputStream());
		
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		Iterator<Row> rows=sheet.iterator();
		
		Map<String,Integer> map=new HashMap<>();
		int rowNumber = 0;
		while (rows.hasNext()) {
			Row currentRow = rows.next();
			if(rowNumber == 0) {
				short minCol = currentRow.getFirstCellNum();
				short maxCol = currentRow.getLastCellNum();
				for(short colx=minCol;colx<maxCol;colx++) {
					org.apache.poi.ss.usermodel.Cell cell=currentRow.getCell(colx);
					map.put(cell.getStringCellValue().trim(),cell.getColumnIndex());
			
				}
				rowNumber++;
			}else {
			 
				FunnelRequirements fReq = new FunnelRequirements();
								
				fReq.setFunnelId((long) currentRow.getCell(map.get("FunnelID")).getNumericCellValue());
		
		        fReq.setJobDescription(currentRow.getCell(map.get("JobDescription")).getStringCellValue().trim());
			
			fReq.setNumberOfPositions((long)currentRow.getCell(map.get("Num_of_Positions")).getNumericCellValue());
			fReq.setRemarks(currentRow.getCell(map.get("Remarks")).getStringCellValue().trim());
			fReq.setReservedEmpNo(currentRow.getCell(map.get("ReservedEmpNo")).getStringCellValue().trim());
	
				
				fReq.setReservedNo(currentRow.getCell(map.get("ReservedNo")).getCellType() == org.apache.poi.ss.usermodel.CellType.NUMERIC
                        ? (long) currentRow.getCell(map.get("ReservedNo")).getNumericCellValue()
                        : currentRow.getCell(map.get("ReservedNo")).getStringCellValue().trim() != ""
                                ? Integer.valueOf(currentRow.getCell(map.get("ReservedNo"))
                                        .getStringCellValue().trim())
                                : 0);
				 fReq.setRequirementDate(currentRow.getCell(map.get("StartDate")).getDateCellValue()); 
				 
              				this.reqrepo.save(fReq);
				
				
			   
				FunnelCustomer fCust =new  FunnelCustomer ();
				 fCust.setCustomerName(currentRow.getCell(map.get("CustomerName")).getStringCellValue().trim());
				fReq.setfCust(fCust);
				 this.custrepo.save(fCust);
				
				FunnelBuc fBuc = new FunnelBuc();
                fBuc.setBuName(currentRow.getCell(map.get("BUName")).getStringCellValue().trim());
                fBuc.setCompetency(currentRow.getCell(map.get("Competency")).getStringCellValue().trim());
                fReq.setfBuc(fBuc);
                this.bucrepo.save(fBuc);
				
                FunnelProject fProj = new FunnelProject();
	             fProj.setCrmid((long)currentRow.getCell(map.get("CRMID")).getNumericCellValue());
	             fProj.setProjectName(currentRow.getCell(map.get("ProjectName")).getStringCellValue().trim());
	             fProj.setProjectOwner(currentRow.getCell(map.get("ProjectOwner")).getStringCellValue().trim());
	             fProj.setStartDate(currentRow.getCell(map.get("StartDate")).getDateCellValue());
	             fProj.setDurationInWeeks((long)currentRow.getCell(map.get("Duration_in_weeks")).getNumericCellValue());
	             fProj.setTotalProjectValueInLakhs(currentRow.getCell(map.get("TotalProjectValue_in_lakhs")).getNumericCellValue());
	             fProj.setTpvPerCompetency(currentRow.getCell(map.get("TPV_per_Competency")).getNumericCellValue());
	             fReq.setfProj(fProj);
	             this.projrepo.save(fProj);
	             
	             
	             FunnelProjectCategory fProCat = new FunnelProjectCategory();
				 fProCat.setCategory(currentRow.getCell(map.get("Category")).getStringCellValue().trim());
				 fReq.setfProjCat(fProCat);
				 this.pcrepo.save(fProCat);
				 
				 FunnelProjectProbability fProPro = new FunnelProjectProbability();
				 fProPro.setProbability(currentRow.getCell(map.get("Probability")).getStringCellValue().trim());
		        fReq.setfProjProb(fProPro);
				 this.pprepo.save(fProPro); 
		         
		         FunnelProjectStage fProjStage = new FunnelProjectStage();
					fProjStage.setStage(currentRow.getCell(map.get("Stage")).getStringCellValue().trim());
					fReq.setfProjStage(fProjStage);
					this.psrepo.save(fProjStage);
					
					FunnelSkill fSkill = new FunnelSkill();
					fSkill.setSkillName(currentRow.getCell(map.get("Skill_Name")).getStringCellValue().trim());
					fSkill.setLevel(currentRow.getCell(map.get("Level")).getStringCellValue().trim());
					fSkill.setExperience((long)currentRow.getCell(map.get("Experience")).getNumericCellValue());
					fReq.setfSkill(fSkill);
					this.skillrepo.save(fSkill);
			 
				 rowNumber++;			 
				 
			}
			
		
		}
		workbook.close();
		
		} catch (IOException e) {
		
			e.printStackTrace();
		}

		
		return new ResponseEntity<Object>(HttpStatus.CREATED);


}
}