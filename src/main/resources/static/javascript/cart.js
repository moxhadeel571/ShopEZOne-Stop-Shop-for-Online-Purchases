$(document).ready(function () {
    $(".minus-btn").click(function () {
        var productId = $(this).data("product-id");
        updateQuantity(productId, -1);
    });

    $(".plus-btn").click(function () {
        var productId = $(this).data("product-id");
        updateQuantity(productId, 1);
    });

    function updateQuantity(productId, change) {
        $.ajax({
            type: "POST",
            url: "/users/updateQuantity",
            data: {
                productId: productId,
                change: change
            },
            success: function (data) {
                var quantityInput = $("#quantity-" + productId);
                quantityInput.val(data.quantity);

                var priceElement = $("#price-" + productId);
                priceElement.text(data.price);

                var totalPriceElement = $("#totalPrice");
                totalPriceElement.text(data.totalPrice);
            },
            error: function () {
                alert("An error occurred while updating the quantity.");
            }
        });
    }
});
