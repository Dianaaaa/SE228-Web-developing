<template>
    <div class="navigation">
        <input type="checkbox" class="navigation__checkbox" id="nav-toggle">

        <label for="nav-toggle" class="navigation__button">
        <span class="navigation__icon">
          &nbsp;
        </span>
        </label>

        <div class="navigation__background">&nbsp;</div>

        <nav class="navigation__nav">
            <ul class="navigation__list">
                <li class="navigation__item"><router-link to="/signup"><a href="#" class="navigation__link"><span>01</span>账户</a></router-link></li>
                <li class="navigation__item"><a href="#" class="navigation__link"><span>02</span>订单</a></li>
                <li class="navigation__item"><a href="#" class="navigation__link"><span>03</span>购物车</a></li>
                <li class="navigation__item"><a href="#" class="navigation__link"><span>04</span>社区</a></li>
                <li class="navigation__item"><a href="#" class="navigation__link"><span>05</span>关于复述</a></li>
            </ul>
        </nav>
    </div>
</template>