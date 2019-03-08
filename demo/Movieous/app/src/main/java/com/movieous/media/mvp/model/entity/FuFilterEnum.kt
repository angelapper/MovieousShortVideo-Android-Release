package com.movieous.media.mvp.model.entity

import com.faceunity.entity.Effect
import com.movieous.media.R
import java.util.*

/**
 * Created by tujh on 2018/1/30.
 */
enum class FuFilterEnum private constructor(private val bundleName: String, private val resId: Int, private val path: String, private val maxFace: Int, private val effectType: Int, private val description: Int) {
    // none
    EffectNone("none", R.drawable.ic_delete_all, "none", 1, Effect.EFFECT_TYPE_NONE, 0),

    // normal
    Effect_yuguan("yuguan", R.drawable.yuguan, "normal/yuguan.bundle", 4, Effect.EFFECT_TYPE_NORMAL, 0),
    Effect_bling("bling", R.drawable.bling, "normal/bling.bundle", 4, Effect.EFFECT_TYPE_NORMAL, 0),
    Effect_fengya_ztt_fu("fengya_ztt_fu", R.drawable.fengya_ztt_fu, "normal/fengya_ztt_fu.bundle", 4, Effect.EFFECT_TYPE_NORMAL, 0),
    Effect_hudie_lm_fu("hudie_lm_fu", R.drawable.hudie_lm_fu, "normal/hudie_lm_fu.bundle", 4, Effect.EFFECT_TYPE_NORMAL, 0),
    Effect_touhua_ztt_fu("touhua_ztt_fu", R.drawable.touhua_ztt_fu, "normal/touhua_ztt_fu.bundle", 4, Effect.EFFECT_TYPE_NORMAL, 0),
    Effect_juanhuzi_lm_fu("juanhuzi_lm_fu", R.drawable.juanhuzi_lm_fu, "normal/juanhuzi_lm_fu.bundle", 4, Effect.EFFECT_TYPE_NORMAL, 0),
    Effect_mask_hat("mask_hat", R.drawable.mask_hat, "normal/mask_hat.bundle", 4, Effect.EFFECT_TYPE_NORMAL, 0),
    Effect_yazui("yazui", R.drawable.yazui, "normal/yazui.bundle", 4, Effect.EFFECT_TYPE_NORMAL, 0),

    // AR
    Effect_bluebird("bluebird", R.drawable.bluebird, "ar/bluebird.bundle", 4, Effect.EFFECT_TYPE_AR, 0),
    Effect_lanhudie("lanhudie", R.drawable.lanhudie, "ar/lanhudie.bundle", 4, Effect.EFFECT_TYPE_AR, 0),
    Effect_fenhudie("fenhudie", R.drawable.fenhudie, "ar/fenhudie.bundle", 4, Effect.EFFECT_TYPE_AR, 0),
    Effect_tiger_huang("tiger_huang", R.drawable.tiger_huang, "ar/tiger_huang.bundle", 4, Effect.EFFECT_TYPE_AR, 0),
    Effect_tiger_bai("tiger_bai", R.drawable.tiger_bai, "ar/tiger_bai.bundle", 4, Effect.EFFECT_TYPE_AR, 0),
    Effect_afd("afd", R.drawable.afd, "ar/afd.bundle", 4, Effect.EFFECT_TYPE_AR, 0),
    Effect_baozi("baozi", R.drawable.baozi, "ar/baozi.bundle", 4, Effect.EFFECT_TYPE_AR, 0),
    Effect_tiger("tiger", R.drawable.tiger, "ar/tiger.bundle", 4, Effect.EFFECT_TYPE_AR, 0),
    Effect_xiongmao("xiongmao", R.drawable.xiongmao, "ar/xiongmao.bundle", 4, Effect.EFFECT_TYPE_AR, 0),
    Effect_armesh("armesh", R.drawable.armesh, "ar/armesh.bundle", 4, Effect.EFFECT_TYPE_AR, 0),
    Effect_armesh_ex("armesh_ex", R.drawable.armesh_ex, "ar/armesh_ex.bundle", 4, Effect.EFFECT_TYPE_AR, R.string.armesh_ex),

