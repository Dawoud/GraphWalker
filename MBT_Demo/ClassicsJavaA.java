//This file is part of the Model-based Testing java package
//Copyright (C) 2005  Kristian Karl
//
//This program is free software; you can redistribute it and/or
//modify it under the terms of the GNU General Public License
//as published by the Free Software Foundation; either version 2
//of the License, or (at your option) any later version.
//
//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with this program; if not, write to the Free Software
//Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.


import resources.ClassicsJavaAHelper;

import com.rational.test.ft.ObjectNotFoundException;
import com.rational.test.ft.script.*;
import java.util.*;
import org.apache.log4j.*;
import mbt.ModelBasedTesting;

/**
 * Description   : XDE Tester Script
 * @author krikar
 */
public class ClassicsJavaA extends ClassicsJavaAHelper
{
	private static Logger  _logger = Logger.getLogger( ClassicsJavaA.class );
	private static Random  _radomGenerator = new Random();

	private static String _dataPath = new String( "C:/Documents and Settings/Kristian Karl/Mina dokument/tigris/MBT_Demo/data/" );
	private static String _yEdPath  = new String( "C:/Documents and Settings/Kristian Karl/Mina dokument/tigris/MBT_Demo/yEd/" );

	private ModelBasedTesting _mbt;

	public void testMain (Object[] args)
	{
		BasicConfigurator.configure();
		_logger.setLevel( Level.ALL );


		try
		{
			_mbt = new ModelBasedTesting( _yEdPath + "ClassicsJavaA.graphml ",
										  this,
										  _logger );

			//_mbt.runRandomWalk( 3600 );
			_mbt.runUntilAllEdgesVisited();
		}
		catch ( RuntimeException e )
		{
			logError( e.getMessage() );
		}
		logInfo( _mbt.get_statistics() );
	}

	/**
	 * Denna metod implementerar verifieringen
	 * av tillst�ndet: AboutClassicsCD
	 */
	public void AboutClassicsCD()
	{
		logInfo( "AboutClassicsCD" );
		if ( AboutClassicsCDVP().performTest() == false )
		{
			throw new RuntimeException( "Verifieringen misslyckades" );
		}
	}

	/**
	 * Denna metod implementerar verifieringen
	 * av tillst�ndet: Administration
	 */
	public void Administration()
	{
		logInfo( "Administration" );
		if ( AdministrationVP().performTest() == false )
		{
			throw new RuntimeException( "Verifieringen misslyckades" );
		}
	}

	/**
	 * Denna metod implementerar verifieringen
	 * av tillst�ndet: ViewOrderStatus
	 */
	public void ViewOrderStatusLogin()
	{
		logInfo( "ViewOrderStatus" );
		if ( ViewOrderStatusLoginVP().performTest() == false )
		{
			throw new RuntimeException( "Verifieringen misslyckades" );
		}
	}

	/**
	 * Denna metod implementerar verifieringen
	 * av tillst�ndet: MainPage
	 */
	public void MainPage()
	{
		logInfo( "MainPage" );
		ClassicsJava(ANY,MAY_EXIT).waitForExistence();
		sleep( 0.5 );
		if ( MainPageVP().performTest() == false )
		{
    		throw new RuntimeException( "Verifieringen misslyckades" );
		}
	}

	/**
	 * Denna metod implementerar verifieringen
	 * av tillst�ndet: Stop
	 */
	public void Stop()
	{
		logInfo( "Stop" );
		try
		{
			ClassicsJava().waitForExistence( 2, 2 );
    		throw new RuntimeException( "Verifieringen misslyckades" );
		}
		catch ( ObjectNotFoundException e )
		{
			;
		}
	}

	/**
	 * Denna metod implementerar verifieringen
	 * av tillst�ndet: MemberLogon
	 */
	public void MemberLogon()
	{
		logInfo( "MemberLogon" );
		if ( MemberLogonVP().performTest() == false )
		{
			throw new RuntimeException( "Verifieringen misslyckades" );
		}
	}

	/**
	 * Denna metod implementerar verifieringen
	 * av tillst�ndet: Start
	 */
	public void Start()
	{
		logInfo( "Start" );
	}

