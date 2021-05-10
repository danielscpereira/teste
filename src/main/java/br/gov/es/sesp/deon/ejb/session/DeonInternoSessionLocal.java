package br.gov.es.sesp.deon.ejb.session;

import br.gov.es.sesp.inquerito.jpa.entity.SinqTipoProced;
import br.gov.es.sesp.inquerito.jpa.entity.SinqPecaAnexo;
import br.gov.es.sesp.inquerito.jpa.entity.SinqPecaGeradaInq;
import br.gov.es.sesp.inquerito.jpa.entity.SinqTemplate;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import br.gov.es.sesp.deon.ejb.exceptions.BusinessException;
import br.gov.es.sesp.deon.jpa.entity.*;
import br.gov.es.sesp.deon.jpa.entity.fake.AcessorioEntity;
import br.gov.es.sesp.deon.jpa.entity.fake.ArmaEntity;
import br.gov.es.sesp.deon.jpa.entity.fake.BopAvariaVeiculoFake;
import br.gov.es.sesp.deon.jpa.entity.fake.BopEnvolvidoSimples;
import br.gov.es.sesp.deon.jpa.entity.fake.BopUnidadePolicialFake;
import br.gov.es.sesp.deon.jpa.entity.fake.ConsultaDocumentoEnvoEspecialFake;
import br.gov.es.sesp.deon.jpa.entity.fake.ConsultaImeiTransiente;
import br.gov.es.sesp.deon.jpa.entity.fake.ConsultaOcorrenciaEnvolvidoTransient;
import br.gov.es.sesp.deon.jpa.entity.fake.ConsultaOcorrenciaObjTransient;
import br.gov.es.sesp.deon.jpa.entity.fake.ConsultaOcorrenciaTransient;
import br.gov.es.sesp.deon.jpa.entity.fake.DetidoConduzidoEntity;
import br.gov.es.sesp.deon.jpa.entity.fake.DinheiroEntity;
import br.gov.es.sesp.deon.jpa.entity.fake.DrogaEntity;
import br.gov.es.sesp.deon.jpa.entity.fake.EnvolvidoTransient;
import br.gov.es.sesp.deon.jpa.entity.fake.EvolucaoOcorrenciaEnvolvido;
import br.gov.es.sesp.deon.jpa.entity.fake.MunicaoEntity;
import br.gov.es.sesp.deon.jpa.entity.fake.OcorrenciaTransiente;
import br.gov.es.sesp.deon.jpa.entity.fake.UnidadeEntity;
import br.gov.es.sesp.deon.jpa.entity.fake.VeiculoEntity;
import br.gov.es.sesp.deon.jpa.entity.fake.ViaturaEntity;
import br.gov.es.sesp.deon.jpa.entity.view.ViewConsultaUnificadaDet;
import br.gov.es.sesp.deon.jpa.entity.view.VwAgencia;
import br.gov.es.sesp.deon.jpa.entity.view.VwDeonAcabamentoArma;
import br.gov.es.sesp.deon.jpa.entity.view.VwDeonFuncionamentoArma;
import br.gov.es.sesp.deonex.jpa.entity.DeonIncidenteProv;
import br.gov.es.sesp.deonex.jpa.entity.DeonOcorrenciaAnexoProv;
import br.gov.es.sesp.deonex.jpa.entity.view.VwBopCores;
import br.gov.es.sesp.deonex.jpa.entity.view.VwDeonMarcaObjeto;
import br.gov.es.sesp.deonex.jpa.entity.view.VwDeonTipoArma;
import br.gov.es.sesp.deonex.jpa.entity.view.VwDeonTipoObjeto;
import br.gov.es.sesp.inquerito.jpa.entity.SinqPecaCadernoProced;
import br.gov.es.sesp.inquerito.jpa.entity.SinqPecaGeradaDTO;
import br.gov.es.sesp.inquerito.jpa.entity.SinqPecaTemplate;

@Local
public interface DeonInternoSessionLocal {

    public List<BopUnidadesFederacao> getAllUf() throws BusinessException;

    public BopUnidadesFederacao getUf(String cdUf) throws BusinessException;

    public BopOcorrencia mergeOcorrencia(BopOcorrencia ocorrencia)
            throws BusinessException;

    public BopOcorrencia gerarDeclaracaoPerdaExtravioDocumento(
            BopOcorrencia bopOcorrencia, Comunicante comunicante,
            BopUnidadePolicial bopUnidadePolicialLogada, BopUsuarios bopUsuario)
            throws BusinessException, Exception;

    public BopOcorrencia gerarOcorrencia(BopOcorrencia bopOcorrencia,
            Comunicante comunicante,
            BopUnidadePolicial bopUnidadePolicialLogada,
            boolean flagOcorrenciaTransito) throws BusinessException, Exception;

    public void mergeOcorrenciaDeon(BopOcorrenciaDeon ocorrenciaDeon)
            throws BusinessException;

    public boolean existeChamadoLegado(String nrChamado)
            throws BusinessException;

    public List<BopTipoEnvolvimento> getAllTipoEnvolvimento()
            throws BusinessException;

    public List<BopTipoEnvolvimento> getTipoEnvolvimentoTransito()
            throws BusinessException;

    public List<BopEstadoCivil> getAllEstadoCivil() throws BusinessException;

    public List<BopNacionalidade> getAllNacionalidade()
            throws BusinessException;

    public List<BopNaturalidade> getAllNaturalidade() throws BusinessException;

    public List<BopOcorrencia> getOcorrencia(OcorrenciaTransiente ocorrTrans,
            int indexPaginacao, int rows) throws BusinessException;

    public int getOcorrenciaCount(OcorrenciaTransiente ocorrTrans)
            throws BusinessException;

    public List<BopIncidente> getAllBopIncidente() throws BusinessException;

    public BopIncidente getBopIncidenteByTpIncidente(String tpIncidente)
            throws BusinessException;

    public List<BopIncidente> getBopIncidentes(String tpIncidente,
            String dsIncidente) throws BusinessException;

    public List<BopIncidente> getListaGruposBopIncidente()
            throws BusinessException;

    public List<BopOcorrenciaAgencia> getMapaOcorrencias(String usuario)
            throws BusinessException;

    public List<BopUnidadePolicialFake> getBopUnidadePolicialFakeByAgencia(
            long cdAgencia) throws BusinessException;

    public List<BopEscolaridade> getAllEscolaridade() throws BusinessException;

    public BopEscolaridade getEscolaridade(int cdEscolaridade)
            throws BusinessException;

    public BopEstadoCivil getEstadoCivil(int cdEstadoCivil)
            throws BusinessException;

    public BopNacionalidade getNacionalidade(int cdNacion)
            throws BusinessException;

    public BopNacionalidade getBopNacionalidade(int cdNacion)
            throws BusinessException;

    public BopNaturalidade getNaturalidade(int cdNatur)
            throws BusinessException;

    public BopPais getPais(String cdNacio) throws BusinessException;

    public List<BopTipoEndereco> getAllTipoEndereco() throws BusinessException;

    public BopNaturalidade getNaturalidadeByNmMunicipio(String nmMunicipio)
            throws BusinessException;

    public BopMunicipio getMunicipioByNm(String nmMunicipio)
            throws BusinessException;

    public BopMunicipio getMunicipioByNm(String nmMunicipio, String cdUf)
            throws BusinessException;

    public List<BopMunicipio> getMunicipio(
            BopUnidadesFederacao bopUnidadesFederacao, boolean comNaoInformado)
            throws BusinessException;

    public List<BopBairro> getBairro(BopMunicipio bopMunicipio,
            boolean comNaoInformado) throws BusinessException;

    public BopEnvolvidosOcorrencia mergeEnvolvidosOcorrencia(
            BopEnvolvidosOcorrencia bopEnvolvidosOcorrencia)
            throws BusinessException;

    public BopEnvolvidosOcorrencia refresh(
            BopEnvolvidosOcorrencia bopEnvolvidosOcorrencia)
            throws BusinessException;

    public BopOcorrencia refresh(BopOcorrencia bopOcorrencia)
            throws BusinessException;

    public BopEnvOcorrFotoDeon mergeBopEnvOcorrFotoDeon(
            BopEnvOcorrFotoDeon bopEnvOcorrFotoDeon) throws BusinessException;

    public List<BopSituacaoEnvolvido> getAllSituacaoEnvolvido()
            throws BusinessException;

    public List<BopReligiao> getAllReligiao() throws BusinessException;

    public List<BopProfissaoOcupacao> getAllProfissaoOcupacao()
            throws BusinessException;

    public List<BopCutis> getAllCutis() throws BusinessException;