    // face change
    Effect_mask_liudehua("mask_liudehua", R.drawable.mask_liudehua, "change/mask_liudehua.bundle", 4, Effect.EFFECT_TYPE_FACE_CHANGE, 0),
    Effect_mask_linzhiling("mask_linzhiling", R.drawable.mask_linzhiling, "change/mask_linzhiling.bundle", 4, Effect.EFFECT_TYPE_FACE_CHANGE, 0),
    Effect_mask_luhan("mask_luhan", R.drawable.mask_luhan, "change/mask_luhan.bundle", 4, Effect.EFFECT_TYPE_FACE_CHANGE, 0),
    Effect_mask_guocaijie("mask_guocaijie", R.drawable.mask_guocaijie, "change/mask_guocaijie.bundle", 4, Effect.EFFECT_TYPE_FACE_CHANGE, 0),
    Effect_mask_huangxiaoming("mask_huangxiaoming", R.drawable.mask_huangxiaoming, "change/mask_huangxiaoming.bundle", 4, Effect.EFFECT_TYPE_FACE_CHANGE, 0),
    Effect_mask_matianyu("mask_matianyu", R.drawable.mask_matianyu, "change/mask_matianyu.bundle", 4, Effect.EFFECT_TYPE_FACE_CHANGE, 0),
    Effect_mask_tongliya("mask_tongliya", R.drawable.mask_tongliya, "change/mask_tongliya.bundle", 4, Effect.EFFECT_TYPE_FACE_CHANGE, 0),

    // 表情
    Effect_future_warrior("future_warrior", R.drawable.future_warrior, "expression/future_warrior.bundle", 4, Effect.EFFECT_TYPE_EXPRESSION, R.string.future_warrior),
    Effect_jet_mask("jet_mask", R.drawable.jet_mask, "expression/jet_mask.bundle", 4, Effect.EFFECT_TYPE_EXPRESSION, R.string.jet_mask),
    Effect_sdx2("sdx2", R.drawable.sdx2, "expression/sdx2.bundle", 4, Effect.EFFECT_TYPE_EXPRESSION, R.string.sdx2),
    Effect_luhantongkuan_ztt_fu("luhantongkuan_ztt_fu", R.drawable.luhantongkuan_ztt_fu, "expression/luhantongkuan_ztt_fu.bundle", 4, Effect.EFFECT_TYPE_EXPRESSION, R.string.luhantongkuan_ztt_fu),
    Effect_qingqing_ztt_fu("qingqing_ztt_fu", R.drawable.qingqing_ztt_fu, "expression/qingqing_ztt_fu.bundle", 4, Effect.EFFECT_TYPE_EXPRESSION, R.string.qingqing_ztt_fu),
    Effect_xiaobianzi_zh_fu("xiaobianzi_zh_fu", R.drawable.xiaobianzi_zh_fu, "expression/xiaobianzi_zh_fu.bundle", 4, Effect.EFFECT_TYPE_EXPRESSION, R.string.xiaobianzi_zh_fu),
    Effect_xiaoxueshen_ztt_fu("xiaoxueshen_ztt_fu", R.drawable.xiaoxueshen_ztt_fu, "expression/xiaoxueshen_ztt_fu.bundle", 4, Effect.EFFECT_TYPE_EXPRESSION, R.string.xiaoxueshen_ztt_fu),

