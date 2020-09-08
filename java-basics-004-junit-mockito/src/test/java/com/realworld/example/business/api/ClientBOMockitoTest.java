package com.realworld.example.business.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.realworld.example.business.impl.ClientBOImpl;
import com.realworld.example.data.api.ClientDO;
import com.realworld.example.data.api.ProductDO;
import com.realworld.example.data.impl.ProductDODummyImpl;
import com.realworld.example.model.api.Amount;
import com.realworld.example.model.api.Client;
import com.realworld.example.model.api.ClientType;
import com.realworld.example.model.api.CollateralType;
import com.realworld.example.model.api.Currency;
import com.realworld.example.model.api.Product;
import com.realworld.example.model.api.ProductType;
import com.realworld.example.model.impl.AmountImpl;
import com.realworld.example.model.impl.ClientImpl;
import com.realworld.example.model.impl.CollateralImpl;
import com.realworld.example.model.impl.ProductImpl;

@RunWith(MockitoJUnitRunner.class)
public class ClientBOMockitoTest {

	@Mock
	private ProductDO productDO;

	@Mock
	private ClientDO clientDO;

	@InjectMocks
	private ClientBO clientBO = new ClientBOImpl();

	@Captor
	ArgumentCaptor<Client> clientArgumentCaptured;

	private static final int DUMMY_CLIENT_ID = 1;

	@Test
	public void testClientProductSum() {
		List<Product> products = Arrays.asList(createProductWithAmount("5.0"), createProductWithAmount("6.0"));
		stub(productDO.getAllProducts(anyInt())).toReturn(products);
		assertAmountEquals(new AmountImpl(new BigDecimal("11.0"), Currency.EURO), clientBO.getClientProductsSum(DUMMY_CLIENT_ID));
	}

	private void assertAmountEquals(Amount expectedAmount, Amount actualAmount) {
		assertEquals(expectedAmount.getCurrency(), actualAmount.getCurrency());
		assertEquals(expectedAmount.getValue(), actualAmount.getValue());
	}

	private Product createProductWithAmount(String amount) {
		return new ProductImpl(100, "Product 15", ProductType.BANK_GUARANTEE, new AmountImpl(new BigDecimal(amount), Currency.EURO));
	}

	@Test
	public void saveChangedProducts_ProductInScreenAndNotInDatabase_ProductIsInserted() {
		List<Product> screenProducts = Arrays.asList(createProduct());
		List<Product> emptyDatabaseProducts = new ArrayList<Product>();
		stub(productDO.getAllProducts(anyInt())).toReturn(emptyDatabaseProducts);
		clientBO.saveChangedProducts(1, screenProducts);
		verify(productDO).insertProduct(1, screenProducts.get(0));
	}

	private Product createProduct() {
		return new ProductImpl(100, "Product 15", ProductType.BANK_GUARANTEE, new AmountImpl(new BigDecimal("5.0"), Currency.EURO));
	}

	@Test
	public void saveChangedProducts_ProductInScreenAndDatabase_IsUpdated() {
		Product screenProduct = createProductWithAmount("5.0");
		List<Product> databaseProducts = Arrays.asList(createProductWithAmount("6.0"));
		List<Product> screenProducts = Arrays.asList(screenProduct);
		stub(productDO.getAllProducts(anyInt())).toReturn(databaseProducts);
		clientBO.saveChangedProducts(1, screenProducts);
		verify(productDO).updateProduct(1, screenProduct);
	}

	@Test
	public void saveChangedProducts_ProductInDatabaseButNotInScreen_Deleted() {
		Product productFromDatabase = createProduct();
		List<Product> databaseProducts = Arrays.asList(productFromDatabase);
		List<Product> emptyScreenProducts = new ArrayList<Product>();
		stub(productDO.getAllProducts(anyInt())).toReturn(databaseProducts);
		clientBO.saveChangedProducts(1, emptyScreenProducts);
		verify(productDO).deleteProduct(1, productFromDatabase);
	}

	@Test
	public void calculateAndSaveClientProductSum1() {
		ClientImpl client = createClientWithProducts(createProductWithAmount("6.0"), createProductWithAmount("6.0"));
		clientBO.calculateAndSaveClientProductSum(client);
		verify(clientDO).saveClient(clientArgumentCaptured.capture());
		assertEquals(new BigDecimal("12.0"), clientArgumentCaptured.getValue().getProductAmount());
	}

	private ClientImpl createClientWithProducts(Product... products) {
		ClientImpl client = new ClientImpl(0, null, null, null, Arrays.asList(products));
		return client;
	}
	
	@Test
	public void testProductDOImpl(){
		ProductDODummyImpl productDODummyImpl = new ProductDODummyImpl();
		Product product = new ProductImpl(1, "Name", ProductType.BANK_GUARANTEE, new AmountImpl(new BigDecimal(2), Currency.EURO));
		ProductDODummyImpl mockProductDODummyImpl = Mockito.mock(ProductDODummyImpl.class);
		Mockito.when(mockProductDODummyImpl.getAllProducts(1)).thenReturn(Arrays.asList(product));
		Assert.assertNull(productDODummyImpl.insertProduct(1, product));
		Assert.assertNull(productDODummyImpl.deleteProduct(1, product));
		Assert.assertNull(productDODummyImpl.updateProduct(1, product));
		productDODummyImpl.getAllProducts(1);
	}
	
	@Test
	public void testSetters(){
		AmountImpl amtImpl = new AmountImpl(new BigDecimal(1), Currency.EURO);
		amtImpl.setCurrency(Currency.EURO);
		amtImpl.setValue(new BigDecimal(2));
		ProductImpl productImpl = new ProductImpl(1, "Name", ProductType.BANK_GUARANTEE, amtImpl);
		productImpl.setAmount(amtImpl);
		productImpl.setId(2);
		productImpl.setName("Name");
		productImpl.setType(ProductType.KREDIT);
		productImpl.getAmount();
		productImpl.getId();
		productImpl.getName();
		productImpl.getType();
		CollateralImpl collateral = new CollateralImpl(1, "Name", CollateralType.BONDS);
		collateral.setId(2);
		collateral.setName("Name");
		collateral.setType(CollateralType.MUTUAL_FUNDS);
		collateral.getId();
		collateral.getName();
		collateral.getType();
		ClientImpl clientImpl = new ClientImpl(1, "Name", ClientType.BUSINESS, null, null);
		clientImpl.setId(2);
		clientImpl.setName("Name");
		clientImpl.setProductAmount(new BigDecimal(2));
		clientImpl.setType(ClientType.PRIVATE);
		clientImpl.setProducts(null);
		clientImpl.getId();
		clientImpl.getName();
		clientImpl.getProductAmount();
		clientImpl.getProducts();
		clientImpl.getType();
		clientImpl.setCollaterals(null);
		clientImpl.getCollaterals();
		CollateralType.BONDS.toString();
		ProductType.BANK_GUARANTEE.toString();
		Currency.EURO.toString();
		ClientType.BUSINESS.toString();
	}

}