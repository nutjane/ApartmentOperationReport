# Apartment Operation Reporter

5688043 Mr.Nut Janekitiworapong Section 1
5688196 Ms.Peeraya Thanomboon Section 1
5688260	Mr.Panupong Matankarat Section1
————————————————————————————————————————————————————————————————
List of Classes ,Methods, and fields

Invoice: keep the following information and get method of these information
> contractNo
> month
> year
> electricUsed
> waterUsed
> datePaid

Constructor
public Invoice(int contractNO, int month, int year, double electricUsed, double waterUsed, String datePaid)
 : use to initialize the value

List of method - public int getContractNO()
		public int getMonth()
		public int getYear() 
		public double getElectricUsed()
		public double getWaterUsed()
		public String getDatePaid()
List of fields 
int contractNo 		: contract number of that invoice
int month		: month of that invoice
int year		: year of that invoice
double electricUsed	: amount of electricity used (units)
double waterUsed	: amount of water used (units)
String datePaid		: the day that paid or “no” for unpaid
—————————————————————————————————

InvoiceCollection: keep the collection of invoices in the type of Arraylist and contain a ReadFile method to read its file
Filed
List<Invoice> invoiceCollection : Data Collection

Constructor
public Fee(){ this.ReadFile(); } 
: use to force to ReadFile when create new object

List of method - public void ReadFile()
—————————————————————————————————

Room: keep the following information and get method of these information
> roomNo
> roomType
> roomPrice