    // 背景分割
    Effect_chiji_lm_fu("chiji_lm_fu", R.drawable.chiji_lm_fu, "background/chiji_lm_fu.bundle", 1, Effect.EFFECT_TYPE_BACKGROUND, R.string.hez_ztt_fu),
    Effect_jingongmen_zh_fu("jingongmen_zh_fu", R.drawable.jingongmen_zh_fu, "background/jingongmen_zh_fu.bundle", 1, Effect.EFFECT_TYPE_BACKGROUND, R.string.hez_ztt_fu),
    Effect_hez_ztt_fu("hez_ztt_fu", R.drawable.hez_ztt_fu, "background/hez_ztt_fu.bundle", 1, Effect.EFFECT_TYPE_BACKGROUND, R.string.hez_ztt_fu),
    Effect_gufeng_zh_fu("gufeng_zh_fu", R.drawable.gufeng_zh_fu, "background/gufeng_zh_fu.bundle", 1, Effect.EFFECT_TYPE_BACKGROUND, 0),
    Effect_men_ztt_fu("men_ztt_fu", R.drawable.men_ztt_fu, "background/men_ztt_fu.bundle", 1, Effect.EFFECT_TYPE_BACKGROUND, 0),
    Effect_xiandai_ztt_fu("xiandai_ztt_fu", R.drawable.xiandai_ztt_fu, "background/xiandai_ztt_fu.bundle", 1, Effect.EFFECT_TYPE_BACKGROUND, 0),
    Effect_sea_lm_fu("sea_lm_fu", R.drawable.sea_lm_fu, "background/sea_lm_fu.bundle", 1, Effect.EFFECT_TYPE_BACKGROUND, 0),
    Effect_ice_lm_fu("ice_lm_fu", R.drawable.ice_lm_fu, "background/ice_lm_fu.bundle", 1, Effect.EFFECT_TYPE_BACKGROUND, 0),

    // 手势识别
    Effect_ctrl_rain("ctrl_rain", R.drawable.ctrl_rain, "gesture/ctrl_rain.bundle", 4, Effect.EFFECT_TYPE_GESTURE, R.string.ctrl_rain),
    Effect_ctrl_snow("ctrl_snow", R.drawable.ctrl_snow, "gesture/ctrl_snow.bundle", 4, Effect.EFFECT_TYPE_GESTURE, R.string.ctrl_snow),
    Effect_ctrl_flower("ctrl_flower", R.drawable.ctrl_flower, "gesture/ctrl_flower.bundle", 4, Effect.EFFECT_TYPE_GESTURE, R.string.ctrl_flower),
    Effect_fu_lm_koreaheart("fu_lm_koreaheart", R.drawable.fu_lm_koreaheart, "gesture/ssd_thread_korheart.bundle", 4, Effect.EFFECT_TYPE_GESTURE, R.string.fu_lm_koreaheart),
    Effect_fu_ztt_live520("fu_ztt_live520", R.drawable.fu_ztt_live520, "gesture/fu_ztt_live520.bundle", 4, Effect.EFFECT_TYPE_GESTURE, R.string.fu_ztt_live520),
    Effect_ssd_thread_cute("ssd_thread_cute", R.drawable.ssd_thread_cute, "gesture/ssd_thread_cute.bundle", 4, Effect.EFFECT_TYPE_GESTURE, R.string.ssd_thread_cute),
    Effect_ssd_thread_six("ssd_thread_six", R.drawable.ssd_thread_six, "gesture/ssd_thread_six.bundle", 4, Effect.EFFECT_TYPE_GESTURE, R.string.ssd_thread_six),
    Effect_ssd_thread_thumb("ssd_thread_thumb", R.drawable.ssd_thread_thumb, "gesture/ssd_thread_thumb.bundle", 4, Effect.EFFECT_TYPE_GESTURE, R.string.ssd_thread_thumb),

