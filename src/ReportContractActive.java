
import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.awt.Color;

import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;


public class ReportContractActive { 
	
	public ReportContractActive() {
		build();
	}
	
	private void build() {	
		StyleBuilder boldStyle         = stl.style().bold();
		StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalAlignment(HorizontalAlignment.CENTER);
		StyleBuilder titleStyle        = stl.style(boldCenteredStyle)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setFontSize(15);
		
		StyleBuilder columnTitleStyle  = stl.style(boldCenteredStyle)
                .setBorder(stl.pen1Point())
            	.setBackgroundColor(new Color(210, 255, 210)); //light-green
		
		//all columns
		TextColumnBuilder<Integer>    rowNumberColumn = col.reportRowNumberColumn("No.")
               .setFixedColumns(2)
               .setHorizontalAlignment(HorizontalAlignment.CENTER);
		TextColumnBuilder<Integer>     contNo    = col.column("Contract NO",     "contNo",    type.integerType()).setFixedColumns(7).setHorizontalAlignment(HorizontalAlignment.CENTER);
		TextColumnBuilder<Integer>     roomNo    = col.column("Room NO",         "roomNo",    type.integerType()).setFixedColumns(6).setHorizontalAlignment(HorizontalAlignment.CENTER);
		TextColumnBuilder<String>      chInDate  = col.column("Check-in",   "chInDate",  type.stringType()).setHorizontalAlignment(HorizontalAlignment.CENTER);
		TextColumnBuilder<String>      chOutDate = col.column("Check-out",  "chOutDate", type.stringType()).setHorizontalAlignment(HorizontalAlignment.CENTER);
		TextColumnBuilder<String>      ter1 = col.column("Ternant#1",       "ter1",      type.stringType());
		TextColumnBuilder<String>      ter2 = col.column("Ternant#2",       "ter2",      type.stringType());
		TextColumnBuilder<String>      ter3 = col.column("Ternant#3",       "ter3",      type.stringType());
		
		try {
			String logoPath = getClass().getClassLoader().getResource(".").getPath()+"logo.png"; //get logo directory
			report()//create new report design
			 .setColumnTitleStyle(columnTitleStyle)
			  .highlightDetailEvenRows()
			   .columns(rowNumberColumn, contNo, roomNo, chInDate, chOutDate, ter1, ter2, ter3)
			  	
			  .title(//shows report title
			  	cmp.horizontalList()
			  		.add(
			  			cmp.image(logoPath).setFixedDimension(80, 80),
			  			cmp.text(" Salaya Tower \n Apartment Operation Reporter").setStyle(titleStyle).setHorizontalAlignment(HorizontalAlignment.LEFT),
			  			cmp.text("Active Leasing Contract").setStyle(titleStyle).setHorizontalAlignment(HorizontalAlignment.RIGHT))
			  		.newRow()
			  		.add(cmp.filler().setStyle(stl.style().setTopBorder(stl.pen2Point())).setFixedHeight(10)))
			  .pageFooter(cmp.pageXofY().setStyle(boldCenteredStyle), //shows number of page at page footer
					  cmp.text("Salaya Tower - Apartment Operation Reporter")) //show page footer
			  
			  .setDataSource(createDataSource())//set datasource
			  .show();//create and show report
		} catch (DRException e) {
			e.printStackTrace();
		}
	}
	
	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("contNo", "roomNo", "chInDate","chOutDate","ter1","ter2","ter3");	
			
		//collection of Data
		TernantCollection ternantData = new TernantCollection();
		ContractCollection contractData = new ContractCollection();
		//end of Collection of data
				
				for(int i=0;i<contractData.contractCollection.size();i++){
					String ter1,ter2,ter3;
					//If checkOutDate = "no" ,so this contract is not terminated (Active).
					if(contractData.contractCollection.get(i).getCheckOutDate().equals("no")){
						//must have first ternant in any room
						int terID1 = Integer.parseInt(contractData.contractCollection.get(i).getTernantID1())-1;
						ter1 = ternantData.ternantCollection.get(terID1).getFirstName() + " " +
								ternantData.ternantCollection.get(terID1).getLastName();
						//but not neccessary to have No2 and No3 ternant
						if(contractData.contractCollection.get(i).getTernantID2().equals("no")){
							ter2 = " - ";						
						}
						else {
							int terID2 = Integer.parseInt(contractData.contractCollection.get(i).getTernantID2())-1;
							ter2 = ternantData.ternantCollection.get(terID2).getFirstName() + " " +
									ternantData.ternantCollection.get(terID2).getLastName();
						}
						if(contractData.contractCollection.get(i).getTernantID3().equals("no")){
							ter3 = " - ";						
						}
						else {
							int terID3 = Integer.parseInt(contractData.contractCollection.get(i).getTernantID3())-1;
							ter3 = ternantData.ternantCollection.get(terID3).getFirstName() + " " +
									ternantData.ternantCollection.get(terID3).getLastName();
						}
						
						//add data
						dataSource.add(contractData.contractCollection.get(i).getContractNO(),
								contractData.contractCollection.get(i).getRoomNO(),
								contractData.contractCollection.get(i).getCheckInDate(),
								contractData.contractCollection.get(i).getCheckOutDate(),
								ter1, 
								ter2, 
								ter3);
					}			
				}
		
		return dataSource;
	}
	
	public static void main(String[] args) {
		new ReportContractActive();
	}
}