    public List<BopAgencia> getAllAgencia() throws BusinessException;

    public List<BopPericulosidade> getAllPericulosidade()
            throws BusinessException;

    public BopTipoEnvolvimento getTipoEnvolvimento(int cdTipoEnv)
            throws BusinessException;

    public List<BopProfissaoOcupacao> getAllProfissoes()
            throws BusinessException;

    public List<BopModeloMatApreendido> getModelo(
            VwDeonMarcaObjeto vwDeonMarcaObjeto) throws BusinessException;

    public VwDeonTipoObjeto getTipoObjeto(int idTipoObjeto)
            throws BusinessException;

    public List<VwDeonMarcaObjeto> getMarca(VwDeonTipoObjeto vwDeonTipoObjeto)
            throws BusinessException;

    public List<BopEnvolvidosOcorrencia> getEnvolvido(
            BopOcorrenciaObjeto bopOcorrencia) throws BusinessException;

    public List<VwDeonMarcaObjeto> getMarcaLazy(
            VwDeonTipoObjeto vwDeonTipoObjeto, String dsMarca,
            int indiceInicial, int nrLinhas) throws BusinessException;

    public int getMarcaCount(VwDeonTipoObjeto vwDeonTipoObjeto, String dsMarca)
            throws BusinessException;

    public List<BopTipoDocumento> getAllTipoDocumento()
            throws BusinessException;

    public List<BopTipoDocumento> getTipoDocumentoExceptCommon()
            throws BusinessException;

    public List<BopTipoDocumento> getTipoDocumentoGroupEspecialPasso1()
            throws BusinessException;

    public List<BopTipoDocumento> getTipoDocumentoGroupEspecialPasso3()
            throws BusinessException;

    public List<BopBandeiraCartao> getAllBandeiraCartao()
            throws BusinessException;

    public List<BopOperadora> getAllOperadora() throws BusinessException;

    public List<VwDeonTipoObjeto> getAllVwDeonTipoObjeto()
            throws BusinessException;

    public List<VwDeonTipoObjeto> getTransitoVwDeonTipoObjeto()
            throws BusinessException;

    public List<BopUnidadePolicial> getListOfUnidadePolicialBu(
            int unidadePolicialUsuario, int agenciaPolicial)
            throws BusinessException;

    public List<BopUnidadePolicial> getUnidadePolicial(BopAgencia bopAgencia,
            boolean adminstradorTransito) throws BusinessException;

    public List<BopUnidadePolicial> getUnidadePolicial()
            throws BusinessException;

    public BopAgencia getAgencia(long cdAgencia) throws BusinessException;

    public List<BopCargo> getListaBopCargoDeon() throws BusinessException;

    public List<BopTipoLocal> getAllTipoLocal() throws BusinessException;

    public List<BopTipoLocalWeb> getAllTipoLocalWeb() throws BusinessException;

    public List<BopUnidadeMedida> getAllUnidadeMedida()
            throws BusinessException;

    public BopOcorrenciaObjeto mergeObjetoRelacionado(
            BopOcorrenciaObjeto bopOcorrenciaObjeto) throws BusinessException;

    public BopOcorrencia getOcorrenciaById(int nrBop, String tipoBop)
            throws BusinessException;

    public List<BopUnidadePolicial> getUnidadePolicialById(long cdAgencia)
            throws BusinessException;

    public List<BopFuncionario> getAllFuncionario() throws BusinessException;

    public List<BopFuncionario> findAllFuncionarioByAgencia(Integer cdAgencia)
            throws BusinessException;

    public List<BopFuncionario> getFuncionarioByIdUnidPolicial(
            long cdUnidPolicia) throws BusinessException;

    public List<BopGrauRelac> getAllGrauRelacionamento()
            throws BusinessException;

    public List<VwDeonTipoArma> getAllTipoArma() throws BusinessException;

    public List<BopCalibreArma> getCalibreArma(
            VwDeonMarcaObjeto vwDeonMarcaObjeto) throws BusinessException;

    public List<BopPartesCorpoDeon> getPartesCorpo(int idGrupoCorpo)
            throws BusinessException;

    public List<BopPartesCorpoDeon> getPartesCorpo() throws BusinessException;

    public List<BopTipoPeculiaridade> getAllTipoPeculiaridade()
            throws BusinessException;

    public byte[] getEnvOcorrFotoFindIdEnvolvido(long idFoto)
            throws BusinessException;

    public byte[] getEnvOcorrFotoThumbnailFindIdEnvolvido(long idFotoThumbnail)
            throws BusinessException;

    public byte[] getPecuEnvolFotoFindIdPecuEnvolFoto(long idFoto)
            throws BusinessException;

    public byte[] getPecuEnvolFotoThumbnailFindIdPecuEnvolFoto(
            long idFotoThumbnail) throws BusinessException;

    public List<BopEnvolvidosOcorrencia> getEnvolvimentoOcorrencias(
            String nome, String nmMae, Date dtNasc) throws BusinessException;

    public BopRg getRg(BigDecimal idRg) throws BusinessException;

    public byte[] getImagemRg(long idRg) throws BusinessException;

    public byte[] getDocumentoBopAnexoOcorrencia(long idAnexo)
            throws BusinessException;

    public List<VwPessoa> getPessoaSispes(String nome, String nmMae, Date dtNasc)
            throws BusinessException;

    public void geraChamadoOcorrencia(BopOcorrencia bopOcorrencia,
            Comunicante comunicante) throws BusinessException;

    public boolean existeChamadoOcorrencia(BopOcorrencia bopOcorrencia)
            throws BusinessException;

    public BopOcorrencia mergeOcorrencia(BopOcorrencia ocorrencia,
            Comunicante comunicante) throws BusinessException;

    public BopEnvolvidosOcorrencia persistEnvolvidoOcorrencia(
            BopEnvolvidosOcorrencia bopEnvolvidosOcorrencia)
            throws BusinessException;

    public List<BopUsuarios> getUsuarioAll() throws BusinessException;

    public BopUsuarios mergeBopUsuario(BopUsuarios bopUsuarios)
            throws BusinessException;

    public List<BopUnidadePolicial> getListaUnidadePolicialCivil()
            throws BusinessException;

    public List<BopUnidadePolicial> getListaUnidadePolicialCivilByDsUnidPolicial(
            String dsUnidPolicial) throws BusinessException;

    public List<BopUnidadePolicial> getListaUnidadePolicialByUsuario(
            long cdUsuario) throws BusinessException;

    public List<BopUsuarioUnidadeDeon> getListaUsuarioUnidadeDeon(long cdUsuario)
            throws BusinessException;

    public List<BopUsuarioUnidadeDeon> removeBopUsuarioUnidadeDeon(
            BopUsuarioUnidadeDeon bopUsuarioUnidadeDeon)
            throws BusinessException;

    public List<BopEnvolvidosOcorrencia> getEnvolvimentoPesquisado(
            EnvolvidoTransient envolvidoTransiente, int inicio, int fim)
            throws BusinessException;

    public List<EnvolvidoTransient> getListaEnvolvidosOcorrencias(
            EnvolvidoTransient envolvidoTransiente, int inicio, int fim)
            throws BusinessException;

    public long getEnvolvimentoPesquisadoCount(
            EnvolvidoTransient envolvidoTransiente) throws BusinessException;

    public long getEnvolvimentoPesquisadoCountComTranslate(
            EnvolvidoTransient envolvidoTransiente) throws BusinessException;

    public List<BopProfissaoOcupacao> getOcupacaoPesquisado(int inicio,
            int fim, String cdProfOcup, String dsProfOcup)
            throws BusinessException;

    public long getOcupacaoPesquisadoCount(String cdProfOcup, String dsProfOcup)
            throws BusinessException;

    public List<BopUnidadePolicialFake> getBopUnidadePolicialFakeByAgenciaFiltro(
            int inicio, int fim, String cdUnidPolicial, String dsUnidPolicial,
            Long cdAgencia) throws BusinessException;

    public List<BopUnidadePolicial> getAllListaUnidadePolicail()
            throws BusinessException;

    public List<BopOcorrenciaAgencia> getListaOcorrenciaAgenciaByUnidadePolicial(
            BopUnidadePolicial bopUnidadePolicial) throws BusinessException;

    public List<BopTipoProvidenciaDeon> getAllBopTipoProvidencia()
            throws BusinessException;

    public List<BopTipoExameDeon> getAllBopTipoExameDeon()
            throws BusinessException;

    public void init();

    public List<BopEnderecoEnvolvido> getBopEnderecosEnvolvidoByEnvolvidoDeon(
            BopEnvolvidoOcorrenciaDeon envolvidoDeon) throws BusinessException;