	/**
	 * Denna metod implementerar �verg�ngen: StartAgain
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void StartAgain()
	{
		logInfo( "StartAgain" );
	}

	/**
	 * Denna metod implementerar �verg�ngen: MemberlogonCancel
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void MemberlogonCancel()
	{
		logInfo( "MemberlogonCancel" );
		Cancel().waitForExistence();
		Cancel().click();
	}

	/**
	 * Denna metod implementerar �verg�ngen: AdministrationCancel
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void AdministrationCancel()
	{
		logInfo( "AdministrationCancel" );
		Cancel2().waitForExistence();
        Cancel2().click();
	}

	/**
	 * Denna metod implementerar �verg�ngen: ButtonPlaceOrder
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void ButtonPlaceOrder()
	{
		logInfo( "PlaceOrder" );
		PlaceOrder().waitForExistence();
        PlaceOrder().click();
	}

	/**
	 * Denna metod implementerar �verg�ngen: Order_PlaceNewOrder
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void Order_PlaceNewOrder()
	{
		logInfo( "Order_PlaceNewOrder" );
		menylist().waitForExistence();
        menylist().click(atPath("Order"));
        menylist().click(atPath("Order->Place New Order..."));
	}

	/**
	 * Denna metod implementerar �verg�ngen: About_OK
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void About_OK()
	{
		logInfo( "About_OK" );
		OK2().waitForExistence();
        OK2().click();
	}

	/**
	 * Denna metod implementerar �verg�ngen: ViewOrderStatusCancel
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void ViewOrderStatusCancel()
	{
		logInfo( "ViewOrderStatusCancel" );
		Cancel3().waitForExistence();
        Cancel3().click();
	}

	/**
	 * Denna metod implementerar �verg�ngen: Order_ViewExistingOrderStatus
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void Order_ViewExistingOrderStatus()
	{
		logInfo( "Order_ViewExistingOrderStatus" );
		menylist().waitForExistence();
		menylist().click(atPath("Order"));
		menylist().click(atPath("Order->View Existing Order Status..."));
	}

	/**
	 * Denna metod implementerar �verg�ngen: Admin_Orders
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void Admin_Orders()
	{
		logInfo( "Admin_Orders" );
		menylist().waitForExistence();
        menylist().click(atPath("Admin"));
        menylist().click(atPath("Admin->Orders..."));
	}

	/**
	 * Denna metod implementerar �verg�ngen: Admin_Customers
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void Admin_Customers()
	{
		logInfo( "Admin_Customers" );
		menylist().waitForExistence();
        menylist().click(atPath("Admin"));
        menylist().click(atPath("Admin->Customers..."));
	}

	/**
	 * Denna metod implementerar �verg�ngen: Admin_Options
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void Admin_Options()
	{
		logInfo( "Admin_Options" );
		menylist().waitForExistence();
        menylist().click(atPath("Admin"));
        menylist().click(atPath("Admin->Options..."));
	}

	/**
	 * Denna metod implementerar �verg�ngen: Admin_Products
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void Admin_Products()
	{
		logInfo( "Admin_Products" );
		menylist().waitForExistence();
        menylist().click(atPath("Admin"));
        menylist().click(atPath("Admin->Products..."));
	}

	/**
	 * Denna metod implementerar �verg�ngen: Admin_ClearDatabase
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void Admin_ClearDatabase()
	{
		logInfo( "Admin_ClearDatabase" );
		menylist().waitForExistence();
        menylist().click(atPath("Admin"));
        menylist().click(atPath("Admin->Clear Database"));
	}

	/**
	 * Denna metod implementerar �verg�ngen: Help_AboutClassicsCD
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void Help_AboutClassicsCD()
	{
		logInfo( "Help_AboutClassicsCD" );
		menylist().waitForExistence();
        menylist().drag(atPath("Help"));
        menylist().click(atPath("Help->About Classics Java"));
	}

	/**
	 * Denna metod implementerar �verg�ngen: CloseApp
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void CloseApp()
	{
		logInfo( "CloseApp" );
        ClassicsJava(ANY,MAY_EXIT).close();
	}

	/**
	 * Denna metod implementerar �verg�ngen: Initiera
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void Initiera()
	{
		logInfo( "Initiera" );
		startApp("ClassicsJavaA");
	}

	/**
	 * Denna metod implementerar verifieringen
	 * av tillst�ndet: PlaceAnOrder
	 */
	public void PlaceAnOrder()
	{
		logInfo( "PlaceAnOrder" );
		if ( PlaceAnOrderVP().performTest() == false )
		{
			throw new RuntimeException( "Verifieringen misslyckades" );
		}
	}

	/**
	 * Denna metod implementerar �verg�ngen: MemberLogonOK
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void MemberLogonOK()
	{
		logInfo( "MemberLogonOK" );
		OK().waitForExistence();
        OK().click();
	}

	/**
	 * Denna metod implementerar �verg�ngen: PlaceAnOrderCancel
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void PlaceAnOrderCancel()
	{
		logInfo( "PlaceAnOrderCancel" );
		Cancel4().waitForExistence();
        Cancel4().click();
	}

	/**
	 * Denna metod implementerar verifieringen
	 * av tillst�ndet: IncompleteOrder
	 */
	public void IncompleteOrder()
	{
		logInfo( "IncompleteOrder" );
		if ( IncompleteOrderVP().performTest() == false )
		{
			throw new RuntimeException( "Verifieringen misslyckades" );
		}
	}

