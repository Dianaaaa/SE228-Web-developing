<template>
    <div class="bookview">
        <div class="row">
            <div class="col-1-of-4">
                <div class="bookcard">
                    <div class="bookcard__image">
                        <router-link to="/detail"><img src="../assets/book-2.jpg" class="card__image-photo"></router-link>
                    </div>
                    <div class="bookcard__text">
                        <ul>
                            <li v-on:click="change_color" class="bookname">书名</li>
                            <li>作者</li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-1-of-4">
                <div class="bookcard">
                    <div class="bookcard__image">
                        <router-link to="/detail"><img src="../assets/book-1.png" class="card__image-photo"></router-link>
                    </div>
                    <div class="bookcard__text">
                        <ul>
                            <li>书名</li>
                            <li>作者</li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-1-of-4">
                <div class="bookcard">
                    <div class="bookcard__image">
                        <router-link to="/detail"><img src="../assets/book-2.jpg" class="card__image-photo"></router-link>
                    </div>
                    <div class="bookcard__text">
                        <ul>
                            <li>书名</li>
                            <li>作者</li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-1-of-4">
                <div class="bookcard">
                    <div class="bookcard__image">
                        <router-link to="/detail"><img src="../assets/book-1.png" class="card__image-photo"></router-link>
                    </div>
                    <div class="bookcard__text">
                        <ul>
                            <li>书名</li>
                            <li>作者</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-1-of-4">
                <div class="bookcard">
                    <div class="bookcard__image">
                        <router-link to="/detail"><img src="../assets/book-3.jpg" class="card__image-photo"></router-link>
                    </div>
                    <div class="bookcard__text">
                        <ul>
                            <li>书名</li>
                            <li>作者</li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-1-of-4">
                <div class="bookcard">
                    <div class="bookcard__image">
                        <router-link to="/detail"><img src="../assets/book-4.jpg" class="card__image-photo"></router-link>
                    </div>
                    <div class="bookcard__text">
                        <ul>
                            <li>书名</li>
                            <li>作者</li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-1-of-4">
                <div class="bookcard">
                    <div class="bookcard__image">
                        <router-link to="/detail"><img src="../assets/book-3.jpg" class="card__image-photo"></router-link>
                    </div>
                    <div class="bookcard__text">
                        <ul>
                            <li>书名</li>
                            <li>作者</li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-1-of-4">
                <div class="bookcard">
                    <div class="bookcard__image">
                        <router-link to="/detail"><img src="../assets/book-4.jpg" class="card__image-photo"></router-link>
                    </div>
                    <div class="bookcard__text">
                        <ul>
                            <li>书名</li>
                            <li>作者</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-1-of-4">
                <div class="bookcard">
                    <div class="bookcard__image">
                        <router-link to="/detail"><img src="../assets/book-2.jpg" class="card__image-photo"></router-link>
                    </div>
                    <div class="bookcard__text">
                        <ul>
                            <li>书名</li>
                            <li>作者</li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-1-of-4">
                <div class="bookcard">
                    <div class="bookcard__image">
                        <router-link to="/detail"><img src="../assets/book-1.png" class="card__image-photo"></router-link>
                    </div>
                    <div class="bookcard__text">
                        <ul>
                            <li>书名</li>
                            <li>作者</li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-1-of-4">
                <div class="bookcard">
                    <div class="bookcard__image">
                        <router-link to="/detail"><img src="../assets/book-2.jpg" class="card__image-photo"></router-link>
                    </div>
                    <div class="bookcard__text">
                        <ul>
                            <li>书名</li>
                            <li>作者</li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-1-of-4">
                <div class="bookcard">
                    <div class="bookcard__image">
                        <router-link to="/detail"><img src="../assets/book-1.png" class="card__image-photo"></router-link>
                    </div>
                    <div class="bookcard__text">
                        <ul>
                            <li>书名</li>
                            <li>作者</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="quotes">
            <span class="disabled"> 《 </span>
            <span class="current">1</span>
            <a href="#?page=2">2</a>
            <a href="#?page=3">3</a>
            <a href="#?page=4">4</a>
            <a href="#?page=5">5</a>
            <a href="#?page=6">6</a>
            <a href="#?page=7">7</a>
            <a href="#?page=8">8</a>
            <a href="#?page=9">9</a>
            <a href="#?page=2"> 》 </a>
        </div>

    </div>
</template>

<script>
    export default {
        data(){
            return {
                count: 1
            }
        },
        methods: {
            change_color() {
                if (this.count % 2 === 0) {
                    this.$refs.bookname.style.color='black';
                } else {
                    this.$refs.bookname.style.color = 'red';
                }
                this.count = this.count + 1;
            }
        }
    }
</script>