    // 3D 贴纸
    Effect_frog_Animoji("frog_Animoji", R.drawable.frog_animoji, "animoji/frog_Animoji.bundle", 1, Effect.EFFECT_TYPE_ANIMOJI, 0),
    Effect_huangya_Animoji("huangya_Animoji", R.drawable.huangya_animoji, "animoji/huangya_Animoji.bundle", 1, Effect.EFFECT_TYPE_ANIMOJI, 0),
    Effect_hetun_Animoji("hetun_Animoji", R.drawable.hetun_animoji, "animoji/hetun_Animoji.bundle", 1, Effect.EFFECT_TYPE_ANIMOJI, 0),
    //    Effect_buoutuzi_Animoji("buoutuzi_Animoji", R.drawable.buoutuzi_animoji, "animoji/buoutuzi_Animoji.bundle", 1, Effect.EFFECT_TYPE_ANIMOJI, 0),
    Effect_douniuquan_Animoji("douniuquan_Animoji", R.drawable.douniuquan_animoji, "animoji/douniuquan_Animoji.bundle", 1, Effect.EFFECT_TYPE_ANIMOJI, 0),
    Effect_hashiqi_Animoji("hashiqi_Animoji", R.drawable.hashiqi_animoji, "animoji/hashiqi_Animoji.bundle", 1, Effect.EFFECT_TYPE_ANIMOJI, 0),
    Effect_baimao_Animoji("baimao_Animoji", R.drawable.baimao_animoji, "animoji/baimao_Animoji.bundle", 1, Effect.EFFECT_TYPE_ANIMOJI, 0),
    //    Effect_chaiquan_Animoji("chaiquan_Animoji", R.drawable.chaiquan_animoji, "animoji/chaiquan_Animoji.bundle", 1, Effect.EFFECT_TYPE_ANIMOJI, 0),
    Effect_kuloutou_Animoji("kuloutou_Animoji", R.drawable.kuloutou_animoji, "animoji/kuloutou_Animoji.bundle", 1, Effect.EFFECT_TYPE_ANIMOJI, 0),

    Effect_picasso_e1("picasso_e1", R.drawable.picasso_e1, "portrait_drive/picasso_e1.bundle", 1, Effect.EFFECT_TYPE_PORTRAIT_DRIVE, 0),
    Effect_picasso_e2("picasso_e2", R.drawable.picasso_e2, "portrait_drive/picasso_e2.bundle", 1, Effect.EFFECT_TYPE_PORTRAIT_DRIVE, 0),
    Effect_picasso_e3("picasso_e3", R.drawable.picasso_e3, "portrait_drive/picasso_e3.bundle", 1, Effect.EFFECT_TYPE_PORTRAIT_DRIVE, 0),

    // 哈哈镜
    Effect_facewarp2("facewarp2", R.drawable.facewarp2, "facewarp/facewarp2.bundle", 4, Effect.EFFECT_TYPE_FACE_WARP, 0),
    Effect_facewarp3("facewarp3", R.drawable.facewarp3, "facewarp/facewarp3.bundle", 4, Effect.EFFECT_TYPE_FACE_WARP, 0),
    Effect_facewarp4("facewarp4", R.drawable.facewarp4, "facewarp/facewarp4.bundle", 4, Effect.EFFECT_TYPE_FACE_WARP, 0),
    Effect_facewarp5("facewarp5", R.drawable.facewarp5, "facewarp/facewarp5.bundle", 4, Effect.EFFECT_TYPE_FACE_WARP, 0),
    Effect_facewarp6("facewarp6", R.drawable.facewarp6, "facewarp/facewarp6.bundle", 4, Effect.EFFECT_TYPE_FACE_WARP, 0),

    // 音乐滤镜
    Effect_douyin_01("douyin_01", R.drawable.douyin_old, "musicfilter/douyin_01.bundle", 4, Effect.EFFECT_TYPE_MUSIC_FILTER, 0),
    Effect_douyin_02("douyin_02", R.drawable.douyin, "musicfilter/douyin_02.bundle", 4, Effect.EFFECT_TYPE_MUSIC_FILTER, 0),
    Effect_music_filter_1("douyin_03", R.drawable.douyin, "musicfilter/music_filter_1.bundle", 4, Effect.EFFECT_TYPE_MUSIC_FILTER, 0),
    Effect_music_filter_2("douyin_04", R.drawable.douyin, "musicfilter/music_filter_2.bundle", 4, Effect.EFFECT_TYPE_MUSIC_FILTER, 0),
    Effect_music_filter_3("douyin_05", R.drawable.douyin, "musicfilter/music_filter_3.bundle", 4, Effect.EFFECT_TYPE_MUSIC_FILTER, 0),
    Effect_music_filter_4("douyin_06", R.drawable.douyin, "musicfilter/music_filter_4.bundle", 4, Effect.EFFECT_TYPE_MUSIC_FILTER, 0),
    Effect_music_filter_5("douyin_07", R.drawable.douyin, "musicfilter/music_filter_5.bundle", 4, Effect.EFFECT_TYPE_MUSIC_FILTER, 0),
    Effect_music_filter_6("douyin_08", R.drawable.douyin, "musicfilter/music_filter_6.bundle", 4, Effect.EFFECT_TYPE_MUSIC_FILTER, 0),
    Effect_music_filter_7("douyin_09", R.drawable.douyin, "musicfilter/music_filter_7.bundle", 4, Effect.EFFECT_TYPE_MUSIC_FILTER, 0),

