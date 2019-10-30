package com.anthony.tg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val messageList = ArrayList<MessageDto>()

    private  var  firstVisibleChildView :View? = null

    private var endPosition = 0


    private var  itemHeight = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        initView()

    }


    private fun initData() {

        val messageListA = ArrayList<String>()
        val messageListB = ArrayList<String>()
        val messageListC = ArrayList<String>()

        messageListA.add("對別人越斤斤計較的人，別人越會用放大鏡來審視你。\n" +
                "\n" +
                "對別人越厚道的人，別人也將更有包容的心來看待你。\n" +
                "\n" +
                "吃虧就是佔便宜，或許就是用此角度來看待的。\n" +
                "\n" +
                "做人不願意吃虧，凡事愛佔人便宜，時間久了，雖然贏得了小利，卻失去人心。\n" +
                "\n" +
                "做人雖吃點虧，凡事讓人佔點便宜，時間久了，雖然失了小利，卻贏得人心的信任。\n" +
                "\n" +
                "厚道的人，朋友多，也走的久。\n" +
                "\n" +
                "真正精明的人不是貪圖眼前的小利，而是經營人心的信任。\n" +
                "\n" +
                "聰明的極致，是智慧；精明的極致，是厚道。")

        messageListB.add("條條大路通羅馬，我們沒走過的路，未必不能到達目的地。\n" +
                "\n" +
                "每天走一樣的路，永遠都不會有新的發現，孩子的思維尚未受到太多的框架所設限，那天馬行空的想像力是成年人所無法比擬。\n" +
                "\n" +
                "不要用我們有限的知識，去限制了孩子的思維發展。\n" +
                "\n" +
                "陪同孩子尋找答案，永遠比否定或直接給予答案要來的好，即使最後的結果是失敗的，但至少教會了孩子懂得做而言不如起而行，未做就先輕言放棄，等同教了孩子遇到不會的事或困難就先放棄。\n" +
                "\n" +
                "前陣子有一個新聞，一位孩子突發奇問父親，我們可以自己打造一輛藍寶堅尼嗎？父親不是否決，而是和男孩一起動手利用3D列印的方式打造車子零件並拼湊起來，花費了２０個月的時間終於完成。\n" +
                "在製作的過程中，孩子懂得數學、物理的重要性，懂得知識的力量無限，對學習產生了興趣。\n" +
                "\n" +
                "　\n" +
                "\n" +
                "父親的認同或否決，決定了孩子的的心性與未來，不要輕易否定，才不會抹殺孩子的未來。")
        messageListB.add("隨著時代的進步，人們對傳統節慶漸漸的流於形式，甚至不知其由來與含意，年節的氣氛也逐年漸減。\n" +
                "\n" +
                "每一個節慶原本都有其由來與含意，若不知節慶的由來及含意，只知放假一天，就猶如囫圇吞棗、牛飲美酒而不知其味一樣的可惜。\n" +
                "\n" +
                "這些中秋節故事，不知大家知道幾個呢？\n" +
                "\n" +
                "過節如品酒，懂得愈多，感觸愈深，還可以增長見識，並和身邊的朋友分享。\n" +
                "最後 笑遊人間在此祝福大家 月圓人圓 中秋佳節快樂。")
        messageListB.add("隨著時代的進步，人們對傳統節慶漸漸的流於形式，甚至不知其由來與含意，年節的氣氛也逐年漸減。\n" +
                "\n" +
                "每一個節慶原本都有其由來與含意，若不知節慶的由來及含意，只知放假一天，就猶如囫圇吞棗、牛飲美酒而不知其味一樣的可惜。\n" +
                "\n" +
                "這些中秋節故事，不知大家知道幾個呢？\n" +
                "\n" +
                "過節如品酒，懂得愈多，感觸愈深，還可以增長見識，並和身邊的朋友分享。\n" +
                "最後 笑遊人間在此祝福大家 月圓人圓 中秋佳節快樂。")
        messageListB.add("隨著時代的進步，人們對傳統節慶漸漸的流於形式，甚至不知其由來與含意，年節的氣氛也逐年漸減。\n" +
                "\n" +
                "每一個節慶原本都有其由來與含意，若不知節慶的由來及含意，只知放假一天，就猶如囫圇吞棗、牛飲美酒而不知其味一樣的可惜。\n" +
                "\n" +
                "這些中秋節故事，不知大家知道幾個呢？\n" +
                "\n" +
                "過節如品酒，懂得愈多，感觸愈深，還可以增長見識，並和身邊的朋友分享。\n" +
                "最後 笑遊人間在此祝福大家 月圓人圓 中秋佳節快樂。")

        messageListC.add("人年輕時總覺得給家人最好的東西是榮華富貴、錦衣玉食，所以努力工作賺錢養家，希望能給家人最好的生活。\n" +
                "\n" +
                "但當人老了，才會發現和家人相處過程中的酸甜苦辣，那過程、那回憶，才是最寶貴的。\n" +
                "\n" +
                "所以有人說，孩子的成長只有一次，你為了賺錢沒時間陪他成長，那你老了、孩子大了，他一樣也會為了賺錢，而沒時間陪你。\n" +
                "\n" +
                "物質上的滿足可以帶給人快樂，但只有心靈上的滿足，才能帶來幸福。\n" +
                "\n" +
                "就像一封信，一個「您」字，在物質上並沒有什麼價值，但在心靈上卻充滿了幸福，那是一種無價的寶物。\t　\n" +
                "　")
        messageListC.add("說話講求的是一種藝術，聽話講求的是聽取重點。\n" +
                "\n" +
                "會說話，才不會引起誤會；懂聽話，才不會發生誤解。\n" +
                "\n" +
                "對事一句話，可以決定一件事的好壞。\n" +
                "\n" +
                "對人一句話，可以決定未來的好壞。\n" +
                "\n" +
                "做人要謹慎說話，尤其是批評別人的話更要謹言，才不會禍從口出。")
        messageListC.add("說話講求的是一種藝術，聽話講求的是聽取重點。\n" +
                "\n" +
                "會說話，才不會引起誤會；懂聽話，才不會發生誤解。\n" +
                "\n" +
                "對事一句話，可以決定一件事的好壞。\n" +
                "\n" +
                "對人一句話，可以決定未來的好壞。\n" +
                "\n" +
                "做人要謹慎說話，尤其是批評別人的話更要謹言，才不會禍從口出。")


        messageList.add(MessageDto("0", messageListA))
        messageList.add(MessageDto("1", messageListB))
        messageList.add(MessageDto("2", messageListC))

    }


    private fun initView() {

        val linearLayoutManager = LinearLayoutManager(this)
        val messageAdapter = MessageAdapter(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = messageAdapter

        messageAdapter.setData(messageList)

        recyclerView.addOnScrollListener(object:RecyclerView.OnScrollListener(){

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)


                var distance =  getDistance(linearLayoutManager)
                val constraintLayout = firstVisibleChildView?.findViewById<ConstraintLayout>(R.id.constraintLayout)
                val icon = firstVisibleChildView?.findViewById<ImageView>(R.id.imageView)
               if(itemHeight >= distance + (icon?.bottom!! - icon.top)){
                   constraintLayout?.setPadding(0,distance,0,0)
               }

            }

        })



    }

    private fun getDistance(linearLayoutManager: LinearLayoutManager) : Int{

        val position =linearLayoutManager.findFirstVisibleItemPosition()
         firstVisibleChildView = linearLayoutManager.findViewByPosition(position)!!
         itemHeight = firstVisibleChildView?.height!!

        return  itemHeight - firstVisibleChildView?.bottom!!

    }

}