Constructor
public Room(int roomNO, String roomType, double roomPrice){
 : use to initialize the value

List of method - public int getRoomNO()
		public String getRoomType()
		public double getRoomPrice()
List of fields 
int roomNo		: room number
String roomType		: room type
double roomPrice	: room price
—————————————————————————————————

RoomCollection: keep the collection of invoices in the type of Arraylist and contain a ReadFile method to read its file

Filed
List<Room> roomCollection : data collection

Constructor
public Fee(){ this.ReadFile(); } 
: use to force to ReadFile when create new object

List of method - public void ReadFile()
—————————————————————————————————

Ternant: keep the following information and get method of these information
> TenantID
> firstName
> lastName
> gender
> birthDay

Constructor
public Ternant(int ternantID, String firstName, String lastName, String gender, String birthDay){
 : use to initialize the value

List of method - public int getTernantID()
		public String getFirstName()
		public String getLastName()
		public String getGender()
		public String getBirthDay()
List of fields 
int TernantID		: ID of that tenant
String firstName	: tenant’s first name
String lastName		: tenant’s last name
String gender		: tenant’s gender
String birthDay		: tenant’s birthday
—————————————————————————————————

TernantCollection: keep the collection of invoices in the type of Arraylist and contain a ReadFile method to read its file

Field
List<Ternant> ternantCollection : Data collection

Constructor
public Fee(){ this.ReadFile(); } 
: use to force to ReadFile when create new object

List of method - public void ReadFile()
—————————————————————————————————

Contract: keep the following information and get method of these information
> contractNo
> roomNo
> tenantID1
> tenantID2
> tenantID3
> checkInDate
> checkOutDate

Constructor
public Contract(int contractNo, int roomNO, String ternantID1, String ternantID2, String ternantID3, String checkInDate, String checkOutDate){
 : use to initialize the value

List of method - public int getContractNO()
		public int getRoomNO()
		public String getTernantID1() 
		public String getTernantID2() 
		public String getTernantID3() 
		public String getCheckInDate() 
		public String getCheckOutDate()
List of fields 
int contractNo		: contract number
int roomNo		: room number of that contract
String ternantID1	: 1st tenant of that contract
String ternantID2	: 2nd tenant of that contract
String ternantID3	: 3rd tenant of that contract
String checkInDate	: check in date
String checkOutDate	: check out date or “no” for still in this apartment
—————————————————————————————————

ContractCollection:  keep the collection of invoices in the type of Arraylist and contain a ReadFile method to read its file

Field
List<Contract> contractCollection : Data collection

Constructor
public Fee(){ this.ReadFile(); } 
: use to force to ReadFile when create new object

List of method - public void ReadFile()
—————————————————————————————————

Fee: keep the following information and get method of these information
> electricityFee
> waterFee
> internetFee

Constructor
public Fee(){ this.ReadFile(); } 
: use to force to ReadFile when create new Fee object

List of method - public double getElectricFee() 
		public double getWaterFee() 
		public double getInternetFee()
		public void ReadFile()
List of fields 
double electricityFee	: electricity fee (baht/unit)
double waterFee		: water fee (baht/unit)
double internetFee	: internet fee (baht/month)
—————————————————————————————————

ReportContractAll :

Constructor
public ReportContractAll()
: use to force to go into build() method

List of method
- build
	use to create this report set text and data
	- reportDesign set style of report
	- title create a logo and text
	- page footer show number of page
	- setDataSource set data from JRDataSource createDataSource
- JRDataSource createDataSource
        use to keep and set data
	- loop for check data, use all data
	- keep people data to string variable use if to check
		- first check ter1 (must have this tenant)
		- second and third if check ter2,ter3 (ter2,ter3 are not required)
	- dataSource.add use to keep data to return parameters 
	  to ReportContractAll and show table
—————————————————————————————————

ReportContractActive :

Constructor
public ReportContractActive()
: use to force to go into build() method

List of method
- build
	use to create this report, set text and data
	- reportDesign set style of report
	- title create a logo and text
	- page footer show number of page
	- setDataSource set data from JRDataSource createDataSource
- JRDataSource createDataSource
        use to keep and set data
	- loop for check data, and if checkOutDate equals “no” (active)
	- keep people data to string variable use if to check
		- first check ter1 (must have this tenant)
		- second and third if check ter2,ter3 (ter2,ter3 are not required)
	- dataSource.add use to keep data to return parameters 
	  to ReportContractAll and show table
—————————————————————————————————

ReportContractTerminated :

Constructor
public ReportContractTerminated()
: use to force to go into build() method

List of method
- build
	use to create this report set text and data
	- reportDesign set style of report
	- title create a logo and text
	- page footer show number of page
	- setDataSource set data from JRDataSource createDataSource
- JRDataSource createDataSource
        use to keep and set data
	- loop for check data, and if checkOutDate not equals “no”
	- keep people data to string variable use if to check
		- first check ter1 (must have this tenant)
		- second and third if check ter2,ter3 (ter2,ter3 are not required)
	- dataSource.add use to keep data to return parameters 
	  to ReportContractAll and show table
—————————————————————————————————

ReportInvoiceAll :

Constructor
public ReportInvoiceAll()
: use to force to go into build() method

List of method
- build
	use to create this report set text and data
	- reportDesign set style of report
	- title create a logo and text
	- page footer show number of page
	- setDataSource set data from JRDataSource createDataSource
- JRDataSource createDataSource
        use to keep and set data
	- create collection data
	- use for keep data number to print on table
	- return data to build
—————————————————————————————————

ReportInvoicePaid :

Constructor
public ReportInvoicePaid()
: use to force to go into build() method

List of method
- build
	use to create this report set text and data
	- reportDesign set style of report
	- title create a logo and text
	- page footer show number of page
	- setDataSource set data from JRDataSource createDataSource
- JRDataSource createDataSource
        use to keep and set data
	- create collection data
	- use if to check datePaid if not equals "no" 
	- if true use for keep data number to print on table
	- return data to build
—————————————————————————————————

ReportInvoiceUnpaid

Constructor
public ReportInvoiceUnpaid()
: use to force to go into build() method

- build
	use to create this report set text color and data
	- reportDesign set style of report
	- title create a logo and text
	- page footer show number of page
	- setDataSource set data from JRDataSource createDataSource
- JRDataSource createDataSource
        use to keep and set data
	- create collection data
	- use if to check datePaid if equal "no" 
	- if true use for keep data number to print on table
	- return data to build
—————————————————————————————————

ReportUsedElectricity

Constructor
public ReportUsedElectricity(int startMonth, int startYear, int endMonth, int endYear)
: use to force to go into build() method with given interval (time)


- build
	use to create this report set text and data
	- reportDesign set style of report
	- title create a logo and text
	- page footer show number of page
	- setDataSource set data from JRDataSource createDataSource
- JRDataSource createDataSource
        use to keep and set data
	- use while to find how many months in this interval
	- use for to keep data each month then use dataSource.add to check month to
	  run in loop and return data to bulid
- Date toDate
	- set time to return
—————————————————————————————————

ReportUsedWater

Constructor
public ReportUsedWater(int startMonth, int startYear, int endMonth, int endYear)
: use to force to go into build() method with given interval (time)

- build
	use to create this report set text and data
	- reportdesign set style of report
	- title create a logo and text
	- page footer show number of page
	- setDataSource set data from JRDataSource createDataSource
- JRDataSource createDataSource
        use to keep and set data
	- use while to find how many months in this interval
	- use for to keep data each month then use dataSource.add to check month to
	  run in loop and return data to bulid
- Date toDate
	- set time to return	
—————————————————————————————————	

APP : The main menu window of the program which can choose to the following window
   - the contract report window
   - the invoice report window
   - the usage water report window
   - the usage electricity report window

List of method - [JFrame] (for set the window frame)
                 setType (for set the window type)
                 setForeground (for set the color of text in title bar)
                 setFont (for set the font of text in title bar)
		 setIconImage (for set the icon image in title bar)
                 setDefaultCloseOperation (for set the close option of the window)
                 setBounds (for set the size of the window frame)
	      
	       - [Jlabel] (for set the sentence and picture)
                 setForeground (for set the color of text )
                 setFont (for set the color of text )
                 setIcon (for set the image in frame)
                 setHorizontalAlignment (for set the position of text or picture)


	       - [JButton] (for set the button)
                 setToolTipText (for give the user what the button is)
                 addActionListener (for give an action to the button)
		 setForeground (for set the color of text )
                 setFont (for set the color of text )
                 setBackground (for set the color of the box)
                 setHorizontalAlignment (for set the position of text or picture)
                 setBounds (for set the size of the button)

continue in the comment of the class in the program
—————————————————————————————————

APPC : The contract window which can choose to link to the following contract report
   - the active contract report 
   - the terminated contract report
   - both of the contract report

List of method - [JFrame] (for set the window frame)
                 setType (for set the window type)
                 setForeground (for set the color of text in title bar)
                 setFont (for set the font of text in title bar)
		 setIconImage (for set the icon image in title bar)
                 setDefaultCloseOperation (for set the close option of the window)
                 setBounds (for set the size of the window frame)
	      
	       - [Jlabel] (for set the sentence and picture)
                 setForeground (for set the color of text )
                 setFont (for set the color of text )
                 setIcon (for set the image in frame)
                 setHorizontalAlignment (for set the position of text or picture)


	       - [JButton] (for set the button)
                 setToolTipText (for give the user what the button is)
                 addActionListener (for give an action to the button)
		 setForeground (for set the color of text )
                 setFont (for set the color of text )
                 setBackground (for set the color of the box)
                 setHorizontalAlignment (for set the position of text or picture)
                 setBounds (for set the size of the button)

continue in the comment of the class in the program
—————————————————————————————————

APPI : The invoice window which can choose to link to the following contract report
   - the paid invoice report 
   - the unpaid invoice report
   - both of the invoice report

List of method - [JFrame] (for set the window frame)
                 setType (for set the window type)
                 setForeground (for set the color of text in title bar)
                 setFont (for set the font of text in title bar)
		 setIconImage (for set the icon image in title bar)
                 setDefaultCloseOperation (for set the close option of the window)
                 setBounds (for set the size of the window frame)
	      
	       - [Jlabel] (for set the sentence and picture)
                 setForeground (for set the color of text )
                 setFont (for set the color of text )
                 setIcon (for set the image in frame)
                 setHorizontalAlignment (for set the position of text or picture)


	       - [JButton] (for set the button)
                 setToolTipText (for give the user what the button is)
                 addActionListener (for give an action to the button)
		 setForeground (for set the color of text )
                 setFont (for set the color of text )
                 setBackground (for set the color of the box)
                 setHorizontalAlignment (for set the position of text or picture)
                 setBounds (for set the size of the button)

continue in the comment of the class in the program
—————————————————————————————————

APPE : The usage electricity window which can link to the usage electricity report that according to
   - the start date 
   - the lastest date

List of method - [JFrame] (for set the window frame)
                 setType (for set the window type)
                 setForeground (for set the color of text in title bar)
                 setFont (for set the font of text in title bar)
		 setIconImage (for set the icon image in title bar)
                 setDefaultCloseOperation (for set the close option of the window)
                 setBounds (for set the size of the window frame)
	      
	       - [Jlabel] (for set the sentence and picture)
                 setForeground (for set the color of text )
                 setFont (for set the color of text )
                 setIcon (for set the image in frame)
                 setHorizontalAlignment (for set the position of text or picture)

	       - [JButton] (for set the button)
                 setToolTipText (for give the user what the button is)
                 addActionListener (for give an action to the button)
		 setForeground (for set the color of text )
                 setFont (for set the color of text )
                 setBackground (for set the color of the box)
                 setHorizontalAlignment (for set the position of text or picture)
                 setBounds (for set the size of the button)


               - [JComboBox] (for set the box that can choose the item)
                 setToolTipText (for give the user what the button is)
                 setModel (for set the list that is the choice that you have to choose)
		 addActionListener (for give an action to the button)
		 setForeground (for set the color of text )
                 setFont (for set the color of text )
                 setBackground (for set the color of the box)
                 setBounds (for set the size of the box)

continue in the comment of the class in the program
—————————————————————————————————

APPW : The usage water window which can link to the usage water report that according to
   - the start date 
   - the lastest date

List of method - [JFrame] (for set the window frame)
                 setType (for set the window type)
                 setForeground (for set the color of text in title bar)
                 setFont (for set the font of text in title bar)
		 setIconImage (for set the icon image in title bar)
                 setDefaultCloseOperation (for set the close option of the window)
                 setBounds (for set the size of the window frame)
	      
	       - [Jlabel] (for set the sentence and picture)
                 setForeground (for set the color of text )
                 setFont (for set the color of text )
                 setIcon (for set the image in frame)
                 setHorizontalAlignment (for set the position of text or picture)

	       - [JButton] (for set the button)
                 setToolTipText (for give the user what the button is)
                 addActionListener (for give an action to the button)
		 setForeground (for set the color of text )
                 setFont (for set the color of text )
                 setBackground (for set the color of the box)
                 setHorizontalAlignment (for set the position of text or picture)
                 setBounds (for set the size of the button)


               - [JComboBox] (for set the box that can choose the item)
                 setToolTipText (for give the user what the button is)
                 setModel (for set the list that is the choice that you have to choose)
		 addActionListener (for give an action to the button)
		 setForeground (for set the color of text )
                 setFont (for set the color of text )
                 setBackground (for set the color of the box)
                 setBounds (for set the size of the box)

continue in the comment of the class in the program

————————————————————————————————————————————————————————————————
How to compile and run 

1) Open a “APP.java” file to compile and run our program
2) Choose type of reports that you want
3) Input some specific value of that report (if required)
4) Get a report, you can print or save that report
————————————————————————————————————————————————————————————————