    public BopEnderecoEnvolvido getUltimoEnderecoEnvolvido(
            Long codigoEnvolvidoDeon) throws BusinessException;

    public BopEnderecoEnvolvido salvaEnderecoEnvolvido(
            BopEnderecoEnvolvido enderecoEnvolvido) throws BusinessException;

    // criado apenas para se utilizada na apresentação para o governador
    // posteriormento o pesquisa será feita no Sisp
    public List<BopOcorrencia> getOcorrenciaEnvolvido(String nmEnvolvido)
            throws BusinessException;

    public List<BopOrientacaoSexual> getAllBopOrientacaoSexual()
            throws BusinessException;

    public BopChamadoOcorrencia getBopChamadoOcorrenciaByNrChamado(
            long nrChamado) throws BusinessException;

    public BopEnvolvidosOcorrencia getEnvolvidoOcorrenciaByRg(String nmRg,
            String cdUfRg) throws BusinessException;

    public BopEnvolvidosOcorrencia getEnvolvidoOcorrenciaByIdEnvolvido(
            long idEnvolvido, int nrBop, String tipoBop)
            throws BusinessException;

    public BopBairro getBairroByNmMunicipio(String nmUF, String nmMunicipio,
            String nmBairro) throws BusinessException;

    public List<BopIncidente> getListBopIncidenteByUnidadePolicialCivil()
            throws BusinessException;

    public List<BopAgencia> getListAgenciasPoliciais() throws BusinessException;

    public List<BopAgencia> getListAgenciaLocalTrabalho()
            throws BusinessException;

    public BopFuncionario getFuncionarioByIdRegistro(long idRegistro,
            long cdAgencia) throws BusinessException;

    public BopFuncionario getFuncionarioRgMilitar(
            BopFuncionario bopFuncionario, BopAgencia bopAgencia)
            throws BusinessException;

    public BopUsuarios getBopUsuarioByNomeAbrev(String nmAbrevUsuario)
            throws BusinessException;

    public List<BopTipoMunicaoDeon> getAllBopTipoMunicaoDeon()
            throws BusinessException;

    public List<BopMarcaMunicaoDeon> getAllBopMarcaMunicaoDeon()
            throws BusinessException;

    public List<BopCalibreArma> getAllBopCalibreArma() throws BusinessException;

    public List<BopCoronhaArmaDeon> getAllBopCoronhaArmaDeon()
            throws BusinessException;

    public List<BopConservacaoArmaDeon> getAllBopConservacaoArmaDeon()
            throws BusinessException;

    public List<BopTipoAcessorioArmaDeon> getAllBopTipoAcessorioArmaDeon()
            throws BusinessException;

    public BopUnidadePolicial mergeBopUnidadePolicial(
            BopUnidadePolicial bopUnidadePolicial) throws BusinessException;

    public List<BopFuncionario> getListDelegadosByUnidadePolicial(
            BopUnidadePolicial bopUnidadePolicial) throws BusinessException;

    public BopTipoProvidenciaDeon getBopTipoProvidenciaDeonById(
            int idTipoProvidencia) throws BusinessException;

    public List<BopUsuarios> getListBopUsuario(int indexPaginacao, int rows,
            String login, String nome, int agencia) throws BusinessException;

    public int getListBopUsuarioCount(String login, String nome, int agencia)
            throws BusinessException;

    public List<BopMotivoCancelamento> getListBopMotivoCancelamento()
            throws BusinessException;

    public BopTipoDocumento getTipoDocumentoById(long idTipoDocumento)
            throws BusinessException;

    public Date getSysDate() throws BusinessException;

    public BopPlanOperacional getPlanOperacional(BopOcorrencia bopOcorrencia,
            BopUnidadePolicial bopUnidadePolicial) throws BusinessException;

    public List<BopTipoDroga> getListBopTipoDroga() throws BusinessException;

    public List<BopMoedaDeon> getListBopMoedaDeon() throws BusinessException;

    public List<BopBancoDeon> getListBopBancoDeon() throws BusinessException;

    public List<VwDeonTipoArma> getTipoArmaFogo() throws BusinessException;

    public List<VwDeonTipoArma> getTipoArmaBranca() throws BusinessException;

    public <T> T refreshEntity(T t, Object object) throws BusinessException;

    public <T extends Serializable> T refreshEntity(Class<T> objClass, Object pk)
            throws BusinessException;

    public int getListaOcorrenciaCount(BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrEletro bopObjetoOcorrEletro) throws BusinessException;

    public List<BopOcorrencia> getListaOcorrencia(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrEletro bopObjetoOcorrEletro, int indexPaginacao,
            int rows) throws BusinessException;

    //Arma
    public int getQuantidadeObjetoArma(BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrArma bopObjetoOcorrArma, Date dataInicial,
            Date dataFinal, Date horaInicial, Date horaFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia)
            throws BusinessException;

