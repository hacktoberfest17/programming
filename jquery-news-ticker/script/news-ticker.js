$(document).ready(function(){
    displayNews();
});

var block_arr = $(".ticker li")
.get()
.map(e => e.innerHTML);
var item_num = 0;
news_style = {
position: "absolute",
top: "-50px",
right: -$(".ticker li p").width(),
left: $(".ticker li p").width(),
fontSize: "30px",
whiteSpace: "nowrap"
};
$(".news1").html(block_arr[item_num]);
$(".news2").html(block_arr[item_num +1])
var news = $(".news1");
news.css(news_style);
var ticker_width = -$(".ticker li p").width()*1.8;

const ticker = () => {
item_num = item_num < block_arr.length - 1 ? item_num + 1 : 0;
$(".news1").html(block_arr[item_num]);
news = $(".news1");
news.css(news_style);
displayNews();
};
const displayNews = () => {
news.animate({ left: ticker_width }, 15000, "linear", ticker);
};
