import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.util.Calendar;
import java.util.Date;

import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.TimePeriod;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;


public class ReportUsedWater{

 	public ReportUsedWater(int startMonth, int startYear, int endMonth, int endYear) {
		build(startMonth, startYear, endMonth, endYear);
	}

	private void build(int startMonth, int startYear, int endMonth, int endYear) {
		FontBuilder boldFont	 		= stl.fontArialBold().setFontSize(12);
		StyleBuilder boldStyle         	= stl.style().bold();
		StyleBuilder boldCenteredStyle 	= stl.style(boldStyle).setHorizontalAlignment(HorizontalAlignment.CENTER);
		StyleBuilder titleStyle        	= stl.style(boldCenteredStyle)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setFontSize(15);
		TextColumnBuilder<Date> orderDateColumn = col.column("Order date", "orderdate", type.dateYearToMonthType());
		TextColumnBuilder<Integer> unitColumn = col.column("Unit", "unit", type.integerType());
		try {
			String logoPath = getClass().getClassLoader().getResource(".").getPath()+"logo.png"; //get logo directory
			report()
		
				 .title(//shows report title
			  	cmp.horizontalList()
			  		.add(
			  			cmp.image(logoPath).setFixedDimension(80, 80),
			  			cmp.text(" Salaya Tower \n Apartment Operation Reporter").setStyle(titleStyle).setHorizontalAlignment(HorizontalAlignment.LEFT),
			  			cmp.text("Water Usage").setStyle(titleStyle).setHorizontalAlignment(HorizontalAlignment.RIGHT))
			  		.newRow()
			  		.add(cmp.filler().setStyle(stl.style().setTopBorder(stl.pen2Point())).setFixedHeight(10)))
			  .pageFooter(cmp.pageXofY().setStyle(boldCenteredStyle), //shows number of page at page footer
					  cmp.text("Salaya Tower - Apartment Operation Reporter")) //show page footer
			  
				.summary(//show table
					cht.timeSeriesChart()
						.setTitle("Water Usage")
						.setTitleFont(boldFont)
						.setTimePeriod(orderDateColumn)
						.setTimePeriodType(TimePeriod.MONTH)
						.series(
							cht.serie(unitColumn))
						.setTimeAxisFormat(
							cht.axisFormat().setLabel("Date")))
				.setDataSource(createDataSource(startMonth, startYear, endMonth, endYear))
				.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private JRDataSource createDataSource(int startMonth, int startYear, int endMonth, int endYear) {
		
		//set of data
		InvoiceCollection invoiceData = new InvoiceCollection();
		DRDataSource dataSource = new DRDataSource("orderdate", "unit");
		//find how many months in this interval
		int count=0, month=startMonth-1, year=startYear;
		while( month!=endMonth || year!=endYear){
			
			if(month == 12) {
				month = 1;
				count++;
				year++;
			}
			else {
				month++;
				count++;
				
			}
		}
		//reset variable
		month=startMonth;
		year=startYear;
				
		int usage=0;
		for(int i=0;i<count;i++){
			for(int j=0;j<invoiceData.invoiceCollection.size();j++){
				
				if(invoiceData.invoiceCollection.get(j).getMonth() == month && 
						invoiceData.invoiceCollection.get(j).getYear() == year){
					usage += invoiceData.invoiceCollection.get(j).getWaterUsed();
				}								
			}
			dataSource.add(toDate(year, month), usage);
			usage = 0;
			if(month == 12) {
				month = 1;
				year++;
			}
			else {
				month++;
				
			}
			
		}
		
		return dataSource;
	}

	private Date toDate(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month -1);
		return c.getTime();
	}

	public static void main(String[] args) {
		 //new ReportUsedWater(1,1,1,1);
	}
}