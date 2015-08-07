
import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.awt.Color;
import java.math.BigDecimal;

import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;


public class ReportInvoiceAll { 
	
	public ReportInvoiceAll() {
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
                .setBackgroundColor(new Color(102, 178, 255)); //blue
		
		TextColumnBuilder<Integer>    rowNumberColumn = col.reportRowNumberColumn("No.")
               .setFixedColumns(2)
               .setHorizontalAlignment(HorizontalAlignment.CENTER);
		TextColumnBuilder<Integer>     contNo      = col.column("Contract", 		"contNo",    type.integerType()).setFixedColumns(5).setHorizontalAlignment(HorizontalAlignment.CENTER);
		TextColumnBuilder<Integer>     roomNo      = col.column("Room",				"roomNo",    type.integerType()).setFixedColumns(3).setHorizontalAlignment(HorizontalAlignment.CENTER);
		TextColumnBuilder<String>      month       = col.column("Month",  		 	"month",    type.stringType()).setFixedColumns(4).setHorizontalAlignment(HorizontalAlignment.CENTER);
		TextColumnBuilder<String>      year        = col.column("Year",	  			"year",    type.stringType()).setFixedColumns(4).setHorizontalAlignment(HorizontalAlignment.CENTER);
		TextColumnBuilder<BigDecimal>  eleFee      = col.column("Electricity Fee", 	"eleFee",  type.bigDecimalType()).setHorizontalAlignment(HorizontalAlignment.CENTER);
		TextColumnBuilder<BigDecimal>  waterFee    = col.column("Water Fee",		"waterFee", type.bigDecimalType()).setHorizontalAlignment(HorizontalAlignment.CENTER);
		TextColumnBuilder<BigDecimal>  internetFee = col.column("Internet Fee",		"internetFee", type.bigDecimalType()).setHorizontalAlignment(HorizontalAlignment.CENTER);
		TextColumnBuilder<BigDecimal>  rentalFee   = col.column("Rental Fee",		"rentalFee", type.bigDecimalType()).setHorizontalAlignment(HorizontalAlignment.CENTER);
		TextColumnBuilder<BigDecimal>  total       = col.column("TOTAL",			"total", type.bigDecimalType()).setHorizontalAlignment(HorizontalAlignment.CENTER);
		TextColumnBuilder<String>      datePaid    = col.column("Paid",           	"datePaid",    type.stringType()).setHorizontalAlignment(HorizontalAlignment.CENTER);
		
		try {
			String logoPath = getClass().getClassLoader().getResource(".").getPath()+"logo.png"; //get logo directory
			report()//create new report design
			 .setColumnTitleStyle(columnTitleStyle)
			  .highlightDetailEvenRows()
			   .columns(rowNumberColumn, contNo, roomNo, month, year, eleFee, waterFee, internetFee, rentalFee, total, datePaid)
			  	
			  .title(//shows report title
			  	cmp.horizontalList()
			  		.add(
			  			cmp.image(logoPath).setFixedDimension(80, 80),
			  			cmp.text(" Salaya Tower \n Apartment Operation Reporter").setStyle(titleStyle).setHorizontalAlignment(HorizontalAlignment.LEFT),
			  			cmp.text("All invoices").setStyle(titleStyle).setHorizontalAlignment(HorizontalAlignment.RIGHT))
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
		DRDataSource dataSource = new DRDataSource( "contNo", "roomNo","month" ,"year" , "eleFee", "waterFee", "internetFee", "rentalFee", "total", "datePaid");
		
			
		//collection of Data
		Fee feeData = new Fee();
		ContractCollection contractData = new ContractCollection();
		InvoiceCollection invoiceData = new InvoiceCollection();
		RoomCollection roomData = new RoomCollection();
		//end of Collection of data
						
		for(int i=0;i<invoiceData.invoiceCollection.size();i++){
			//add data
			dataSource.add(invoiceData.invoiceCollection.get(i).getContractNO(),
				contractData.contractCollection.get((invoiceData.invoiceCollection.get(i).getContractNO())-1).getRoomNO(),
				Integer.toString(invoiceData.invoiceCollection.get(i).getMonth()),
				Integer.toString(invoiceData.invoiceCollection.get(i).getYear()),
				new BigDecimal(invoiceData.invoiceCollection.get(i).getElectricUsed()*feeData.getElectricFee()),
				new BigDecimal(invoiceData.invoiceCollection.get(i).getWaterUsed()*feeData.getWaterFee()),
				new BigDecimal(feeData.getInternetFee()),
				new BigDecimal(roomData.roomCollection.get((contractData.contractCollection.get((invoiceData.invoiceCollection.get(i).getContractNO())-1).getRoomNO())-1).getRoomPrice()),
				//total column
				new BigDecimal(invoiceData.invoiceCollection.get(i).getElectricUsed()*feeData.getElectricFee()+
				invoiceData.invoiceCollection.get(i).getWaterUsed()*feeData.getWaterFee()+
				feeData.getInternetFee()+
				roomData.roomCollection.get((contractData.contractCollection.get((invoiceData.invoiceCollection.get(i).getContractNO())-1).getRoomNO())-1).getRoomPrice()					
				),
				invoiceData.invoiceCollection.get(i).getDatePaid()
			);
			
						
		}
		
		return dataSource;
	}
	
	public static void main(String[] args) {
		new ReportInvoiceAll();
	}
}