    public int getListaOcorrenciaArmaCount(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrArma bopObjetoOcorrArma, Date dataInicial, Date dataFinal, Date horaInicial,
            Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    public List<ConsultaOcorrenciaObjTransient> getListaOcorrenciaArmaPaginado(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrArma bopObjetoOcorrArma, int indexPaginacao,
            int rows, Date dataInicial, Date dataFinal, Date horaInicial,
            Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    //Bicicleta
    public int getQuantidadeObjetoBicicleta(BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrBicicletaDeon bopObjetoOcorrBicicletaDeon,
            Date dataInicial, Date dataFinal, Date horaInicial, Date horaFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia)
            throws BusinessException;

    public int getListaOcorrenciaBicicletaCount(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrBicicletaDeon bopObjetoOcorrBicicletaDeon,
            Date dataInicial, Date dataFinal,
            Date horaInicial, Date horaFinal,
            Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado,
            BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    public List<ConsultaOcorrenciaObjTransient> getListaOcorrenciaBicicletaPaginado(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrBicicletaDeon bopObjetoOcorrBicicletaDeon,
            int indexPaginacao, int rows, Date dataInicial, Date dataFinal,
            Date horaInicial, Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    //Cartao
    public int getQuantidadeObjetoCartao(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrCartao bopObjetoOcorrCartao, Date dataInicial,
            Date dataFinal, Date horaInicial, Date horaFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia)
            throws BusinessException;

    public int getListaOcorrenciaCartaoCount(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrCartao bopObjetoOcorrCartao,
            Date dataInicial, Date dataFinal, Date horaInicial,
            Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    public List<ConsultaOcorrenciaObjTransient> getListaOcorrenciaCartaoPaginado(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrCartao bopObjetoOcorrCartao, int indexPaginacao,
            int rows, Date dataInicial, Date dataFinal, Date horaInicial,
            Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    //Cheque
    public int getQuantidadeObjetoCheque(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrCheque bopObjetoOcorrCheque, Date dataInicial,
            Date dataFinal, Date horaInicial, Date horaFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia)
            throws BusinessException;

    public int getListaOcorrenciaChequeCount(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrCheque bopObjetoOcorrCheque, Date dataInicial, Date dataFinal, Date horaInicial,
            Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado,
            BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    public List<ConsultaOcorrenciaObjTransient> getListaOcorrenciaChequePaginado(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrCheque bopObjetoOcorrCheque, int indexPaginacao,
            int rows, Date dataInicial, Date dataFinal, Date horaInicial,
            Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    //Dinheiro
    public int getQuantidadeObjetoDinheiro(BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrDinheiroDeon bopObjetoOcorrDinheiroDeon,
            Date dataInicial, Date dataFinal, Date horaInicial, Date horaFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia)
            throws BusinessException;

    public int getListaOcorrenciaDinheiroCount(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrDinheiroDeon bopObjetoOcorrDinheiroDeon, Date dataInicial, Date dataFinal,
            Date horaInicial, Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    public int getListaOcorrenciaPlacaVeicularCount(
            BopOcorrenciaObjeto bopOcorrenciaObjeto, String nrPlaca,
            BopObjetoOcorrPlacaVeicularDeon bopObjetoOcorrPlacaVeicularDeon, Date dataInicial, Date dataFinal,
            Date horaInicial, Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    public List<ConsultaOcorrenciaObjTransient> getListaOcorrenciaDinheiroPaginado(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrDinheiroDeon bopObjetoOcorrDinheiroDeon,
            int indexPaginacao, int rows, Date dataInicial, Date dataFinal,
            Date horaInicial, Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    public List<ConsultaOcorrenciaObjTransient> getListaOcorrenciaPlacaVeicularPaginado(
            BopOcorrenciaObjeto bopOcorrenciaObjeto, String nrPlaca,
            BopObjetoOcorrPlacaVeicularDeon bopObjetoOcorrPlacaVeicularDeon,
            int indexPaginacao, int rows, Date dataInicial, Date dataFinal,
            Date horaInicial, Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    //Documento
    public int getQuantidadeObjetoDocumento(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrDocumento bopObjetoOcorrDocumento, Date dataInicial,
            Date dataFinal, Date horaInicial, Date horaFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia)
            throws BusinessException;

    public int getListaOcorrenciaDocumentoCount(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrDocumento bopObjetoOcorrDocumento, Date dataInicial, Date dataFinal,
            Date horaInicial, Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    public List<ConsultaOcorrenciaObjTransient> getListaOcorrenciaDocumentoPaginado(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrDocumento bopObjetoOcorrDocumento,
            int indexPaginacao, int rows, Date dataInicial, Date dataFinal,
            Date horaInicial, Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    //Droga
    public int getQuantidadeObjetoDroga(BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrDroga bopObjetoOcorrDroga, Date dataInicial,
            Date dataFinal, Date horaInicial, Date horaFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia)
            throws BusinessException;

    public int getListaOcorrenciaDrogaCount(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrDroga bopObjetoOcorrDroga, Date dataInicial, Date dataFinal, Date horaInicial,
            Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    public List<ConsultaOcorrenciaObjTransient> getListaOcorrenciaDrogaPaginado(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrDroga bopObjetoOcorrDroga, int indexPaginacao,
            int rows, Date dataInicial, Date dataFinal, Date horaInicial,
            Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    //Telefone
    public int getQuantidadeObjetoTelefone(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrEletro bopObjetoOcorrEletro, Date dataInicial,
            Date dataFinal, Date horaInicial, Date horaFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia)
            throws BusinessException;

    public int getListaOcorrenciaTelefoneCount(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrEletro bopObjetoOcorrEletro, Date dataInicial, Date dataFinal, Date horaInicial,
            Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    public List<ConsultaOcorrenciaObjTransient> getListaOcorrenciaTelefonePaginado(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrEletro bopObjetoOcorrEletro, int indexPaginacao,
            int rows, Date dataInicial, Date dataFinal, Date horaInicial,
            Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    //Municao
    public int getQuantidadeObjetoMunicao(BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrMunicaoDeon bopObjetoOcorrMunicaoDeon,
            Date dataInicial, Date dataFinal, Date horaInicial, Date horaFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia)
            throws BusinessException;

    public int getListaOcorrenciaMunicaoCount(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrMunicaoDeon bopObjetoOcorrMunicaoDeon, Date dataInicial, Date dataFinal,
            Date horaInicial, Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    public List<ConsultaOcorrenciaObjTransient> getListaOcorrenciaMunicaoPaginado(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrMunicaoDeon bopObjetoOcorrMunicaoDeon,
            int indexPaginacao, int rows, Date dataInicial, Date dataFinal,
            Date horaInicial, Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    //Nota Fiscal
    public int getQuantidadeObjetoNotaFiscal(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrNotaFiscal bopObjetoOcorrNotaFiscal,
            Date dataInicial, Date dataFinal, Date horaInicial, Date horaFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia)
            throws BusinessException;

    public int getListaOcorrenciaNotaFiscalCount(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrNotaFiscal bopObjetoOcorrNotaFiscal, Date dataInicial, Date dataFinal,
            Date horaInicial, Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    public List<ConsultaOcorrenciaObjTransient> getListaOcorrenciaNotaFiscalPaginado(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrNotaFiscal bopObjetoOcorrNotaFiscal,
            int indexPaginacao, int rows, Date dataInicial, Date dataFinal,
            Date horaInicial, Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia) throws BusinessException;

    //Veiculo
    public int getQuantidadeObjetoVeiculo(BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrVeiculo bopObjetoOcorrVeiculo, Date dataInicial,
            Date dataFinal, Date horaInicial, Date horaFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia)
            throws BusinessException;

    public int getListaOcorrenciaVeiculoCount(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrVeiculo bopObjetoOcorrVeiculo,
            Date dataInicial, Date dataFinal, Date horaInicial, Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia)
            throws BusinessException;

    public List<ConsultaOcorrenciaObjTransient> getListaOcorrenciaVeiculoPaginado(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrVeiculo bopObjetoOcorrVeiculo, int inicio, int fim,
            Date dataInicial, Date dataFinal, Date horaInicial, Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia)
            throws BusinessException;

    //Geral
    public int getQuantidadeObjetoGeral(BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrGeral bopObjetoOcorrGeral, Date dataInicial,
            Date dataFinal, Date horaInicial, Date horaFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia)
            throws BusinessException;

    public int getListaOcorrenciaGeralCount(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrGeral bopObjetoOcorrGeral,
            Date dataInicial, Date dataFinal, Date horaInicial, Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia)
            throws BusinessException;

    public List<ConsultaOcorrenciaObjTransient> getListaOcorrenciaGeralPaginado(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrGeral bopObjetoOcorrGeral, int inicio, int fim,
            Date dataInicial, Date dataFinal, Date horaInicial, Date horaFinal, Date dataRegistroInicial, Date dataRegistroFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia)
            throws BusinessException;

    public int getListaOcorrenciaCount(BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrDocumento bopObjetoOcorrDocumento, Date dataInicial,
            Date dataFinal, Date horaInicial, Date horaFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado)
            throws BusinessException;

    public List<BopOcorrencia> getListaOcorrencia(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrDocumento bopObjetoOcorrDocumento,
            int indexPaginacao, int rows, Date dataInicial, Date dataFinal,
            Date horaInicial, Date horaFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado) throws BusinessException;

    public int getListaOcorrenciaCount(BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrCheque bopObjetoOcorrCheque) throws BusinessException;

    public List<BopOcorrencia> getListaOcorrencia(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrCheque bopObjetoOcorrCheque, int indexPaginacao,
            int rows, Date dataInicial, Date dataFinal, Date horaInicial,
            Date horaFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado) throws BusinessException;

    public int getListaOcorrenciaCount(BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrCartao bopObjetoOcorrCartao) throws BusinessException;

    public List<BopOcorrencia> getListaOcorrencia(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrCartao bopObjetoOcorrCartao, int indexPaginacao,
            int rows) throws BusinessException;

    public int getListaOcorrenciaCount(BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrNotaFiscal bopObjetoOcorrNotaFiscal)
            throws BusinessException;

    public List<BopOcorrencia> getListaOcorrencia(
            BopOcorrenciaObjeto bopOcorrenciaObjeto,
            BopObjetoOcorrNotaFiscal bopObjetoOcorrNotaFiscal,
            int indexPaginacao, int rows) throws BusinessException;

    public BopUnidadeResponsavelDeon getAtualResponsavelUnidadeDeon(
            BopUnidadePolicial pBopUnidadePolicial, char pStatusResponsavel,
            long pCdCargo) throws BusinessException;

    public BopProvidenciaEnvolvidoDeon getBopProvidenciaFindEnvolvido(
            BopEnvolvidosOcorrencia envolvidosOcorrencia, int idTipoProvidencia)
            throws BusinessException;

    public List<BopRuas> getListaRuasByBairro(BopBairro bopBairro)
            throws BusinessException;

    public List<BopRuasGeral> getListaRuasGeralByBairro(BopBairro bopBairro)
            throws BusinessException;

    public String removerEnvolvidosOcorrencia(
            BopEnvolvidosOcorrencia bopEnvolvidosOcorrencia)
            throws BusinessException;

    public void removerEnderecoEnvolvidos(
            BopEnderecoEnvolvido bopEnderecoEnvolvido) throws BusinessException;

    public BopOcorrencia finalizarOcorrencia(BopOcorrencia bopOcorrencia)
            throws BusinessException;

    public BopOcorrencia mergeOcorrenciaDadosOcorrencia(
            BopOcorrencia bopOcorrencia) throws BusinessException;

    public List<BopAgencia> getListAgenciaEnvEspecial()
            throws BusinessException;

    public List<VwAgencia> getListVwAgenciaEnvEspecial()
            throws BusinessException;

    public void removeProvidenciaPreso(
            BopProvidenciaPresoDeon bopProvidenciaPresoDeon)
            throws BusinessException;

    List<ConsultaOcorrenciaTransient> getListaConsultaInicialOcorrenciaTransient(
            OcorrenciaTransiente ocorrenciaTransient, int maxResult,
            Boolean isSigilosa, Long usuarioLogado, Boolean isSiplan)
            throws BusinessException;

    public List<ConsultaOcorrenciaObjTransient> getListaConsultaOcorrenciaTransient(
            OcorrenciaTransiente ocorrenciaTransient, int inicio, int fim,
            Date horaInicial, Date horaFinal, Date dataInicial, Date dataFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia)
            throws BusinessException;

    public int getListaConsultaOcorrenciaTransientCount(
            OcorrenciaTransiente ocorrenciaTransient, Date dataInicial,
            Date dataFinal, Date horaInicial, Date horaFinal, BopAgencia agenciaSelecionada, BopUnidadePolicial bopUnidadePolicialSelecionado, BopUnidadesFederacao ufSelecionado, BopMunicipio municipioSelecionado, BopBairro bairroSelecionado, BopIncidente incidenteSelecionado, String descricaoOcorrencia)
            throws BusinessException;

    public List<ConsultaOcorrenciaTransient> getListaConsultaOcorrenciaTransient(
            OcorrenciaTransiente ocorrenciaTransient, int maxResult,
            Date dataInicial, Date dataFinal, Date horaInicial, Date horaFinal,
            Long usuarioLogado) throws BusinessException;

    public List<ConsultaOcorrenciaTransient> getListaConsultaOcorrenciaTransientSemLimite(
            OcorrenciaTransiente ocorrenciaTransient, int maxResult,
            Date dataInicial, Date dataFinal, Date horaInicial, Date horaFinal,
            Boolean isSigilosa, Long usuarioLogado, Boolean isSiplan)
            throws BusinessException;

    public List<ConsultaOcorrenciaTransient> getListConsultaOcorrenciaTransitoTransient(
            ConsultaOcorrenciaTransient consultaOcorrenciaTransient)
            throws BusinessException;

    public List<ConsultaOcorrenciaTransient> getListaConsultaOcorrenciaTransitoTransient(
            int indexPaginacao, int rows,
            OcorrenciaTransiente ocorrenciaTransient, Date dataInicial,
            Date dataFinal, String nrPlaca) throws BusinessException;

    public List<ConsultaOcorrenciaTransient> getListaConsultaOcorrenciaTransitoTransientInicial(
            OcorrenciaTransiente ocorrenciaTransient, int maxResult)
            throws BusinessException;

    public int getListaConsultaOcorrenciaTransitoTransientCount(
            OcorrenciaTransiente ocorrenciaTransient, int maxResult,
            Date dataInicial, Date dataFinal, String nrPlaca)
            throws BusinessException;

    public BopChamado getBopOcorrenciaByNrBop(long nrBop)
            throws BusinessException;

    public void updateBopEnvOcorrFotoDeon(byte[] imFoto, byte[] imFotoOriginal,
            byte[] imThumbnail, long id) throws BusinessException;

    public void updateBopPeculiaridadeEnvolFotoDeon(byte[] imFoto,
            byte[] imFotoOriginal, byte[] imThumbnail, long id)
            throws BusinessException;

    public void updateBopAnexoOcorrencia(byte[] documento, long id)
            throws BusinessException;

    public List<VwBopCores> getCoresVeiculo() throws BusinessException;

    public List<BopUnidadePolicial> getListBopUnidadePolicial(
            int indexPaginacao, int rows, String nome, int agencia,
            boolean pesquisarApenasAgenciaDoUsuario) throws BusinessException;

    public int getListBopUnidadePolicialCount(String nome, int agencia,
            boolean pesquisarApenasAgenciaDoUsuario) throws BusinessException;

    public List<BopEnvolvidoSimples> getListaBopEnvolvidoSimples(
            BopOcorrencia bopOcorrencia, int inicio, int fim, String... param)
            throws BusinessException;

    public int getListaBopEnvolvidoSimplesCount(BopOcorrencia bopOcorrencia,
            String... param) throws BusinessException;

    public List<BopEnvolvidoSimples> getListaBopEnvolvidoSimplesFonema(
            BopOcorrencia bopOcorrencia, String dsNome, String dsApelido,
            Long idEnvolvimento, boolean isCheckNome, int inicio, int fim)
            throws BusinessException;

    public int getListaBopEnvolvidoSimplesFonemaCount(
            BopOcorrencia bopOcorrencia, String dsNome, String dsApelido,
            Long idEnvolvimento, boolean isCheckNome) throws BusinessException;

    public List<BopTipoLocomocaoDeon> getListaBopTipoLocomocaoDeon()
            throws BusinessException;

    public BopOcorrenciaAgencia mergeBopOcorrenciaAgencia(
            BopOcorrenciaAgencia bopOcorrenciaAgencia) throws BusinessException;

    public List<BopTipoCombustivel> getListBopTipoCombustivel()
            throws BusinessException;

    public List<BopTipoVeiculoDeon> getListBopTipoVeiculoDeon()
            throws BusinessException;

    public List<BopTipoVeiculoDeon> getListBopTipoVeiculoDeonView()
            throws BusinessException;

    public List<BopTipoVeiculoDeon> getListBopTipoVeiculoTransitoDeonView()
            throws BusinessException;

    public List<BopParteAvariaResolucao> getListBopParteAvariaResolucao()
            throws BusinessException;

    public List<BopParteAvariaResolucao> getListBopParteAvariaResolucaoByIdTipoVeiculo(
            long idTipoVeiculo) throws BusinessException;

    public List<BopParteAvariaResolucao> getListBopParteAvariaResolucaoByIdTipoVeiculoAndResolucao(
            long idTipoVeiculo, long idResolucao) throws BusinessException;

    public boolean ExisteListBopObjetoOcorrVeiculo(long nrBop, String tipoBop,
            long idEnvolvido) throws BusinessException;

    public BopAvariaVeiculoResolucao getBopAvariaVeiculoResolucaoByNrBopAndTipoBop(
            long nrBop, String tipoBop) throws BusinessException;

    public List<BopTipoCaracteristicasParte> getListBopTipoCaracteristicasParte()
            throws BusinessException;

    public <T extends Serializable> T mergeEntity(T object)
            throws BusinessException;

    public <T extends Serializable> T findEntity(Class<T> objClass, Object pk)
            throws BusinessException;

    public List<BopCondicaoObjetoDeon> getAllBopCondicaoObjetoDeon()
            throws BusinessException;

    public List<BopOrigemRecuperacaoDeon> getAllBopOrigemRecuperacaoDeon()
            throws BusinessException;

    public List<BopTipoAcaoObjetoDeon> getAllBopTipoAcaoObjetoDeon()
            throws BusinessException;

    public List<BopTipoAcaoObjetoDeon> getBopTipoAcaoObjetoDeonTransito()
            throws BusinessException;

    public BopChamado getBopChamadoByNrChamado(long nrChamado)
            throws BusinessException;

    public List<BopDespachoAndamento> getBopDespachoAndamento(long nrChamado,
            long cdUnidPolicial) throws BusinessException;

    public List<BopSeguradoraDeon> getAllSeguradoras() throws BusinessException;

    public List<ConsultaOcorrenciaEnvolvidoTransient> getListOcorrenciaEnvolvidos(
            Long codAgencia, Long codUnidadePolicial, Date dataInicio,
            Date dataFim, Date horaInicio, Date horaFim)
            throws BusinessException;

    public int getCountListOcorrenciaEnvolvidos(Long codAgencia,
            Long codUnidadePolicial, Date dataInicio, Date dataFim,
            Date horaInicio, Date horaFim) throws BusinessException;

    public ConsultaDocumentoEnvoEspecialFake getConsultarDocumentoEnvoEspecial(
            BopTipoDocumento bopTipoDocumento, String nrDocumento)
            throws BusinessException;

    public BopOcorrencia devolverOcorrencia(BopOcorrencia bopOcorrencia)
            throws BusinessException;

    public List<BopMotivoDevolucaoDeon> getAllMotivoDevolucao()
            throws BusinessException;

    public BopOcorrencia finalizarOcorrencia(BopOcorrencia bopOcorrencia,
            BopUsuarios bopUsuario, BopUnidadePolicial bopUnidadePolicial)
            throws BusinessException;

    public List<VwDeonAcabamentoArma> getAllVwDeonAcabamentoArma()
            throws BusinessException;

    public List<VwDeonFuncionamentoArma> getAllVwDeonFuncionamentoArma()
            throws BusinessException;

    public List<BopUsuarioUnidadeDeon> getListBopUsuarioUnidadeDeon(
            long cdUnidPolicial) throws BusinessException;

    public List<BopUsuarios> getListBopUsuarioByUnidadeNotCargo(
            long cdUnidPolicial, long cdCargo) throws BusinessException;

    public List<BopUsuarios> getListBopUsuarioByUnidadeCargo(
            long cdUnidPolicial, long cdCargo) throws BusinessException;

    public List<BopUsuarios> getListBopUsuarioUnidadePolicialCargoByAgencia(
            long cdCargo, long cdAgencia) throws BusinessException;

    public List<BopUsuarios> getListBopUsuarioCargoNotDelegado(long cdCargo)
            throws BusinessException;

    public List<BopUtilidadeVeiculoDeon> getAllBopUtilidadeVeiculoDeon()
            throws BusinessException;

    public List<BopTipoLocal> getTipoLocaisFurto() throws BusinessException;

    public List<BopTipoMedidaProtetivaDeon> getAllTipoMedidaProtetivaDeon()
            throws BusinessException;

    public BopInformacaoInicial getSuporteTecnico() throws BusinessException;

    public BopInformacaoInicial getMaterialApoio() throws BusinessException;

    public BopInformacaoInicial mergeInformacaoInicial(
            BopInformacaoInicial bopInformacaoInicial) throws BusinessException;

    public BopNoticiaDeon mergeNoticiaDeon(BopNoticiaDeon bopNoticiaDeon)
            throws BusinessException;

    public List<BopNoticiaDeon> getNoticiasAtiva() throws BusinessException;

    public List<BopNoticiaDeon> getNoticias() throws BusinessException;

    public List<BopTipoNoticiaDeon> getListaTipoNoticia()
            throws BusinessException;

    public List<DeonIncidenteProv> getAllDeonIncidenteProv()
            throws BusinessException;

    public Long countMedidaProtetiva(String nrMedidaProtetiva,
            Long cdUnidPolicial, Long cdAgencia) throws BusinessException;

    public Long countProvidenciaEnvolvido(String cdIdentificador,
            Long cdUnidPolicial, Long cdAgencia, Long idTipoProvidencia)
            throws BusinessException;

    public List<ViewConsultaUnificadaDet> getDetalhamentoOcorrencia(
            int nrOcorrencia) throws BusinessException;

    public List<BopTipoLocalEncamDeon> getAllBopTipoLocalEncamDeon()
            throws BusinessException;

    public BopAcessoUsuarioOcorDeon getAcessoOcorrencia(
            BopOcorrencia bopOcorrencia, BopUsuarios bopUsuarioLogado)
            throws BusinessException;

    public boolean existeDespachoAgencia(Long agencia, String nrChamadoSigilosa)
            throws BusinessException;

    public BopTipoLocalEncamDeon insertBopTipoLocalPadraoUnidadePolicial(
            BopTipoLocalEncamDeon bopTipoLocal,
            BopUnidadePolicial bopUnidadePolicial) throws BusinessException;

    public BopTipoLocalEncamDeon retornaTipoLocalPadraoUnidadeLogada(
            BopUnidadePolicial bopUnidadePolicial) throws BusinessException;

    public boolean podeGerarOcorrencia(
            BopUnidadePolicial bopUnidadePolicialUsuarioLogado)
            throws BusinessException;

    public void copiarViaturasChamado(String nrChamado)
            throws BusinessException;

    public BopChamadoOcorrencia getBopChamadoOcorrenciaByNrBopTipoBop(
            long nrBop, String tipoBop) throws BusinessException;

    public BopPeculiaridadeEnvolvido mergeBopPeculiaridadeEnvolDeon(
            BopPeculiaridadeEnvolvido bopPeculiaridadeEnvolvido)
            throws BusinessException;

    public BopPeculiaridadeEnvolFoto insertBopPeculiaridadeEnvolFoto(
            BopPeculiaridadeEnvolFoto peculiaridadeFoto)
            throws BusinessException;

    public void updateFotoPrincipalEnvolvido(long idFoto, long id)
            throws BusinessException;

    @SuppressWarnings("rawtypes")
    public void clearCache(Class... classes);

    public BopModeloMatApreendido getBopModeloMatApreendido(
            BopModeloMatApreendidoPK pk) throws BusinessException;

    // public List<BoletimEntity> findAllBoletimEntity( Long codigoAgencia, Long
    // codigoUnidade, String dataInicio, String dataFim, String horaInicio,
    // String horaFim );
    public List<UnidadeEntity> findAllUnidade(Long nrBop, String tipoBop)
            throws BusinessException;

    public List<ViaturaEntity> findAllViatura(Long nrBop, String tipoBop,
            Long codigoAgencia, Long codigoUnidade) throws BusinessException;

    public List<DetidoConduzidoEntity> findAllDetidoConduzidoMenor(Long nrBop,
            String tipoBop) throws BusinessException;

    public List<DetidoConduzidoEntity> findAllDetidoConduzidoMaior(Long nrBop,
            String tipoBop) throws BusinessException;

    public List<DrogaEntity> findAllDroga(Long nrBop, String tipoBop)
            throws BusinessException;

    public List<ArmaEntity> findAllArma(Long nrBop, String tipoBop)
            throws BusinessException;

    public List<MunicaoEntity> findAllMunicao(Long nrBop, String tipoBop)
            throws BusinessException;

    public List<AcessorioEntity> findAllAcessorio(Long nrBop, String tipoBop)
            throws BusinessException;

    public List<DinheiroEntity> findAllDinheiro(Long nrBop, String tipoBop)
            throws BusinessException;

    public List<VeiculoEntity> findAllVeiculo(Long nrBop, String tipoBop)
            throws BusinessException;

    public BopEnderecoEnvolvido getUltimoBopEnderecoEnvolvidoByEnvolvidoDeon(
            BopEnvolvidosOcorrencia bopEnvolvidoOcorrencia)
            throws BusinessException;

    public BopEnderecoEnvolvido getBopEnderecoEnvolvidoByEnvolvidoDeon(
            BopEnvolvidoOcorrenciaDeon bopEnvolvidoOcorrenciaDeon)
            throws BusinessException;

    public <T extends Serializable> T mergeObject(T object)
            throws BusinessException;

    public Long getNextValueNumeroRelatorio() throws BusinessException;

    public List<BopEnvolvidoTipoEnvolvido> getListaBopEnvolvidoTipoEnvolvido(
            Long nrChamado, Long idEnvolvidoDeon) throws BusinessException;

    public List<BopEnvolvidoTipoEnvolvido> getListaBopEnvolvidoTipoEnvolvido(
            Long idEnvolvidoDeon) throws BusinessException;

    public BopEnvolvidoTipoEnvolvido getListaBopEnvolvidoTipoEnvolvidoByAgencia(
            Long idEnvolvidoDeon, Long cdAgencia, Long cdUnidPolicial)
            throws BusinessException;

    public void atualizaMontaVeiculo(BopAvariaVeiculoFake bopAvariaVeiculoFake)
            throws BusinessException;

    public List<BopAvariaVeiculoFake> getVeiculosOcorreciaTransito(Long nrBop,
            String tpBop) throws BusinessException;

    public ConsultaOcorrenciaTransient getOcorrenciaTransitoTransient(
            ConsultaOcorrenciaTransient ocorrenciaTransitoTransient)
            throws BusinessException;

    public List<BopFuncionario> getListBopPolicial(int indexPaginacao,
            int rows, String nmGuerra, BigDecimal nrFuncional, Boolean somentePC)
            throws BusinessException;

    public int getListBopPolicialCount(String nmGuerra, BigDecimal nrFuncional,
            Boolean somentePC) throws BusinessException;

    public List<BopViatura> getListBopViatura(int indexPaginacao, int rows,
            String cdViatura, String dsUnidadePolicial, Long codigoAgencia)
            throws BusinessException;

    public int getListBopViaturaCount(String cdViatura,
            String dsUnidadePolicial, Long codigoAgencia)
            throws BusinessException;

    public List<BopViatura> getListAllBopViatura(int indexPaginacao, int rows,
            String cdViatura, String dsUnidadePolicial)
            throws BusinessException;

    public int getListAllBopViaturaCount(String cdViatura,
            String dsUnidadePolicial) throws BusinessException;

    public Boolean usuarioAlocadoUnidadeSiplan(long usuario,
            String codigoUnidade) throws BusinessException;

    public Boolean usuarioAlocadoUnidadeDHPP(long usuario)
            throws BusinessException;

    public BopUnidadePolicial getBopUnidadePolicialById(long cdUnidadePolicial)
            throws BusinessException;

    public BopOcorrenciaAgencia getBopOcorrenciaAgenciaByOcorrencia(
            BopOcorrencia bopOcorrenciaTmp,
            BopUnidadePolicial unidadePolicialLogada) throws BusinessException;

    public List<SinqTipoProced> getAllSinqTipoProced() throws BusinessException;

    public List<BopTipoMeioSolicitado> getAllMeioSolicitado()
            throws BusinessException;

    public Boolean unidadeLogadaPodeEditarOcorrencia(String nrBop,
            BopUnidadePolicial bopUnidadePolicialUsuarioLogado)
            throws BusinessException;

    public void definirDataInicioConfeccao(String nrChamado,
            BopUnidadePolicial bopUnidadePolicialUsuarioLogado)
            throws BusinessException;

    public Boolean existeOutraUnidadeConfeccionando(String nrChamado,
            BopUnidadePolicial bopUnidadePolicialUsuarioLogado)
            throws BusinessException;

    public boolean isPrimeiraTentativaAcesso(String nrChamado,
            BopUnidadePolicial bopUnidadePolicialUsuarioLogado)
            throws BusinessException;

    public List<String> carregarUnidadesConfeccionando(
            String numeroChamadoString,
            BopUnidadePolicial unidadePolicialUsuarioLogado)
            throws BusinessException;

    public byte[] getImagemBUByOcorrenciaAgencia(Long cdOcorrenciaAgencia,
            Long cdAgencia, Long cdUnidadePolicial) throws BusinessException;

    public boolean isEnvolvidoEmOcorrencia(
            BopEnvolvidosOcorrencia bopEnvolvidosOcorrencia)
            throws BusinessException;

    public BopOcorrenciaAgenciaFato getOcorrenciaAgenciaFatoByOcorrenciaAgencia(
            BopOcorrenciaAgencia bopOcorrenciaAgencia) throws BusinessException;

    public void atualizarIncidenteBopOcorrencia(BopOcorrencia bopOcorrencia)
            throws BusinessException;

    public BopObjetoOcorrEletro mergeBopObjetoOcorrEletro(
            BopObjetoOcorrEletro bopObjetoOcorrEletro) throws BusinessException;

    public <T> void remove(T object) throws BusinessException;

    public BopEnvolvidoOcorrenciaDeon findEnvolvidoOcorrenciaDeon(
            Long idEnvolvidoOcorrenciaDeon) throws BusinessException;

    public List<BopOcorrenciaAgencia> getListaOcorrenciaAgenciaByOcorrencia(
            BopOcorrencia bopOcorrencia) throws BusinessException;

    public BopOcorrencia getBopOcorrenciaByNrChamado(String nrChamadoPesquisa)
            throws BusinessException;

    public BopOcorrenciaAgencia getBopOcorrenciaAgenciaByNrChamado(
            String nrChamadoPesquisa) throws BusinessException;

    public int findResponsavelOcorrenciaByOcorrencia(
            BopOcorrencia bopOcorrencia, BopUsuarios objetoSessao)
            throws BusinessException;

    public List<BopOcorrenciaAgencia> findOcorrenciaAgenciaStatus(int nrBop,
            String tipoBop, Long cdAgencia, int status)
            throws BusinessException;

    public List<BopOcorrenciaAgencia> findOcorrenciaAgenciaStatusDiferente(
            long nrChamado, long unidadePol, long agencia, int status)
            throws BusinessException;

    public void removerBopOcorrenciaSubTipoLocal(int nrBop, String tipoBop)
            throws BusinessException;

    public BopOcorrenciaSubTipoLocal getBopOcorrenciaSubTipoLocal(int nrBop,
            String tipoBop) throws BusinessException;

    public void fimLavraturaMergeOcorrenciaDeon(BopOcorrenciaDeon ocorrenciaDeon)
            throws BusinessException;

    public BopDDDConfig getBopDDDConfig(String nrDDD) throws BusinessException;

    public List<BopEnvolvidoSimples> getListaBopEnvolvidoSimplesFonemaEdicao(
            BopOcorrencia bopOcorrencia, String dsNome)
            throws BusinessException;

    public List<BopEnvolvidosOcorrencia> getEnvolvidosOcorrencias(
            BopOcorrencia bopOcorrencia) throws BusinessException;

    public BopOcorrenciaAgencia getOcorrenciaAgenciaByOcorrenciaEUnidadePolicial(
            BopOcorrencia ocorrencia, BopUnidadePolicial unidadePolicial)
            throws BusinessException;

    public BopEnvolvidoTipoEnvolvido getBopEnvolvidoTipoEnvolvido(
            BopEnvolvidoOcorrenciaDeon bopEnvolvidoOcorrenciaDeon)
            throws BusinessException;

    public BopObjetoOcorrVeiculo getVeiculoByCondutor(
            BopEnvolvidosOcorrencia bopEnvolvidosOcorrencia)
            throws BusinessException;

    public Long getUltimoSequencialVeiculo(long nrBop, String tipoBop)
            throws BusinessException;

    public void atualizarBopOcorrenciaAgencia(BopUsuarios bopUsuarios,
            BopUnidadePolicial bopUnidadePolicialUsuarioLogado,
            BopOcorrencia bopOcorrencia) throws BusinessException;

    public List<ConsultaOcorrenciaTransient> getListaConsultaOcorrenciaSigilosaTransient(
            OcorrenciaTransiente ocorrenciaTransient, int maxResult,
            Date dataInicial, Date dataFinal, Date horaInicial, Date horaFinal,
            Boolean isSigilosa, Long usuarioLogado, Boolean isSiplan)
            throws BusinessException;

    public List<ConsultaOcorrenciaTransient> getListaConsultaInicialOcorrenciaSigilosaTransient(
            OcorrenciaTransiente ocorrenciaTransient, int maxResult,
            Boolean isSigilosa, Long usuarioLogado, Boolean isSiplan)
            throws BusinessException;

    public BopEnvolvidoOcorrenciaDeon findEnvolvidoOcorrenciaDeonByNrTipoIdEnvolvido(
            long nrBop, String tipoBop, long idEnvolvido)
            throws BusinessException;

    public BopOcorrenciaAgenciaDeon getBopOcorrenciaAgenciaDeon(
            ConsultaOcorrenciaTransient consultarOcorrenciaTransient)
            throws BusinessException;

    public BopVeiculoPassageiroDeon getBopVeiculoPassageiroDeonByIdEnvolvido(
            Long idEnvolvido) throws BusinessException;

    OcorrenciaTransito buscaOcorrenciaTransito(BopOcorrenciaDeon ocorrencia)
            throws BusinessException;

    public OcorrenciaTransito buscaOcorrenciaTransitoByBopOcorrencia(
            BopOcorrencia bopOcorrencia) throws BusinessException;

    public BopEnvolvidosOcorrencia getEnvolvidoOcorrenciaByNrTipoNome(
            long nrBop, String tipoBop, String nmComplEnvol)
            throws BusinessException;

    public boolean existeEnvolvidosOcorrencia(BopOcorrencia bopOcorrencia)
            throws BusinessException;

    public boolean existeAgenciaConfeccionando(
            ConsultaOcorrenciaTransient ocorrenciaTransient)
            throws BusinessException;

    public Long getTipoVeiculoOcorrencia(
            BopObjetoOcorrVeiculo bopObjetoOcorrVeiculo)
            throws BusinessException;

    public BopObjetoEnvolvidoDeon getBopObjetoEnvolvidoDeon(long nrBop,
            String tipoBop, long idObjeto) throws BusinessException;

    public boolean unidadeLatLong(
            BopUnidadePolicial bopUnidadePolicialUsuarioLogado)
            throws BusinessException;

    public void atualizaUnidadePolicial(
            BopUnidadePolicial unidadePolicialSelecionada,
            String exibeLatitudeLongitude) throws BusinessException;

    List<BopUnidadePolicial> carregarUnidadesLatitudeLongitude()
            throws BusinessException;

    List<BopObjetoOcorrVeiculo> getVeiculoOcorrencia(BopOcorrencia bopOcorrencia)
            throws BusinessException;

    void insertBopObjetoUnidadePolicialDeon(BopUnidadePolicial unidadePolicial,
            BopObjetoOcorrVeiculo objetoOcorrVeiculo) throws BusinessException;

    BopObjetoUnidadePolicialDeon getVeiculoDaOcorrenciaPorUnidadePolicial(
            BopOcorrencia bopOcorrencia, BopUnidadePolicial unidadePolicial,
            BopObjetoOcorrVeiculo bopObjetoOcorrVeiculo)
            throws BusinessException;

    public List<BopOcorrenciaSubTipoLocal> getListaBopOcorrenciaSubTipoLocal(
            Long cdTipoLocal) throws BusinessException;

    public List<BopSubTipoLocal> getSubTipoLocal(Long cdTipoLocal)
            throws BusinessException;

    public BopEnvolvidoTipoEnvolvido getEnvolvidoTipoEnvol(
            BopEnvolvidoOcorrenciaDeon bopEnvolvidoOcorrenciaDeon)
            throws BusinessException;

    public byte[] getBrasaoAgencia(BopAgencia agencia) throws BusinessException;

    public List<BopProfissaoOcupacao> getListaProfissaoOcupacao(String query)
            throws BusinessException;

    public Boolean podeExcluirAnexoDigital(BopAnexoOcorrencia anexoOcorrencia,
            BopUsuarios bopUsuarioLogado,
            BopUnidadePolicial bopUnidadePolicialUsuarioLogado)
            throws BusinessException;

    public List<BopOcorrenciaObjeto> getListaObjetosSalvosParaValidacao(
            BopOcorrencia ocorrencia) throws BusinessException;

    public VwDeonMarcaObjeto getMarcaByDescricao(String string)
            throws BusinessException;

    public BopModeloMatApreendido getModeloByDescricao(String string)
            throws BusinessException;

    public VwBopCores getCorByDescricao(String cor) throws BusinessException;

    BopTipoCombustivel getTipoCombustivelByDescricao(String desc)
            throws BusinessException;

    public BopModeloMatApreendido getModeloByDescricaoEMarca(String modelo,
            Integer cdMarca) throws BusinessException;

    public BopMarcaModeloDenatran getMarcaModeloDenatran(String trim)
            throws BusinessException;

    public Boolean verificaObjetoEnvolvido(BopEnvolvidosOcorrencia bopEnvolvidoOcorDeletar) throws BusinessException;

    public Boolean verificaIncidenteEvolucao(String incidente) throws BusinessException;

    public Boolean verificaEnvolvidoVitima(BopOcorrencia ocorrencia, BopUnidadePolicial unidade) throws BusinessException;

    public void atualizarSituacaoEvolucao(BopOcorrencia ocorrencia, String statusEvolucao) throws BusinessException;

    public List<BopMotivoEvolucaoOcorEnv> getListaMotivoEvolucaoOcorEnv() throws BusinessException;

    public List<BopMeioEvolucaoOcorEnv> getListaMeioEvolucaoOcorEnv() throws BusinessException;

    public BopOcorrenciaEvolucaoEnvol mergeBopOcorrenciaEvolucaoEnvol(BopOcorrenciaEvolucaoEnvol bopOcorrenciaEvolucaoEnvol) throws BusinessException;

    public List<BopCutisEvolucao> findAllCutisEvolucao() throws BusinessException;

    public BopOcorrenciaEvolucaoEnvol getEvolucaoEnvol(Long id) throws BusinessException;

    public void removerEvolucaoEnvol(Long id, String nmAbrevUsuario) throws BusinessException;

    public List<EvolucaoOcorrenciaEnvolvido> getListEvolucaoOcorrEvol(int intValue) throws BusinessException;

    public List<BopMunicipio> getMunicipioEvolucao(String cdUf, boolean comNaoInformado) throws BusinessException;

    public List<BopBairro> getBairroEvolucao(Long cdMunicipio, String cdUf, boolean comNaoInformado) throws BusinessException;

    public BopOcorrenciaEvolucaoOcorr mergeBopOcorrenciaEvolucaoOcor(BopOcorrenciaEvolucaoOcorr bopOcorrenciaEvolucaoOcor) throws BusinessException;

    public void removerEvolucaoOcorr(Long id, String nmAbrevUsuario) throws BusinessException;

    public BopOcorrenciaEvolucaoOcorr getEvolucaoOcorr(Long id) throws BusinessException;

    public boolean isParticipacaoPC(int nrBop, String tipoBop) throws BusinessException;

    public String verificaStatusOcorrencia(Long cdAgencia, int nrBop, String tipoBop) throws BusinessException;

    public List<ConsultaImeiTransiente> getOcorrenciaImeiRelacionado(String dsImei, String dsImei2, String dsImei3, String dsImei4, int nrBop) throws BusinessException;

    public boolean isExisteAgenciaDeon(Long cdOcorrenciaAgencia) throws BusinessException;

    public BopOcorrenciaAgenciaDeon getBopOcorrenciaAgenciaDeon(Long cdOcorrenciaAgencia) throws BusinessException;

    public List<BopOcorrenciaAgencia> getOcorrenciaAgenciaUltAtualizacao(long nrChamado, long unidade) throws BusinessException;

    public boolean tentativaAcessoMenorTrintaMinutos(Date ultimaAtualizacao) throws BusinessException;

    public String getEmailUnidade(Long imeiUnidade) throws BusinessException;

    public String getAlertaTextoParametroFlCriminal(String texto) throws BusinessException;

    public String getAlertaCorParametroFlCriminal(String cor) throws BusinessException;

    public void calculaMonta(Long nrBop, String tipoBop) throws BusinessException;

    public int verificarDenuncia(Long nrChamado) throws BusinessException;

    public void geraRespotaDifusao(Long idDenuncia, Long unidadePolicial, String usuarioLogado, Long nrChamado) throws BusinessException;

    public BopOcorrDenunciaRelacionada mergeBopOcorrDenunciaRelacionada(BopOcorrDenunciaRelacionada bopOcorrDenunciaRelacionada) throws BusinessException;

    public void removerBopOcorrDenunciaRelacionada(BopOcorrDenunciaRelacionada bopOcorrDenunciaRelacionada) throws BusinessException;

    public List<BopOcorrDenunciaRelacionada> getListaBopOcorrDenunciaRelacionada(String nrChamado) throws BusinessException;

    public Long verificaRelacionamentoDenunciaAnonima(int nrBop, String TipoBop) throws BusinessException;

    public BopLogOcorrEmailEnvolvido persistLogOcorrEmailEnvolvido(BopLogOcorrEmailEnvolvido bopLogOcorrEmailEnvolvido) throws BusinessException;

    public BopEnvolvidoTipoEnvolvido getEnvolvidoTipEnvol(BopEnvolvidoTipoEnvolvido envolvidoTipoEnvolvido) throws BusinessException;

    public List<String> getImeisOcorrencia(int nrBop, String TipoBop, Long idEletroDeon) throws BusinessException;

    public List<BopHistEvolucaoDesaparecido> getHistoricoEvolucaoDesaparecido(Long idEnvolvidoDeon) throws BusinessException;

    public List<DeonSituacaoDesaparecido> getAllSituacaoEnvolvidoDesaparecido() throws BusinessException;

    public void removerAnexoEnvDesaparecido(Long idEnvolvidoDeon) throws BusinessException;

    public List<DeonOcorrenciaAnexoProv> getAllBopAnexoOcorrencia(Long idOcorrencia) throws BusinessException;

    public DeonAnexoEnvDesaparecido findDeonAnexoDesaparecidoProv(Long idEnvolvido);

    public Long existeFotoDesaparecido(Long idEnvolvidoDeon) throws BusinessException;

    public BopUnidadePolicialDeon getBopUnidadePolicialDeon(Long idAgencia, Long idUnidade) throws BusinessException;

    public List<BopUnidadePolicialDeon> getAllBopUnidadePolicialDeonTco() throws BusinessException;

    public List<SinqTemplate> getListSinqTemplate(int indexPaginacao, int rows, String nome, Integer codigo, long cdAgencia) throws BusinessException;

    public int getListSinqTemplateCount(String nome, Integer codigo , long cdAgencia) throws BusinessException;

    public List<DeonIncidentePecaTco> getAllDeonIncidentePecaTco() throws BusinessException;

    public void removerDeonIncidentePecaTco(String tpIncidente, Long idTemplate) throws BusinessException;

    public List<SinqPecaGeradaDTO> getPecasTco(Long nrBop, String tipoBop, Long idRegistroRespo) throws BusinessException;

    public Long getIdRegistroResponsavel(String tipoBop, Long nrBop, BopUnidadePolicial unidadePolicial) throws BusinessException;

    public byte[] gerarPDFPecaAnexo(SinqPecaGeradaInq pecaGeradaInq) throws Exception;

    public byte[] prepararHTMLDocumento(SinqPecaAnexo pecaAnexo) throws Exception;

    public SinqPecaAnexo findPecaAnexoById(Long idPecaGeradaInq) throws BusinessException;

    public byte[] gerarPDFPecas(List<SinqPecaGeradaDTO> listaSinqPecaCadernoProced, boolean agenciaTCO) throws Exception;

    public byte[] gerarPDFPecaTemplate(SinqPecaGeradaDTO sinqPecaTemplate, boolean imprimindoCaderno, boolean agenciaTCO) throws BusinessException;

    public void atualizaLongitudeOcorrenciaInternet(Double latitude, Double longitude, Long protocolo) throws BusinessException;

    public void atualizarListaIncidente() throws BusinessException;

}
