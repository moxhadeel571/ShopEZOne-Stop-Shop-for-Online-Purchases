package com.example.ecommerce.ecommerce.razorpay;

import com.example.ecommerce.ecommerce.Entity.OrderItem;
import com.example.ecommerce.ecommerce.Entity.Products;
import com.example.ecommerce.ecommerce.Entity.checkOut;
import com.example.ecommerce.ecommerce.Repository.ProductsRepository;
import com.example.ecommerce.ecommerce.Service.CartService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

@Path("/users/payment")
public class PaymentResource {
  ProductsRepository productsRepository;
  private RazorpayClient client;
  private int amount = 500;

  private String apiKey;
  private String secretKey;
     CartService cartService;
  public PaymentResource(String apiKey, String secretKey) {
    this.apiKey = apiKey;
    this.secretKey = secretKey;
    try {
      this.client = new RazorpayClient(this.apiKey, this.secretKey);
    } catch (RazorpayException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }

  @GET
  @Produces(MediaType.TEXT_HTML)
  public Order getPaymentForm() throws RazorpayException {
    RazorpayClient razorpay = new RazorpayClient("[rzp_test_BGPTgqrkVagzn6]", "[l48xX7CnwytQmBn5twVyiavo]");
      checkOut checkOut=new checkOut();
      List<OrderItem> cartItems = cartService.getCartItems();
      int totalItems = cartItems.stream().mapToInt(OrderItem::getQuantity).sum();
      checkOut.setTotalItems(totalItems);
      double totalAmount = cartItems.stream()
              .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
              .sum();
    JSONObject orderRequest = new JSONObject();
Products info=new Products();
    orderRequest.put("amount",totalAmount   );
    orderRequest.put("currency","INR");
    orderRequest.put("receipt", "receipt#1");
    JSONObject notes = new JSONObject();
    notes.put("notes_key_1","Tea, Earl Grey, Hot");
    notes.put("notes_key_1","Tea, Earl Grey, Hot");
    orderRequest.put("notes",notes);

    Order order = razorpay.Orders.create(orderRequest);
    return order;
  }

  @POST
  @Path("/charge")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.TEXT_HTML)
  public String charge(MultivaluedMap<String, String> formParams, @RequestParam("promoCode") String promoCode,
                       @PathVariable("id")String id, Model model)  throws RazorpayException {
      String paymentId = formParams.getFirst("razorpay_payment_id");
      String razorpaySignature = formParams.getFirst("razorpay_signature");
      String orderId = formParams.getFirst("razorpay_order_id");


      JSONObject options = new JSONObject();

      if (StringUtils.isNotBlank(paymentId) && StringUtils.isNotBlank(razorpaySignature)
              && StringUtils.isNotBlank(orderId)) {
          try {
              options.put("razorpay_payment_id", paymentId);
              options.put("razorpay_order_id", orderId);
              options.put("razorpay_signature", razorpaySignature);
              boolean isEqual = Utils.verifyPaymentSignature(options, this.secretKey);


          } catch (JSONException e) {
              throw new RuntimeException(e);
          } catch (RazorpayException e) {
              throw new RuntimeException(e);
          }

      }
      return "redirect:/users/shop";
  }


      // Implement your promo code validation and discount calculation logic here
      private double calculateDiscountAmount(String promoCode) {
          if (promoCode.equals("DHAMAKA50")) {
              return 0.5; // 25% discount
          }
          return 0.0; // No discount
      }

    }