    // 渐变头发
    Hair_Gradient_04("Gradient_Hair_04", R.drawable.icon_gradualchangehair_04, "hair/hair_gradient.bundle", 4, Effect.EFFECT_TYPE_HAIR_GRADIENT, 0),
    Hair_Gradient_05("Gradient_Hair_05", R.drawable.icon_gradualchangehair_05, "hair/hair_gradient.bundle", 4, Effect.EFFECT_TYPE_HAIR_GRADIENT, 0),
    Hair_Gradient_06("Gradient_Hair_06", R.drawable.icon_gradualchangehair_06, "hair/hair_gradient.bundle", 4, Effect.EFFECT_TYPE_HAIR_GRADIENT, 0),

    //普通头发
    Hair_01("Hair_01", R.drawable.icon_beautymakeup_hairsalon_01, "hair/hair_color.bundle", 4, Effect.EFFECT_TYPE_HAIR, 0),
    Hair_02("Hair_02", R.drawable.icon_beautymakeup_hairsalon_02, "hair/hair_color.bundle", 4, Effect.EFFECT_TYPE_HAIR, 0),
    Hair_03("Hair_03", R.drawable.icon_beautymakeup_hairsalon_03, "hair/hair_color.bundle", 4, Effect.EFFECT_TYPE_HAIR, 0),
    Hair_04("Hair_04", R.drawable.icon_beautymakeup_hairsalon_04, "hair/hair_color.bundle", 4, Effect.EFFECT_TYPE_HAIR, 0),
    Hair_05("Hair_05", R.drawable.icon_beautymakeup_hairsalon_05, "hair/hair_color.bundle", 4, Effect.EFFECT_TYPE_HAIR, 0),
    Hair_06("Hair_06", R.drawable.icon_beautymakeup_hairsalon_06, "hair/hair_color.bundle", 4, Effect.EFFECT_TYPE_HAIR, 0),
    Hair_07("Hair_07", R.drawable.icon_beautymakeup_hairsalon_07, "hair/hair_color.bundle", 4, Effect.EFFECT_TYPE_HAIR, 0),
    Hair_08("Hair_08", R.drawable.icon_beautymakeup_hairsalon_08, "hair/hair_color.bundle", 4, Effect.EFFECT_TYPE_HAIR, 0),

    Poster_face("poster_face", R.drawable.ic_delete_all, "change_face.bundle", 4, Effect.EFFECT_TYPE_POSTER_FACE, 0);

    fun bundleName(): String {
        return bundleName
    }

    fun resId(): Int {
        return resId
    }

    fun path(): String {
        return path
    }

    fun maxFace(): Int {
        return maxFace
    }

    fun effectType(): Int {
        return effectType
    }

    fun description(): Int {
        return description
    }

    fun effect(): Effect {
        return Effect(bundleName, resId, path, maxFace, effectType, description)
    }

    companion object {

        fun getEffectsByEffectType(effectType: Int): ArrayList<Effect> {
            val effects = ArrayList<Effect>()
            for (e in FuFilterEnum.values()) {
                if (e.effectType == effectType) {
                    effects.add(e.effect())
                }
            }
            return effects
        }
    }
}