<template>
    <div id="register">
        <div class="register__box">
            <div class="row">
            <div class="register__box__form">
                <form @submit.prevent="submit">
                <div class="form__group">
                    <input type="text" class="form__input" placeholder="Email Address" id="email" v-model="user.email" required>
                    <label for="email" class="form__label">Email Address</label>
                </div>
                <div class="form__group">
                    <input type="text" class="form__input" placeholder="Full Name" id="name" v-model="user.name" required>
                    <label for="name" class="form__label">Full Name</label>
                </div>
                <div class="form__group">
                    <input type="password" class="form__input" placeholder="Password" id="password" v-model="user.password" required>
                    <label for="password" class="form__label">Password</label>
                </div>
                <div class="form__group">
                    <div class="form__radio-group">
                        <input type="radio" class="form__radio-input" id="buyer" name="role" value="0" v-model="user.role"> <!--same name so either one of them will be selected-->
                        <label for="buyer" class="form__radio-label">
                            <span class="form__radio-button"></span>
                            Buyer
                        </label>
                    </div>
                    <div class="u-margin-bottom-small form__radio-group">
                        <input type="radio" class="form__radio-input" id="seller" name="role" value="1" v-model="user.role">
                        <label for="seller" class="form__radio-label">
                            <span class="form__radio-button"></span>
                            Seller
                        </label>
                    </div>
                </div>
                <div class="form__group">
                    <input type="submit" class="btn btn--green" value="Submit" >
                </div>
                </form>
            </div>

        </div>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                user: {
                    email: "",
                    name: "",
                    password: "",
                    role: "",
                }
            }
        },
        methods: {
            submit: function() {
                alert(this.user.name);
            }
        }
    }
</script>