	/**
	 * Denna metod implementerar verifieringen
	 * av tillst�ndet: ViewExistingOrder
	 */
	public void ViewExistingOrder()
	{
		logInfo( "ViewExistingOrder" );
		if ( ViewExistingOrderVP().performTest() == false )
		{
			throw new RuntimeException( "Verifieringen misslyckades" );
		}
	}

	/**
	 * Denna metod implementerar �verg�ngen: PlaceOrderButton
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void PlaceOrderButton()
	{
		logInfo( "PlaceOrderButton" );
		PlaceOrder2().waitForExistence();
        PlaceOrder2().click();
	}

	/**
	 * Denna metod implementerar �verg�ngen: ViewOrderStatusLoginOK
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void ViewOrderStatusLoginOK()
	{
		logInfo( "ViewOrderStatusLoginOK" );
		OK5().waitForExistence();
        OK5().click();
	}

	/**
	 * Denna metod implementerar �verg�ngen: ViewExistingOrderClose
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void ViewExistingOrderClose()
	{
		logInfo( "ViewExistingOrderClose" );
		Close2().waitForExistence();
        Close2().click();
	}

	/**
	 * Denna metod implementerar �verg�ngen: IncompleteOrderOK
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void IncompleteOrderOK()
	{
		logInfo( "IncompleteOrderOK" );
		OK3().waitForExistence();
        OK3().click();
	}

	/**
	 * Denna metod implementerar verifieringen
	 * av tillst�ndet: Splash
	 */
	public void Splash()
	{
		logInfo( "Nod: Splash" );
		/*setOption( IOptionName.FIND_OBJECT_DELAY_BETWEEN_RETRIES, 0.1 );
		if ( SplashVP().performTest() == false )
		{
			resetOption( IOptionName.FIND_OBJECT_DELAY_BETWEEN_RETRIES );
			throw new RuntimeException( "Verifieringen misslyckades" );

		}
		resetOption( IOptionName.FIND_OBJECT_DELAY_BETWEEN_RETRIES );
		*/
	}

	/**
	 * Denna metod implementerar �verg�ngen: SplashDone
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void SplashDone()
	{
		logInfo( "�verg�ng: SplashDone" );
		boolean PlaceOrder_visible = ((Boolean)placeOrder().getProperty("visible")).booleanValue();
		while ( PlaceOrder_visible == false )
		{
			sleep( 1 );
			PlaceOrder_visible = ((Boolean)placeOrder().getProperty("visible")).booleanValue();
			_logger.info( "V�ntar p� att knappen Place Order skall bli synlig" );
		}
	}

	/**
	 * Denna metod implementerar �verg�ngen: PressBackButton
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void PressBackButton()
	{
		logInfo( "�verg�ng: PressBackButton" );
		throw new RuntimeException( "Ej implementerat" );
	}

	/**
	 * Denna metod implementerar verifieringen
	 * av tillst�ndet: DataBaseCleared
	 */
	public void DataBaseCleared()
	{
		logInfo( "Nod: DataBaseCleared" );
		if ( JDialog_standardVP().performTest() == false )
		{
			throw new RuntimeException( "Verifieringen misslyckades" );
		}
	}

	/**
	 * Denna metod implementerar verifieringen
	 * av tillst�ndet: ClearData
	 */
	public void ClearData()
	{
		logInfo( "Nod: ClearData" );
		if ( ClearDataVP().performTest() == false )
		{
			throw new RuntimeException( "Verifieringen misslyckades" );
		}
	}

	/**
	 * Denna metod implementerar �verg�ngen: DataBaseClearedOK
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void DataBaseClearedOK()
	{
		logInfo( "�verg�ng: DataBaseClearedOK" );
		ok6().click();
	}

	/**
	 * Denna metod implementerar �verg�ngen: AdministrationOK
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void AdministrationOK()
	{
		logInfo( "�verg�ng: AdministrationOK" );
		ok().click();
	}

	/**
	 * Denna metod implementerar �verg�ngen: ClearDataYES
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void ClearDataYES()
	{
		logInfo( "�verg�ng: ClearDataYES" );
		yes().click();
	}

	/**
	 * Denna metod implementerar �verg�ngen: ClearDataNO
	 * En �verg�ng �r v�gen mellan ett tillst�nd till ett annat tillst�nd.
	 */
	public void ClearDataNO()
	{
		logInfo( "�verg�ng: ClearDataNO" );
		no().click();
	}
}
