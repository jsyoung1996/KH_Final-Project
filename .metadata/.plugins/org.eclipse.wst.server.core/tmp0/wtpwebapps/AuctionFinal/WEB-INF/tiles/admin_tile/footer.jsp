<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- ===== #39.  tiles 중 footer 페이지 만들기  ===== --%>
<!-- BEGIN FOOTER -->
<div class="footer">
  <div class="container">
    <div class="row">
      <!-- BEGIN COPYRIGHT -->
     <div class="col-md-4 col-sm-4 padding-top-10">
       2015 © Keenthemes. ALL Rights Reserved. 
     </div>
     <!-- END COPYRIGHT -->
     <!-- BEGIN PAYMENTS -->
     <div class="col-md-4 col-sm-4">
       <ul class="list-unstyled list-inline pull-right">
         <li><img src="<%=request.getContextPath() %>/resources/assets/corporate/img/payments/western-union.jpg" alt="We accept Western Union" title="We accept Western Union"></li>
         <li><img src="<%=request.getContextPath() %>/resources/assets/corporate/img/payments/american-express.jpg" alt="We accept American Express" title="We accept American Express"></li>
         <li><img src="<%=request.getContextPath() %>/resources/assets/corporate/img/payments/MasterCard.jpg" alt="We accept MasterCard" title="We accept MasterCard"></li>
         <li><img src="<%=request.getContextPath() %>/resources/assets/corporate/img/payments/PayPal.jpg" alt="We accept PayPal" title="We accept PayPal"></li>
         <li><img src="<%=request.getContextPath() %>/resources/assets/corporate/img/payments/visa.jpg" alt="We accept Visa" title="We accept Visa"></li>
       </ul>
     </div>
     <!-- END PAYMENTS -->
     <!-- BEGIN POWERED -->
     <div class="col-md-4 col-sm-4 text-right">
       <p class="powered">Powered by: <a href="http://www.keenthemes.com/">KeenThemes.com</a></p>
     </div>
     <!-- END POWERED -->
    </div>
  </div>
</div>
<!-- END FOOTER -->

<!-- BEGIN fast view of a product -->
<div id="product-pop-up" style="display: none; width: 700px;">
   <div class="product-page product-pop-up">
     <div class="row">
       <div class="col-md-6 col-sm-6 col-xs-3">
         <div class="product-main-image">
           <img src="<%=request.getContextPath()%>/resources/assets/pages/img/products/model7.jpg" alt="Cool green dress with red bell" class="img-responsive">
         </div>
         <div class="product-other-images">
           <a href="javascript:;" class="active"><img alt="Berry Lace Dress" src="<%=request.getContextPath() %>/resources/assets/pages/img/products/model3.jpg"></a>
           <a href="javascript:;"><img alt="Berry Lace Dress" src="<%=request.getContextPath() %>/resources/assets/pages/img/products/model4.jpg"></a>
           <a href="javascript:;"><img alt="Berry Lace Dress" src="<%=request.getContextPath() %>/resources/assets/pages/img/products/model5.jpg"></a>
          </div>
        </div>
        <div class="col-md-6 col-sm-6 col-xs-9">
          <h2>Cool green dress with red bell</h2>
          <div class="price-availability-block clearfix">
            <div class="price">
              <strong><span>$</span>47.00</strong>
              <em>$<span>62.00</span></em>
            </div>
            <div class="availability">
              Availability: <strong>In Stock</strong>
            </div>
          </div>
          <div class="description">
            <p>Lorem ipsum dolor ut sit ame dolore  adipiscing elit, sed nonumy nibh sed euismod laoreet dolore magna aliquarm erat volutpat Nostrud duis molestie at dolore.</p>
          </div>
          <div class="product-page-options">
            <div class="pull-left">
              <label class="control-label">Size:</label>
              <select class="form-control input-sm">
                <option>L</option>
                <option>M</option>
                <option>XL</option>
              </select>
            </div>
            <div class="pull-left">
              <label class="control-label">Color:</label>
              <select class="form-control input-sm">
                <option>Red</option>
                <option>Blue</option>
                <option>Black</option>
              </select>
            </div>
          </div>
          <div class="product-page-cart">
            <div class="product-quantity">
                <input id="product-quantity" type="text" value="1" readonly name="product-quantity" class="form-control input-sm">
            </div>
            <button class="btn btn-primary" type="submit">Add to cart</button>
            <a href="shop-item.html" class="btn btn-default">More details</a>
          </div>
        </div>

        <div class="sticker sticker-sale"></div>
      </div>
    </div>
</div>
<!-- END fast view of a product -->