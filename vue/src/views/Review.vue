<template>
  <div class="review-container">
      <div class=".review-head">
          <h1> BookifyMD Reviews</h1>
          <h3>At BookifyMD we value our customers because they provide our healthcare team invaluable feedback.</h3>
      </div>
    <div class="review-body elevated-box-review display-container">
      <div class = "left-column">
        <div class="review-btns review-col-l left-column"> 
          <img src="../assets/review-l.png" alt="Doctor Photo 1">

          <label for="sort-review-doctor"></label>
          <input type="text" placeholder="Search By Doctor"/>
          <input type="submit">

          <label for="view-all-for-provider"></label><br><br>
          <input type="text" placeholder="Search By Provider"/>
          <input type="submit">
          </div>
        </div>

     <div class="middle-column">
        <review-display/>  
     </div>    
     <div class="right-column"> 
       <img src="../assets/review_1.png" alt="Doctor Photo 2">
         <review-submission-form v-if="this.$store.state.authenticated"/>
     </div>   
    </div>

  </div>
</template>


<script>
import ReviewDisplay from '../components/ReviewDisplay.vue'
import ReviewSubmissionForm from '../components/ReviewSubmissionForm.vue'

export default {
   data(){
        return{
            doctor:{
                name: "Kyle M" 
            },
        }
    },
  components: { 
    ReviewSubmissionForm,
    ReviewDisplay },
  computed:{
    isReview(){
          let showReview= false;
          if(this.$route.params != null){
            showReview = true;
          }
          return showReview
        }
  }
}
</script>


<style>
  .review-container{
    margin-top: 185px;
    align-items: center;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    min-height: calc(100vh - 148px);
  }
  h1{
    text-align: center;
  }
  h3{
    padding-top: 1%;
  }
.right-column{
   position: sticky;
  top: 10rem;
}
.left-column{
  position: sticky;
  top: 10rem;
}

.elevated-box-review {
        box-shadow:
        0 2.8px 2.2px rgba(0, 0, 0, 0.034),
        0 6.7px 5.3px rgba(0, 0, 0, 0.048),
        0 12.5px 10px rgba(0, 0, 0, 0.06),
        0 22.3px 17.9px rgba(0, 0, 0, 0.072),
        0 41.8px 33.4px rgba(0, 0, 0, 0.086),
        0 100px 80px rgba(0, 0, 0, 0.12);
        margin-bottom: 10%;
        padding: 22px;
        background: white;
        border-radius: 5px;
      }

</style>